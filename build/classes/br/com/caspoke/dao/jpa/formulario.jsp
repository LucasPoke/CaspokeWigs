<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>

<html>
	<head>
    	<link href="css/jquery.css" rel="stylesheet">
    	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    	<script src="js/jquery-ui.js"></script>
    	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	</head>
  
  <body>
    <h3>Adicionar orçamento</h3>
    
    <form action="adicionaOrcamento" id="adicionaForm" method="post">
     
	  	Cliente:<br />
	  	<select name="cliente_id">
	  		<c:forEach items="${clientes}" var="c">
       			<option value="${c.id}">${c.id} - ${c.nome}</option>
   			</c:forEach>
	  	</select> <br />
	    Personagem:<br />
	    <input type="text" name="personagem"/><br />
	    Serie:<br />
	    <input type="text" name="serie"/><br />
	    Local:<br />
	    <input type="text" name="local"/><br />
	    Data de cadastro:<br />
	    <caspoke:campoData id="data" /><br />
	  	Comentarios:<br />
	  	<textarea rows="4" cols="50" name="comentarios" form="adicionaForm"></textarea>
	    <input type="submit" value="Adicionar"/>
	    
    </form>
    
  </body>
</html>