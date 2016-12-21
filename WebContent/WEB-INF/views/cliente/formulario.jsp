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
    <h3>Adicionar clientes</h3>
    
    <form:errors path="cliente.nome"/>
    <form:errors path="cliente.login"/>
    <form:errors path="cliente.senha"/>
    <form action="adicionaCliente" method="post">
    
    	Login: <input type="text" name="login" /><br />
    	Senha: <input type="text" name="senha" /><br />
      	Nome: <input type="text" name="nome" /><br />
      	E-mail: <input type="text" name="email" /><br />
      	Data de cadastro: <caspoke:campoData id="data" /><br />
      	<input type="submit" value="Adicionar">
    </form>
    
  </body>
</html>