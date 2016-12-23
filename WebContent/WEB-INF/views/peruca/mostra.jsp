<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>

<html>
<body>
  <h3>Alterar peruca - ${peruca.id}</h3>
  <form action="alteraPeruca" method="post">

    <input type="hidden" name="id" value="${peruca.id}" />
  
    Preço:<br />
    <input type="text" name="preco" value="${peruca.preco}"/><br />
    Tamanho:<br />
    <input type="text" name="tamanho" value="${peruca.tamanho}"/><br />
    Peso:<br />
    <input type="text" name="peso" value="${peruca.peso}"/><br />
    Cor:<br />
    <input type="text" name="cor" value="${peruca.cor}"/><br />
    Local:<br />
    <input type="text" name="local" value="${peruca.local}"/><br />
    Vendedor:<br />
    <input type="text" name="vendedor" value="${peruca.vendedor}"/><br />
    Link:<br />
  	<input type="text" name="link" value="${peruca.link}"/><br />
  
    <input type="submit" value="Alterar"/>
  </form>
  
  <h3>Alterar imagem</h3>
  	<form action="salvarImagemPeruca" method="post" enctype="multipart/form-data">
  		<input type="hidden" name="id" value="${peruca.id}"/>
  		Link da imagem:<br />
  		<input type="text" name="link" /> <br />
  		OU Upload:<br />
  		<input type="file" id="foto" name="foto" />
  		<input type="submit" value="Upload!"/>
  	</form>
</body>
</html>