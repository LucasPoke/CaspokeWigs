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
	  	
	  	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	</head>

  	<body>
  		<div class="container">
	  		<nav class="navbar navbar-inverse">
				<p class="navbar-text">Identificação</p>
			</nav>
			<h2>Cadastro</h2>
		  		<div class="col-sm-offset-3 col-sm-6 col-sm-offset-3">
				    <form:form class="form-horizontal" modelAttribute="cliente" action="adicionaCliente" method="post">
				    	<div class="form-group">
				    		<label class="control-label col-sm-2" for="nome">Nome</label>
	   						<div class="col-sm-10">
	      						<input type="text" class="form-control" id="nome" name="nome" placeholder="Inserir nome">
	    					</div>
				    	</div>
				    	<div class="form-group">
				    		<label class="control-label col-sm-2" for="email">Email</label>
	   						<div class="col-sm-10">
	      						<input type="text" class="form-control" id="email" name="email" placeholder="Inserir email" value="${c.email}">
	    					</div>
				    	</div>
				    	<div class="form-group">
				    		<label class="control-label col-sm-2" for="senha">Senha</label>
	   						<div class="col-sm-10">
	      						<input type="password" class="form-control" id="senha" name="senha" placeholder="Inserir senha">
	    					</div>
				    	</div>
				    	<c:if test="${usuarioLogado.permissao=='TOTAL'}">
				    		<div class="form-group">
					    		<label class="control-label col-sm-2" for="data_cadastro">Data de cadastro</label>
					    		<div class="col-sm-10">
					    			<caspoke:campoData id="data_cadastro" /><br />
					    		</div>
				    		</div>
					    	<div class="form-group">
					    		<label class="control-label col-sm-2">Permissao</label>
							    <div class="col-sm-10">
							    	<div class="radio">
							        	<form:radiobutton path="permissao" value="NORMAL" /> Normal
							      	</div>
							      	<div class="radio">
							        	<label><form:radiobutton path="permissao" value="PARCIAL"/> Parcial</label>
							      	</div>
							      	<div class="radio">
							        	<label><form:radiobutton path="permissao" value="TOTAL"/> Total</label>
							      	</div>
							    </div>
							</div>
						</c:if>	
						
				    	<div class="form-group"> 
						    <div class="col-sm-offset-2 col-sm-10">
						    	<button type="submit" class="btn btn-default">Entrar no Sistema</button>
						    </div>
						</div>
				    </form:form>
		  		</div>
			    
	    </div>
  	</body>
</html>
  </body>
</html>