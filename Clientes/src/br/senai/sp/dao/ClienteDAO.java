package br.senai.sp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.senai.sp.model.Cliente;

public class ClienteDAO {
	
	private String stringConexao = "jdbc:mysql://localhost/clientes?useTimezone=true&serverTimezone=UTC";
	private String usuario = "root";
	private String senha = "root";
	
	private Connection conexao = null;
	
	public boolean conectar() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conexao = DriverManager.getConnection(stringConexao, usuario, senha);
			
			System.out.println("Conectou no banco!");
			return true;
		}catch(SQLException e1) {
			System.out.println("Não conectou!");
			return false;
		}

	}
	
	public List<Cliente> listarCliente() {
		
		if (conectar()) {
			String sql = "SELECT id, nome, telefone, endereco FROM clientes.cli";
			
			List<Cliente> lista = new ArrayList<Cliente>();
			try {
				Statement acaoSql = conexao.createStatement();
				acaoSql.execute(sql);
			
				ResultSet rs = acaoSql.getResultSet();
				while (rs.next()) {
					
					Cliente c = new Cliente();
					String nome = rs.getString("nome");
					c.setNomeCliente(nome);
					c.setTelefoneCliente(      rs.getString("telefone")       );
					c.setEnderecoCliente(      rs.getString("endereco")       );
					c.setIdCliente(            rs.getInt("id")                );

					lista.add(c);
					
				}
				
			} catch (SQLException e) {
				return null;
			}
						
			return lista;
		}
		
		return null;
	}

	public boolean novoCliente(Cliente cliente){
	
	    if (conectar()){
	        String sql = "INSERT INTO clientes.cli (nome, telefone, endereco) VALUES (?,?,?)";
	        try {
	            PreparedStatement acaoSql = conexao.prepareStatement(sql);
	            acaoSql.setString(1,cliente.getNomeCliente());
	            acaoSql.setString(2,cliente.getTelefoneCliente());
	            acaoSql.setString(3,cliente.getEnderecoCliente());
	            int regisAfetados = acaoSql.executeUpdate();
	            if(regisAfetados > 0 ){
	                return true;
	            }else{
	                return false;
	            }
	        }catch(SQLException e){
	            return false;
	        }
	    }
	    return false;
	}
	
	public boolean excluirCliente(int id) {
		if (conectar()) {
			String sql = "DELETE FROM clientes.cli WHERE id = " + id;
			
			try {
				Statement acaoSql = conexao.createStatement();
				acaoSql.execute(sql);
				
				return true;
				
			} catch (SQLException e) {
				return false;
			}	
			
		}
		
		return false;
		
	}
	
	public Cliente buscarClientePorId(int id) {
		if (conectar()) {
			String sql = "SELECT id, nome, telefone, endereco FROM clientes.cli WHERE id = " + id;
			
			try {
				Statement acaoSql = conexao.createStatement();
				acaoSql.execute(sql);
				
				ResultSet rs = acaoSql.getResultSet();
				
				if (rs.next()) {
					Cliente c = new Cliente();
					String nome = rs.getString("nome");
					c.setNomeCliente(nome);
					c.setTelefoneCliente(      rs.getString("telefone")       );
					c.setEnderecoCliente(      rs.getString("endereco")       );
					c.setIdCliente(            rs.getInt("id")                );	
					
					return c;
				}

				return null;
				
			} catch (SQLException e) {
				return null;
			}	
			
		}
		
		return null;
		
	}
	
	public boolean alterarCliente(Cliente c) {
		if (conectar()) {
			String sql = 
					  " UPDATE clientes.cli "
					+ " SET nome = ?, "
					+ "     telefone = ?, "
					+ "     endereco = ? "
					+ " WHERE id = ? ";
			
			try {
				PreparedStatement acaoSql = conexao.prepareStatement(sql);
				acaoSql.setString(1, c.getNomeCliente()       );
				acaoSql.setString(2, c.getTelefoneCliente()   );
				acaoSql.setString(3, c.getEnderecoCliente()   );
				acaoSql.setInt(4, c.getIdCliente()            );
				acaoSql.executeUpdate();
				
				
				return true;
				
			} catch (SQLException e) {
				return false;
			}
		
		}
		
		return false;
	}
	
}
