package br.senai.sp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.ClienteDAO;
import br.senai.sp.model.Cliente;

@WebServlet("/DetalhaClienteServlet")
public class DetalhaClienteServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String txtId = request.getParameter("txtId");
		int id = Integer.parseInt(txtId);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/detalhaCliente.jsp");
		dispatcher.forward(request, response);
		
	}

}
