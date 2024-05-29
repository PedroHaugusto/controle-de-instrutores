<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Controle de Instutores</title>
<spring:url var="css" value="/static/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="${css}" />
</head>
<body>
    <div class="container">
    <form:form method="POST" modelAttribute="instrutor">
    <h1>Controle de Instrutores</h1>
    <p class="form-control">Instrutor: <form:input path="instrutor" class="mr-sm-2"/></p>
    <p class="form-control">Curso: <form:input path="curso" class="mr-sm-2" /></p>
    <p><form:button class="btn btn-primary">Cadastrar</form:button></p>
    </form:form>
    <p>${frase}</p>
    <table class="table table-hover">
        <thead>
            <th>INSTRUTOR</th>
            <th>CURSO</th>
            <th>AÇÕES</th>
        </thead>
        <tbody>
            <c:forEach var="instrutor" items="${instrutores}">
            <tr >
                <td>${instrutor.instrutor}</td>
                <td>${instrutor.curso}</td>
                <td><a href="editar/${instrutor.id}">Editar</a> | <a href="excluir/${instrutor.id}">Excluir</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
</body>
</html>
