<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>

<html>
	<head>
			<link href="css/jquery.css" rel="stylesheet">
	    	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	    	<script src="js/jquery-ui.js"></script>
	    	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	  		
	  		<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>  
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