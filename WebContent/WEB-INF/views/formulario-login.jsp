<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>CaspokeWigs</title>
		<meta charset="utf-8">
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  	<link href="resources/css/caspokewigs.css" media="all" rel="stylesheet" type="text/css" />
	  	
	  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  	<script src="https://use.fontawesome.com/126680faf3.js"></script>
	</head>

  	<body>
  		<div class="container">
	  		<nav class="navbar navbar-inverse">
				<p class="navbar-text">Identificação</p>
			</nav>
			<div class="row border-between">
		  		<div class="col-sm-6">
		  			<h2>Já tenho cadastro</h2>
		  			<c:url var="loginUrl" value="/login" />
				    <form:form class="form-horizontal" modelAttribute="cliente" action="${loginUrl}" method="post">
				    	<c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                            	<p>Nome de usuário ou senha inválido</p>
                        	</div>
                        </c:if>
				    	<div class="form-group">
				    		<label class="control-label col-sm-2" for="usuario">Usuário</label>
	   						<div class="col-sm-10">
	      						<form:input type="text" class="form-control" id="usuario" path="ssoId" placeholder="Inserir nome de usuário" />
	    					</div>
				    	</div>
				    	<div class="form-group">
				    		<label class="control-label col-sm-2" for="senha">Senha</label>
	   						<div class="col-sm-10">
	      						<form:input type="password" class="form-control" id="senha" path="senha" placeholder="Inserir senha" />
	    					</div>
				    	</div>
				    	<div class="form-group">
				    		<div class="col-sm-offset-2 col-sm-10">
					    		<div class="checkbox">
                                	<label><input type="checkbox" id="rememberme" name="remember-me"> Lembrar</label>  
                             	 </div>
                            </div>
                        </div>
				    	<div class="form-group"> 
						    <div class="col-sm-offset-2 col-sm-10">
						    	<button type="submit" class="btn btn-default">Entrar no Sistema</button>
						    </div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				    </form:form>
		  		</div>
		  		
		  		
		  		<div class="col-sm-6">
		  			<h2>Não tenho cadastro</h2>
		  			<form:form class="form-horizontal" modelAttribute="cliente" action="novoCliente" method="post">
		  				<div class="form-group">
				    		<label class="control-label col-sm-2" for="email">Email</label>
	   						<div class="col-sm-10">
	      						<input type="text" class="form-control" id="email" name="email" placeholder="Digite seu email">
	    					</div>
				    	</div>
				      	<div class="form-group"> 
						    <div class="col-sm-offset-2 col-sm-10">
						    	<button type="submit" class="btn btn-default">Criar cadastro</button>
						    </div>
						</div>
				    </form:form >
		  		</div>
	  		</div>
			    
	    </div>
  	</body>
</html>