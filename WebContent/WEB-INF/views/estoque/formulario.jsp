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
    <h3>Adicionar estoque referente à peruca de id ${peruca_id}</h3>
    
    <form action="adicionaEstoque" method="post">
    	Quantidade: <input type="text" name="quantidade" /><br />
    	Rastreio: <input type="text" name="rastreio" /><br />
      	<input type="radio" name="emMaos" />Produto em mãos<br />
      
      <input type="submit" value="Adicionar">
    </form>
  </body>
</html>