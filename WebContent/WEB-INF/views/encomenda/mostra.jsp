<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>
<html>
<body>
  <h3>Alterar encomenda - ${encomenda.id}</h3>
  <form action="alteraEncomenda" id="alteraForm" method="post">
  
  		<input type="hidden" name="id" value="${encomenda.id}" />
	   	<input type="hidden" name="orcamento_id" value="${encomenda.orcamento.id}" />
    	<input type="hidden" name="data_inicio" value="${encomenda.data_inicio}" />
    	
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
	   	Data de pagamento:<br />
	    <input type="text" name="data_pagamento" 
	      value="<fmt:formatDate 
	      value="${encomenda.data_pagamento.time}" 
	      pattern="dd/MM/yyyy" />"/> 
	    
	    
	    <input type="submit" value="Alterar"/>
  </form>
</body>
</html>