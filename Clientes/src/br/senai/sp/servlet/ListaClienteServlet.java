package br.senai.sp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.ClienteDAO;
import br.senai.sp.model.Cliente;

@WebServlet("/ListaClienteServlet")
public class ListaClienteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClienteDAO clienteDao = new ClienteDAO();
		List<Cliente> listagem = clienteDao.listarCliente();
		   
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listaCliente.jsp");
		request.setAttribute("listaReq", listagem);
		dispatcher.forward(request, response);
	}

}
