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
  <h3>Alterar peruca - ${peruca.id}</h3>
  <form action="alteraPeruca" method="post">

    <input type="hidden" name="id" value="${peruca.id}" />
  
    Preço:<br />
    <input type="text" name="preco" value="${peruca.preco}"/><br />
    Tamanho:<br />
    <input type="text" name="tamanho" value="${peruca.tamanho}"/><br />
    Peso:<br />
    <input type="text" name="peso" value="${peruca.peso}"/><br />
    Cor:<br />
    <input type="text" name="cor" value="${peruca.cor}"/><br />
    Local:<br />
    <input type="text" name="local" value="${peruca.local}"/><br />
    Vendedor:<br />
    <input type="text" name="vendedor" value="${peruca.vendedor}"/><br />
    Link:<br />
  	<input type="text" name="link" value="${peruca.link}"/><br />
  	<caspoke:campoBoolean nome="semFranja" valor="${peruca.semFranja}"/> Sem franja <br />
    <caspoke:campoBoolean nome="temDivisao" valor="${peruca.temDivisao}"/> Tem divisão <br />
    <caspoke:campoBoolean nome="temOmbre" valor="${peruca.temOmbre}"/> Tem ombre <br />
      	
    <input type="submit" value="Alterar"/>
  </form>
  
  <h3>Alterar imagem</h3>
  	<form action="salvarImagemPeruca" method="post" enctype="multipart/form-data">
  		<input type="hidden" name="id" value="${peruca.id}"/>
  		Link da imagem:<br />
  		<input type="text" name="link" /> <br />
  		OU Upload:<br />
  		<input type="file" id="foto" name="foto" />
  		<input type="submit" value="Upload!"/>
  	</form>
</body>
</html>