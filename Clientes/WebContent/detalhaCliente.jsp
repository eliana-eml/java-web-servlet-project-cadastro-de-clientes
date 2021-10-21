<%@page import="br.senai.sp.dao.ClienteDAO"%>
<%@page import="br.senai.sp.model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhes do Cliente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dis
t/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body class="bg-warning">

	<% 
	String txtId = request.getParameter("txtId");
	int id = Integer.parseInt(txtId);
	
	ClienteDAO clienteDao = new ClienteDAO();
	Cliente c = clienteDao.buscarClientePorId(id); 
	%>
	
	<% if (c != null) { %>
	
	<div class="container bg-light">
		<form class="form-group" action="/Clientes/AlteraClienteServlet" method="post">
			
			<input type="hidden" name="txtId" value="<%= c.getIdCliente()%>">
			
			<p>Nome:</p>
			<input type="text" name="txtNome" value="<%= c.getNomeCliente() %>" />
			<p>Telefone:</p>
			<input type="text" name="txtTelefone" value=" <%= c.getTelefoneCliente() %>" />
			<p>Endereço:</p>
			<input type="text" name="txtEndereco" value="<%= c.getEnderecoCliente() %>" />
			
			<button class="btn btn-info" type="submit" name="btnGravar">GRAVAR</button>
		</form>
	</div>
	
	<%} else {%>
		<p>Cliente não encontrado no banco de dados!</p>
	<% }%>
	
</body>
</html>