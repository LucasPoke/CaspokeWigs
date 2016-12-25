<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>CaspokeWigs</title>
		<meta charset="utf-8">
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  	<script src="https://use.fontawesome.com/126680faf3.js"></script>
	</head>
  	<body>
  		<c:import url="/WEB-INF/views/cabecalho.jsp"/>
  
	    <h2>Página inicial do CaspokeWigs</h2>
	    <p>Bem vindo, ${usuarioLogado.nome}</p> <br />
	    <a href="listaClientes">Clique aqui</a> para administrar Clientes<br />
	    <a href="listaPerucas">Clique aqui</a> para administrar Perucas<br />
	    <a href="listaPerucasBase">Clique aqui</a> para administrar Perucas Base<br />
	    <br/>
	    <a href="listaOrcamentos">Clique aqui</a> para administrar Orcamentos<br />
	    <a href="listaEncomendas">Clique aqui</a> para administrar Encomendas<br />
	    <br /><br /><br /><br />
	    
	    <a href="testeCores">BUSCAR POR CORES NÃO CADASTRADAS</a><br />
	    <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
  	</body>
</html>