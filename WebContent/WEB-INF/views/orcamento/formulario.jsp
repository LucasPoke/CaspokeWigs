<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>

<html>
	<head>
		<title>CaspokeWigs</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  	<meta name="viewport" content="width=device-width, initial-scale=1">
	  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  	<script src="https://use.fontawesome.com/126680faf3.js"></script>
	  	
	  	<link href="resources/css/caspokewigs.css" media="all" rel="stylesheet" type="text/css" />
	  	
	  	<script type="text/javascript">  
		$(document).ready(function(){  
		
			var count = 0;
			
				  		
		    $("#addImg").click(function( e ){  
		    	var input = '<div class="panel panel-default panel-inside-form" id="panel_' +count+ '">' +
		  				'<label for="link">Link:</label>' +
			  			'<input type="text" class="form-control" id="link" placeholder="Copie o link de uma imagem e cole aqui">' +
			  			'<label for="upload">Ou faça upload:</label>' +
			  			'<input type="file" class="form-control" id="foto" name="foto" />' +
			  			'<div class="btn-group">' +
			  				'<button type="button" class="btn btn-primary"><i class="glyphicon glyphicon-upload"></i> Enviar imagem!</button>' +
		  					'<a href="#" id="cancela_img_'+count+'">Cancelar</button>' +
		  				'</div>';
		        $('#imagens').append( input );
		        count++;
		        console.log("ADICIONOU CAMPO");
		    });
		    
		})
		</script>
	</head>
  
  <body>
  	<c:import url="/WEB-INF/views/cabecalho.jsp"/>
  	<div class="container">
    	<h3>Solicitar orçamento</h3>
    	<div class="col-sm-offset-3 col-sm-6 col-sm-offset-3">
	    	<div class="form-responsive">
	    	<form action="adicionaOrcamento" class="form-horizontal" method="post">
	    		<input type="hidden" name="cliente_id" value="${user.id}">
	    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	     		<div class="form-group">
	     			<label class="control-label col-sm-2" for="personagem">Personagem</label>
		  			<div class="col-sm-10">
		  				<input type="text" class="form-control" id="personagem" name="personagem" placeholder="Nome do personagem"/>
		  			</div>
		  		</div>
		  		<div class="form-group">
		  			<label class="control-label col-sm-2" for="serie">Série</label>
		  			<div class="col-sm-10">
		  				<input type="text" class="form-control" id="serie" name="serie" placeholder="Nome da série"/>
		  			</div>
		  		</div>
		  		<div class="form-group">
		  			<label class="control-label col-sm-2" for="descricao">Descrição</label>
		  			<div class="col-sm-10">
		  				<textarea class="form-control" rows="4" cols="50" id="descricao" name="descricao" placeholder="Informações adicionais"></textarea>
		  			</div>
		  		</div>
		  		<!-- funções de admin: selecionar cliente, local, data de cadastro -->
		  		<div class="form-group">
		  			<label class="control-label col-sm-2" for="link">Imagens</label>
		  			<div class="col-sm-10" id="imagens">
		  			<!--
		  			<div class="panel panel-default panel-inside-form">
		  				<label for="link">Link:</label>
			  			<input type="text" class="form-control" id="link" placeholder="Copie o link de uma imagem e cole aqui">
			  			<label for="upload">Ou faça upload:</label>
			  			<input type="file" class="form-control" id="foto" name="foto" />
			  			<div class="btn-group">
			  				<button type="button" class="btn btn-primary"><i class="glyphicon glyphicon-upload"></i> Enviar imagem!</button>
		  					<button type="button" class="btn btn-primary">Cancelar</button>
		  				</div>
		  			</div>
		  			 -->
		  			</div>
		  		</div>
		  		<div class="form-group">
		  			<div class="col-sm-offset-2 col-sm-10">
		  				<a href="#" id="addImg"><i class="glyphicon glyphicon-plus-sign"></i> Adicionar imagem de referência</a>
		  			</div>
		  		</div>
	    		<div class="form-group"> 
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" value="Enviar" id="submit" class="btn btn-primary btn-sm"/> ou <a href="<c:url value='listaOrcamentos' />">Cancelar</a>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
  </body>
</html>