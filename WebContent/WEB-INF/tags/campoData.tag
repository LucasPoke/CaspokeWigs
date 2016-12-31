<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="id" required="true" %>


<form:input id="${id}" path="${id}" class="form-control input-sm"/>
<script>
  $("#${id}").datepicker({dateFormat: 'dd/mm/yy', changeMonth: true, changeYear: true});
</script>