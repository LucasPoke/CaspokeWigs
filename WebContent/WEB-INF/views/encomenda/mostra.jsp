<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>
<html>
<head>
		<link href="css/jquery.css" rel="stylesheet">
    	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    	<script src="js/jquery-ui.js"></script>
    	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
  <h3>Alterar encomenda - ${encomenda.id}</h3>
  <form action="alteraEncomenda" id="alteraForm" method="post">
  
  		<input type="hidden" name="id" value="${encomenda.id}" />
	   	<input type="hidden" name="orcamento_id" value="${encomenda.orcamento.id}" />
    	<input type="hidden" name="data_final" value="${encomenda.data_final}" />
    	<input type="hidden" name="data_final" value="${encomenda.data_envio}" />
    	
	    Preço:<br />
	    <input type="text" name="preco" value="${encomenda.preco}"/><br />
	    Status:<br />
	  	<select name="status">
	  		<c:forEach items="${status}" var="s">
	  			<c:if test="${encomenda.status == s}">
       				<option value="${s}" selected="selected">${s}</option>
       			</c:if>
       			<c:if test="${encomenda.status != s}">
       				<option value="${s}">${s}</option>
       			</c:if>
   			</c:forEach>
	  	</select>
	  	<br />
	  	Frete:<br />
	    <input type="text" name="frete" value="${encomenda.frete}"/><br />
	    Rastreio:<br />
	    <input type="text" name="rastreio_br" value="${encomenda.rastreio_br}"/><br />
	    
	    <!--  Esse campo não pode ser mudado assim, visto que a data_final depende dele!!!!!!!!!! -->
	    *PREENCHER SOMENTE ENQUANTO HÁ VALORES NULOS NO BANCO* Tempo de confecção (em semanas):<br />
	    <input type="text" name="tempoConfeccao" value="${encomenda.tempoConfeccao}"/><br />
	    *PREENCHER SOMENTE ENQUANTO HÁ VALORES NULOS NO BANCO* Data de conclusao:<br />
	    <caspoke:campoData id="data_final" /><br />
	      
	      
	   	Data de pagamento:<br />
	    <input type="text" name="data_pagamento" 
	      value="<fmt:formatDate 
	      value="${encomenda.data_pagamento.time}" 
	      pattern="dd/MM/yyyy" />"/> 
	    
	    
	    <input type="submit" value="Alterar"/>
  </form>
</body>
</html>