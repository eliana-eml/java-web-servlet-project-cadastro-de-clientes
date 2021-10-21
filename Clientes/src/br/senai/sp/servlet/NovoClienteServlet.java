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

@WebServlet("/NovoClienteServlet")
public class NovoClienteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente c = null;
		try {
			String nome = request.getParameter("txtNome");
			String telefone = request.getParameter("txtTelefone");
			String endereco = request.getParameter("txtEndereco");
			
			c = new Cliente();
			c.setNomeCliente(nome);
			c.setTelefoneCliente(telefone);
			c.setEnderecoCliente(endereco);
		}catch (Exception e) {
			throw new IOException("Erro nos parâmetros enviados! " + e.getMessage());
		}

		ClienteDAO alunoDao = new ClienteDAO();
		
		if (alunoDao.novoCliente(c)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/novoCliente.jsp");
			request.setAttribute("clienteReq", c);
			dispatcher.forward(request, response);
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/novoClienteNaoInserido.jsp");
			request.setAttribute("clienteReq", c);
			dispatcher.forward(request, response);
		}
		
	}

}
