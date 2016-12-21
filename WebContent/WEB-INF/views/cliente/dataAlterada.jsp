<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	  <td>${c.id}</td>
	  <td>${c.nome}</td>
	  <c:if test="${not empty c.email}">
      	<td>${c.email}</td>
      </c:if>
      <c:if test="${empty c.email}">
      	<td>Email não cadastrado</td>
      </c:if>
      
      <c:if test="${not empty c.data}">
      	<td><fmt:formatDate 
          value="${c.data.time}" 
          pattern="dd/MM/yyyy"/>
      	</td>
      </c:if>
      <c:if test="${empty c.data}">
      	<td>Data não cadastrada</td>
      </c:if>
      
      <td><a href="mostraCliente?id=${c.id}">Alterar</a></td>
      <!--  <td><a href="removeCliente?id=${c.id}">Remover</a></td> -->
      <td><a href="#" onClick="remove(${c.id})">Remover(com AJAX))</a></td>
      <td>DATA ALTERADA</td>