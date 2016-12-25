<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
		<link href="resources/css/star-rating.css" media="all" rel="stylesheet" type="text/css" />
		<script src="resources/js/star-rating.js" type="text/javascript"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/cabecalho.jsp"/>
	<div class="container">
	  	<h3>Alterar cliente</h3>
	  	<form:form class="form-horizontal" modelAttribute="c" action="alteraCliente" method="post">
						<div class="form-group">
				    		<label class="control-label col-sm-2" for="nome">Nome</label>
	   						<div class="col-sm-10">
	      						<input type="text" class="form-control" id="nome" name="nome" placeholder="Inserir nome" value="${c.nome}">
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
	      						<input type="text" class="form-control" id="senha" name="senha" placeholder="Inserir senha" value="${c.senha}">
	    					</div>
				    	</div>
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
				    	<div class="form-group"> 
						    <div class="col-sm-offset-2 col-sm-10">
						    	<button type="submit" class="btn btn-default">Alterar</button>
						    </div>
						</div>
	  	</form:form>
	</div>
</body>
</html>