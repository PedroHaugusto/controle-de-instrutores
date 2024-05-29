package br.com.unipe.aula.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.unipe.aula.dao.InstrutorDAO;
import br.com.unipe.aula.model.Instrutor;

@Controller
public class WelcomeController {
    
    @Autowired
    private InstrutorDAO dao;
    
    @RequestMapping(value = "/formulario", method = RequestMethod.GET)
    public ModelAndView formulario(Model model) {
        ModelAndView view = new ModelAndView("formulario");
        model.addAttribute("instrutor", new Instrutor());
        view.addObject("instrutores", dao.getAll());
        view.addObject("frase","Digite o nome do instrutor e o curso!");
        return view;
    }
    
    @RequestMapping(value = "/formulario", method = RequestMethod.POST)
    public ModelAndView exibefrase(@ModelAttribute Instrutor instrutor) {
        ModelAndView view = new ModelAndView("formulario");
        dao.salvar(instrutor);
        view.addObject("instrutores", dao.getAll());
        view.addObject("frase", instrutor.getInstrutor() + " é o instrutor do curso " + instrutor.getCurso());
        return view;
    }
    
    @GetMapping(value="/excluir/{id}")
    public String excluirInstrutor(@PathVariable("id") Long id, Model model) {
        dao.excluir(id);
        return "redirect:../formulario";
    }
    
    @GetMapping(value="/editar/{id}")
    public ModelAndView exibeEditarInstrutor(@PathVariable("id") Long id, Model model) {
        ModelAndView view = new ModelAndView("editar");
        model.addAttribute("instrutor", dao.getId(id));
        return view;
    }

    
    @PostMapping(value="/editar/{id}")
    public String confirmaEdicaoInstrutor(@PathVariable("id") int id, @ModelAttribute Instrutor instrutor) {
        dao.editar(instrutor);
        return "redirect:../formulario";
    }

} 
