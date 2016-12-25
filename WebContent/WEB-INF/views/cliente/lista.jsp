<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<script type="text/javascript" src="resources/js/jquery-3.1.1.min.js">
	</script>
</head>

<body>
  <script type="text/javascript">
    function alteraData(id) {
      $.post("dataAtual", {'id' : id}, function(resposta) {
        // selecionando o elemento html através da 
        // ID e alterando o HTML dele 
        $("#cliente_"+id).html(resposta);
      });
    }
  </script>
  
  <script type="text/javascript">
    function remove(id) {
      $.post("remove", {'id' : id}, function() {
        // selecionando o elemento html através da 
        // ID e alterando o HTML dele 
        $(this).closest("tr").hide();
      });
    }
  </script>
  
  	<a href="logout">Sair do sistema</a>
  	<a href="novoCliente">Cadastrar novo cliente</a><br />
  	<a href="menu">Voltar ao menu principal</a><br />

  <br /> <br />        

  <table id="tabelaClientes">
  <tr>
    <th>Nome</th>
    <th>Email</th>
    <th>Data de cadastro</th>
  </tr>
  <c:forEach items="${clientes}" var="c">
    <tr id="cliente_${c.id}">
      <td>${c.id}</td>
      <td>${c.nome}</td>
      <td>${c.email}</td>
      <td><fmt:formatDate 
          value="${c.data.time}" 
          pattern="dd/MM/yyyy"/>
      </td>
      
      <td><a href="mostraCliente?id=${c.id}">Alterar</a></td>
      <td><a href="removeCliente?id=${c.id}">Remover</a></td>
      <!-- 
      <td><a href="#" onClick="remove(${c.id})">Remover(com AJAX))</a></td>
      <td><a href="#" onClick="alteraData(${c.id})">Mudar data para data atual</a></td>
       -->
    </tr>
  </c:forEach>
  </table>
</body>
</html>