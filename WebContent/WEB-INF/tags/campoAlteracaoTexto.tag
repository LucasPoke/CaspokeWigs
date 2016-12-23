<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="atributo" required="true" %>
<%@ attribute name="entidade" required="true" %>

<% String nomeAtributo = atributo.substring(0, 1).toUpperCase() + atributo.substring(1);%>
<%=nomeAtributo%>:<br />
<input type="text" name="${atributo}" value="${entidade.${atributo}}"/>