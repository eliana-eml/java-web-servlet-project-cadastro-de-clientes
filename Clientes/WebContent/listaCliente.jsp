<%@page import="br.senai.sp.dao.ClienteDAO"%>
<%@page import="br.senai.sp.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<title>Lista de Clientes</title>
</head>
<body class="bg-light">
		<table class="table table-light">
		  <thead>
		    <tr>
		      <th class="text-center bg-dark text-light" scope="col">ID</th>
		      <th class="text-center bg-dark text-light" scope="col">Nome</th>
		      <th class="text-center bg-dark text-light" scope="col">Telefone</th>
		      <th class="text-center bg-dark text-light" scope="col">Endereço</th>
		      <th class="text-center bg-dark text-light" colspan='2' scope="col">Ações</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<% ClienteDAO clienteDao = new ClienteDAO();
			   List<Cliente> listagem = clienteDao.listarCliente(); %>
		  
		  	<% if (listagem != null)  {%>
		  	
			  	<% for (Cliente c : listagem) { %>
				  	<tr  class="text-center">
				  	  <td><%= c.getIdCliente() %> </td>
				      <td><%= c.getNomeCliente()%></td>
				      <td><%= c.getTelefoneCliente()%></td>
				      <td><%= c.getEnderecoCliente()%></td>
				      <td><button type="button" class="btn btn-warning"
				      onclick="window.location.href='/Clientes/DetalhaClienteServlet?txtId=<%=c.getIdCliente()%>'">ALTERAR</button><button type="button" class="btn btn-info" onclick="window.location.href='/Clientes/ExcluiClienteServlet?txtId=<%=c.getIdCliente()%>'">DELETAR</button></td>
				    </tr> 
			    <% } %>
		    
		    <% } %>
		  </tbody>
		</table>
		
		<button type="button" class="btn btn-info" onclick="window.location.href='/Clientes/cadastroCliente.html'">Cadastrar novo cliente</button>

	</body>
</html>