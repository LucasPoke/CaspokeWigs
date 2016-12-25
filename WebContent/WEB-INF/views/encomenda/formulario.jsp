<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>

<html>
	<head>
	 	<meta charset="utf-8">
	 	<meta name="viewport" content="width=device-width, initial-scale=1">
	 	 
    	<link href="css/jquery.css" rel="stylesheet">
    	<link href="css/caspokewigs.css" rel="stylesheet">
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
		    
		    $("img").click(function (e){
		    	
		    	var id, idCheckbox;
		    	id = $(this).attr('id');
		    	id = id.substring(7);
		    	idCheckbox = "#checkbox_" + id;
		    	
		    	if ($(idCheckbox).is(":checked"))
		    	{
		    		$(idCheckbox).attr('checked', false);
		    		$(this).attr('border', 0);
		    	}
		    	else
		    	{
			    	$(idCheckbox).attr('checked', "checked");
			    	$(this).attr('border', 5);
		    	}
		    	
		    	//console.log($( "input:checked" ).length + " inputs checados");
		    });
		    
		});  
		</script> 
  	</head>
  
  <body>
    <h3>Cadastrar encomenda</h3>
    
    <form action="adicionaEncomenda" method="post">
    
    	<input type="hidden" name="orcamento_id" value="${orcamento_id}" />
	    
	    Preço:<br />
	    <input type="text" name="preco"/><br />
	    Tempo de confecção (em semanas):<br />
	    <input type="text" name="tempoConfeccao"/><br />
	    Data de pagamento:<br />
	    <caspoke:campoData id="data_pagamento" /><br />
	    Selecione as perucas de base usadas: <br />
	    <table id="tabelaPerucasBase">
	  <c:forEach items="${perucasBase}" var="p">
	    <input type="checkbox" id="checkbox_${p.id}" name="idPerucas" value="${p.id}" class="hidden" />
	    <tr id="peruca_${p.id}">
    	<tr>
    		<td rowspan="5"><img id="imagem_${p.id}" src="<c:url value="/resources/imagens/perucas/${p.peruca.id}.jpg"/>" height="150"/></td>
      		<th>Preço</th>
      		<td>$${p.peruca.preco}</td>
      		<td>
      	</tr>
      	<tr>
      		<th>Tamanho</th>
      		<td>${p.peruca.tamanho}cm</td>
      	</tr>
      	<tr>
      		<th>Peso</th>
      		<c:if test="${p.peruca.peso == 0}">
      			<td>-</td>
      		</c:if>
      		<c:if test="${p.peruca.peso > 0}">
      			<td>${p.peruca.peso}g</td>
      		</c:if>
      	</tr>
      	<tr>
      		<th>Quantidade:</th>
      		<td>${p.quantidade}</td>
      	</tr>
      	<tr>
      		<th>Rastreio:</th>
      		<c:if test="${empty p.rastreio}">
      			<td>Rastreio não disponível</td>
      		</c:if>
      		<c:if test="${not empty p.rastreio}">
      			<td>${p.rastreio}</td>
      		</c:if>
      	</tr>
	  </c:forEach>
	  </table>
		    
	    <!--  campos não requisitados assim que a encomenda é cadastrada
	    Frete:<br />
	    <input type="text" name="frete"/><br />
	    Rastreio:<br />
	    <input type="text" name="rastreio_br"/><br />
	    Status:<br />
	  	<select name="status">
	  		<c:forEach items="${status}" var="s">
       			<option value="${s}">${s}</option>
   			</c:forEach>
	  	</select>
	    
	     -->
	  	<!-- PARA ESSE CAMPO APARECER, STATUS DEVE SER EM DESENVOLVIMENTO OU SUPERIOR
	  	
	  	Data de início de confecção: <caspoke:campoData id="data_inicio" /><br /> -->
	  	
	  	
	    <input type="submit" value="Adicionar"/>
	    
    </form>
  </body>
</html>