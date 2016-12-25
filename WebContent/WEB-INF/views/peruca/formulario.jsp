<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
		<script type="text/javascript">  
		$(document).ready(function(){  
		
		    var input = '<label><input type="text" name="cor" /><a href="#" class="remove">X</a><br /></label><br />';  
		    $("input[name='add']").click(function( e ){  
		        $('#cores_adicionais').append( input );  
		        console.log("ADICIONOU COR");
		    });  
		
		    $('#cores_adicionais').delegate('a','click',function( e ){  
		        e.preventDefault();  
		        $( this ).parent('label').remove();  
		    });  
		
		    
		    $('.booleanCheckbox').click(function() {
		    	if ($(this).is(":checked"))
		    	{
		    		console.log("Não estava checado:\nantes")
			    	console.log($(this).parent().find('input:hidden:first').val());
			        $(this).parent().find('input:hidden:first').val(true);
			        console.log("depois")
			    	console.log($(this).parent().find('input:hidden:first').val());
		    	}
		    	else {
		    		console.log("Estava checado:\nantes")
			    	console.log($(this).parent().find('input:hidden:first').val());
			        $(this).parent().find('input:hidden:first').val(false);
			        console.log("depois")
			    	console.log($(this).parent().find('input:hidden:first').val());
		    	}
		        
		    });
		    
		});  
		</script> 
  	</head>
  
  <body>
  	<c:import url="/WEB-INF/views/cabecalho.jsp"/>
    <h3>Adicionar peruca</h3>
    
    <form action="adicionaPerucaESolicitaImagem" id="formAdiciona" method="post">
    	Preço: <input type="text" name="preco" /><br />
    	Tamanho: <input type="text" name="tamanho" /><br />
     	Peso: <input type="text" name="peso" /><br />
      	Cor: <input type="text" name="cor" /><br />
      	<fieldset id="cores_adicionais" style="border: none"></fieldset>
      	<input type="button" name="add" value="Adicionais mais cores" /><br />
      	Local: <input type="text" name="local" /><br />
      	Vendedor: <input type="text" name="vendedor" /><br />
      	Link: <input type="text" name="link" /><br />
      	
      	<caspoke:campoBoolean nome="semFranja"/> Sem franja <br />
      	<caspoke:campoBoolean nome="temDivisao"/> Tem divisão <br />
      	<caspoke:campoBoolean nome="temOmbre"/> Tem ombre <br />
      	
      	<div id="uploadFotos"></div>
      <input type="submit" value="Adicionar">
    </form>
  </body>
</html>