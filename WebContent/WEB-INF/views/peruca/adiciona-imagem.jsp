<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>

 	<h3>Adicionar imagens</h3>
  	<form action="salvarImagemVariasPerucas" method="post" enctype="multipart/form-data">
  		<c:forEach items="${perucas}" var="p">
	  		<input type="hidden" name="id" value="${p.id}"/>
	  		Cor da peruca: ${p.cor}<br />
	  		Link da imagem:<br />
	  		<input type="text" name="link" /> <br />
	  		<br />
  		</c:forEach>
  		<input type="submit" value="Upload!"/>
  	</form>
  	
</body>
</html>