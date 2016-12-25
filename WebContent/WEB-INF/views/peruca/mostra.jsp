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