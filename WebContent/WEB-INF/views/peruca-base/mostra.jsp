<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>

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
	  		
			<script type="text/javascript">  
				$(document).ready(function(){  
				
			    var input = '<label><input type="text" name="cor" /> <a href="#" class="remove">X</a><br /></label>';  
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
  <h3>Cadastrar peruca de base - ${perucaBase.id}</h3>
  <form action="alteraPerucaBase" method="post">
  	
  	<input type="hidden" name=id value="${perucaBase.id}" />
  	<input type="hidden" name=peruca_id value="${perucaBase.peruca.id}" />
  	Quantidade:<br />
    <input type="text" name="quantidade" value="${perucaBase.quantidade}"/><br />
    Rastreio:<br />
    <input type="text" name="rastreio" value="${perucaBase.rastreio}"/><br />
    <caspoke:campoBoolean nome="chegou" valor="${perucaBase.chegou}"/> Chegou <br />
      	
    <input type="submit" value="Alterar"/>
  </form>
</body>
</html>