package br.com.unipe.aula.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.unipe.aula.model.Instrutor;

@Repository
public class InstrutorDAO {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public InstrutorDAO() {
        
    }
    
    @Transactional(readOnly=false)
    public void salvar(Instrutor instrutor) {
        entityManager.persist(instrutor);
    }
    
    @Transactional(readOnly=true)
    public List<Instrutor> getAll() { 
        return entityManager.createQuery("from Instrutor", Instrutor.class).getResultList();
    }
    
    @Transactional(readOnly=true)
    public Instrutor getId(Long id) {
        return entityManager.find(Instrutor.class, id);
    }
    
    @Transactional(readOnly=false)
    public void excluir(Long id) {
        entityManager.remove(getId(id));
    }
    
    @Transactional(readOnly=false)
    public void editar(Instrutor instrutor) {
        entityManager.merge(instrutor);
    }
}
