<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
</head>
<body>
	<a href="logout">Sair do sistema</a><br />
  	<a href="menu">Voltar ao menu principal</a><br />
  	
	<h3>Cores cadastradas:</h3>
	<ul>
	<c:forEach items="$coresC" var="cc">
		<li>${cc}</li>
	</c:forEach>
	</ul>
	<br />
	<h3>Cores não cadastradas:</h3>
	<ul>
	<c:forEach items="$coresNC" var="nc">
		<li>${nc}</li>
	</c:forEach>
	</ul>
</body>
</html>