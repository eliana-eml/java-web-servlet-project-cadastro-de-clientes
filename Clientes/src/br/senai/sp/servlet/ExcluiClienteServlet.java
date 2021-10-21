package br.senai.sp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.dao.ClienteDAO;

@WebServlet("/ExcluiClienteServlet")
public class ExcluiClienteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtId = request.getParameter("txtId");
		int id = Integer.parseInt(txtId);
		
		ClienteDAO clienteDao = new ClienteDAO();
		
		if(clienteDao.excluirCliente(id)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/listaCliente.jsp");
			dispatcher.forward(request, response);
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/clienteNaoExcluido.jsp");
			request.setAttribute("clienteReq", clienteDao);
			dispatcher.forward(request, response);
		}
		
	}

}
