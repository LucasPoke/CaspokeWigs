<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
  <h3>Alterar cliente - ${cliente.id}</h3>
  <form action="alteraCliente" method="post">

    <input type="hidden" name="id" value="${cliente.id}" />
  
    Nome:<br />
    <input type="text" name="nome" value="${cliente.nome}"/>
    Email:<br />
    <input type="text" name="email" value="${cliente.email}"/>
    Data de cadastro:<br />
    <input type="text" name="data" 
      value="<fmt:formatDate 
      value="${cliente.data.time}" 
      pattern="dd/MM/yyyy" />"/> 
    <br />
  
    <input type="submit" value="Alterar"/>
  </form>
</body>
</html>