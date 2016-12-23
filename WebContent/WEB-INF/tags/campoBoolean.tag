<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="nome" required="true" %>
<%@ attribute name="valor" required="false" %>
<label>

<c:if test="${valor}">
	<input type="hidden" id="${nome}" name="${nome}" value=true/>
	<input type="checkbox" class="booleanCheckbox" checked>
</c:if>
<c:if test="${not valor}">
	<input type="hidden" id="${nome}" name="${nome}" value=false/>
	<input type="checkbox" class="booleanCheckbox">
</c:if>
</label>