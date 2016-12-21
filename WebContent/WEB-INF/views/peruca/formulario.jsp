<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caspoke" %>

<html>
	<head>
    	<link href="css/jquery.css" rel="stylesheet">
    	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    	<script src="js/jquery-ui.js"></script>
    	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	</head>
  
  <body>
    <h3>Adicionar peruca</h3>
    
    <form action="adicionaPeruca" method="post">
    	Preço: <input type="text" name="preco" /><br />
    	Tamanho: <input type="text" name="tamanho" /><br />
     	Peso: <input type="text" name="peso" /><br />
      	Cor: (no caso de várias cores, separar por ';')<input type="text" name="cor" /><br />
      	Local: <input type="text" name="local" /><br />
      	Vendedor: <input type="text" name="vendedor" /><br />
      	Link: <input type="text" name="link" /><br />
      <input type="submit" value="Adicionar">
    </form>
  </body>
</html>