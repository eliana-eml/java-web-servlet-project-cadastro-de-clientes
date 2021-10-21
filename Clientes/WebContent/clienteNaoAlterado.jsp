<%@page import="br.senai.sp.model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cliente n�o alterado</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dis
t/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body class="bg-warning">

	<% Cliente c = (Cliente) request.getAttribute("clienteReq"); %>
	<div class="container bg-light">
		<h2> N�o foi poss�vel alterar o cliente <%= c.getNomeCliente()%> !</h2>
		<button class="btn btn-info" onclick="window.location.href='/Clientes/ListaClienteServlet'">Tentar novamente</button>
	</div>
</body>
</html>