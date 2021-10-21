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

@WebServlet("/AlteraClienteServlet")
public class AlteraClienteServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String txtId = request.getParameter("txtId");
		System.out.println(txtId);
		int id = Integer.parseInt(txtId);
		
		String nome = request.getParameter("txtNome");
		String telefone = request.getParameter("txtTelefone");
		String endereco = request.getParameter("txtEndereco");
		
		Cliente c = new Cliente();
		c.setNomeCliente(nome);
		c.setTelefoneCliente(telefone);
		c.setEnderecoCliente(endereco);
		c.setIdCliente(id);
		
		System.out.println(c.getIdCliente());
		
		ClienteDAO clienteDao = new ClienteDAO();
		if (clienteDao.alterarCliente(c)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/listaCliente.jsp");
			dispatcher.forward(request, response);

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/clienteNaoAlterado.jsp");
			request.setAttribute("clienteReq", c);
			dispatcher.forward(request, response);
		}
		
	}


}
