<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>
<html>
<body>
  <h3>Alterar orçamento - ${orcamento.id}</h3>
  <form action="alteraOrcamento" id="alteraForm" method="post">
  
	    <input type="hidden" name="id" value="${orcamento.id}" />
	  	<input type="hidden" name="aceito" value="${orcamento.aceito}" />
	  	
	  	Cliente:<br />
	  	<select name="cliente_id">
	  		<c:forEach items="${clientes}" var="c">
	  			<c:if test="${orcamento.cliente.id == c.id}">
	  				<option value="${c.id}" selected="selected">${c.id} - ${c.nome}</option>
	  			</c:if>
	  			<c:if test="${orcamento.cliente.id != c.id}">
       				<option value="${c.id}">${c.id} - ${c.nome}</option>
	  			</c:if>
   			</c:forEach>
	  	</select> <br />
	    Personagem:<br />
	    <input type="text" name="personagem" value="${orcamento.personagem}" /><br />
	    Serie:<br />
	    <input type="text" name="serie" value="${orcamento.serie}" /><br />
	    Local:<br />
	    <input type="text" name="local" value="${orcamento.local}" /><br />
	    Data de cadastro:<br />
	    <input type="text" name="data_cadastro" 
	      value="<fmt:formatDate 
	      value="${orcamento.data_cadastro.time}" 
	      pattern="dd/MM/yyyy" />"/> 
	    <br />
	  	Comentarios:<br />
	    <!-- <input type="text" name="comentarios" value="${orcamento.comentarios}"/><br /> -->
	    <textarea rows="4" cols="50" name="comentarios" form="alteraForm">${orcamento.comentarios}</textarea>
	    <br />
	    <input type="submit" value="Alterar"/>
  </form>
</body>
</html>