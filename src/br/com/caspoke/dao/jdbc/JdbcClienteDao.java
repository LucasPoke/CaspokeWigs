package br.com.caspoke.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caspoke.dao.IClienteDao;
import br.com.caspoke.model.Cliente;

@Repository
public class JdbcClienteDao implements IClienteDao{

	Connection con;
	
	@Autowired
	public JdbcClienteDao (DataSource dataSource) {
		try {
			this.con = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void insere (Cliente c)
	{
		String sql = "insert into clientes (nome, email, data, login, senha) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEmail());
			
			if (c.getData() != null)
				stmt.setDate(3, new Date(c.getData().getTimeInMillis()));
			else
				stmt.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));
			
			stmt.setString(4, c.getLogin());
			stmt.setString(5, c.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Cliente> buscaPorNome (String nome) {
		ArrayList<Cliente> clientes = new ArrayList();
		String sql = "select * from clientes where nome = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				c.setData(data);
				
				clientes.add(c);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cliente buscaPorId (long id) {
		String sql = "select * from clientes where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			Cliente c = new Cliente();
			
			if (rs.next())
			{
				c.setId(rs.getLong("id"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				c.setData(data);
			}
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera (Cliente c) {
		String sql = "update clientes set nome=?,email=?,data=?,login=?,senha=? where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,  c.getNome());
			stmt.setString(2, c.getEmail());
			stmt.setDate(3, new Date(c.getData().getTimeInMillis()));
			stmt.setString(4,  c.getLogin());
			stmt.setString(5, c.getSenha());
			stmt.setLong(6,  c.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Cliente> lista () {
		try {
			ArrayList<Cliente> clientes = new ArrayList();
			PreparedStatement stmt = this.con.prepareStatement("select * from clientes");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				c.setData(data);
				
				clientes.add(c);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove (Cliente c) {
		String sql = "delete from clientes where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, c.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public Cliente buscaPorLogin(Cliente cliente) {
		//confere login e senha do cliente c no banco de dados
		String sql = "select * from clientes where login = ? and senha = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getLogin());
			stmt.setString(2, cliente.getSenha());
			
			
			ResultSet rs = stmt.executeQuery();
			Cliente c = null;
			
			if (rs.next()) {
				c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setLogin(rs.getString("login"));
				c.setSenha(rs.getString("senha"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				c.setData(data);
				
			}
			
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//ESSE METODO DEVE SER DELETADO, FOI CRIADO PRA TESTES AJAX
	public void dataAtual(long id) {
		Cliente c = buscaPorId(id);
		if (c != null) {
			System.out.println("encontrou aqui");
			c.setData(Calendar.getInstance());
			altera(c);
		}
	}
}
