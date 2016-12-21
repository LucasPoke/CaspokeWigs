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
    <h3>Cadastrar encomenda</h3>
    
    <form action="adicionaEncomenda" method="post">
    
    	<input type="hidden" name="orcamento_id" value="${orcamento_id}" />
    	
	    Preço:<br />
	    <input type="text" name="preco"/><br />
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
	  	Início da confecção: <caspoke:campoData id="data_inicio" /><br />
	    <input type="submit" value="Adicionar"/>
	    
    </form>
  </body>
</html>