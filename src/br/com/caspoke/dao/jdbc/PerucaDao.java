package br.com.caspoke.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caspoke.model.Peruca;

@Repository
public class PerucaDao {

	private Connection con;
	
	@Autowired
	public PerucaDao (DataSource dataSource) {
		try {
			this.con = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void insere (Peruca p)
	{
		String sql = "insert into perucas (preco, tamanho, peso, cor, local, vendedor, link) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setBigDecimal(1, p.getPreco());
			stmt.setInt(2, p.getTamanho());
			stmt.setInt(3,  p.getPeso());
			stmt.setString(4,  p.getCor());
			stmt.setString(5, p.getLocal());
			stmt.setString(6,  p.getVendedor());
			stmt.setString(7,  p.getLink());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insereVariasCores (Peruca p, ArrayList<String> cores) {
		
		for (int i=0; i < cores.size(); i++)
		{
			p.setCor(cores.get(i));
			insere(p);
		}
		
	}
	
	
	public ArrayList<Peruca> getLista() {
		
		try {
			ArrayList<Peruca> perucas = new ArrayList();
			PreparedStatement stmt = this.con.prepareStatement("select * from perucas");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Peruca p = new Peruca();
				p.setId(rs.getLong("id"));
				p.setPreco(rs.getBigDecimal("preco"));
				p.setTamanho(rs.getInt("tamanho"));
				p.setPeso(rs.getInt("peso"));
				p.setCor(rs.getString("cor"));
				p.setLocal(rs.getString("local"));
				p.setVendedor(rs.getString("vendedor"));
				p.setLink(rs.getString("link"));
				
				perucas.add(p);
			}
			
			rs.close();
			stmt.close();
			
			return perucas;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleta (Peruca p) {
		String sql = "delete from perucas where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, p.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Peruca busca (long id) {
		String sql = "select * from perucas where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			Peruca p = new Peruca();
			
			if (rs.next())
			{
				p.setId(rs.getLong("id"));
				p.setPreco(rs.getBigDecimal("preco"));
				p.setTamanho(rs.getInt("preco"));
				p.setPeso(rs.getInt("peso"));
				p.setCor(rs.getString("cor"));
				p.setLocal(rs.getString("local"));
				p.setVendedor(rs.getString("vendedor"));
				p.setLink(rs.getString("link"));
			}
			rs.close();
			stmt.close();
			return p;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualiza (Peruca p) {
		String sql = "update perucas set preco=?,tamanho=?,peso=?,cor=?,local=?,vendedor=?,link=? where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setBigDecimal(1, p.getPreco());
			stmt.setInt(2,  p.getTamanho());
			stmt.setInt(3,  p.getPeso());
			stmt.setString(4,  p.getCor());
			stmt.setString(5, p.getLocal());
			stmt.setString(6, p.getVendedor());
			stmt.setString(7, p.getLink());
			stmt.setLong(8, p.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}