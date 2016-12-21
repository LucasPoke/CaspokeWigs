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

import br.com.caspoke.model.Orcamento;

@Repository
public class JdbcOrcamentoDao {

	Connection con;
	
	@Autowired
	public JdbcOrcamentoDao (DataSource dataSource) {
		try {
			this.con = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Orcamento> lista() {
		try {
			ArrayList<Orcamento> orcamentos = new ArrayList();
			PreparedStatement stmt = this.con.prepareStatement("select * from orcamentos");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Orcamento o = new Orcamento();
				o.setId(rs.getLong("id"));
				o.setCliente_id(rs.getLong("cliente_id"));
				o.setPersonagem(rs.getString("personagem"));
				o.setSerie(rs.getString("serie"));
				o.setLocal(rs.getString("local"));
				o.setComentarios(rs.getString("comentarios"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				o.setData(data);
				
				orcamentos.add(o);
			}
			rs.close();
			stmt.close();
			return orcamentos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Orcamento buscaPorId(long id) {
		String sql = "select * from orcamentos where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Orcamento o = new Orcamento();
			if (rs.next())
			{
				o.setId(rs.getLong("id"));
				o.setCliente_id(rs.getLong("cliente_id"));
				o.setPersonagem(rs.getString("personagem"));
				o.setSerie(rs.getString("serie"));
				o.setLocal(rs.getString("local"));
				o.setComentarios(rs.getString("comentarios"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				o.setData(data);
			}
			rs.close();
			stmt.close();
			return o;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insere (Orcamento o)
	{
		String sql = "insert into orcamentos (cliente_id, personagem, serie, local, data, comentarios) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, o.getCliente_id());
			stmt.setString(2, o.getPersonagem());
			stmt.setString(3, o.getSerie());
			stmt.setString(4, o.getLocal());
			stmt.setDate(5, new Date(o.getData().getTimeInMillis()));
			stmt.setString(6,  o.getComentarios());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove (Orcamento o) {
		String sql = "delete from orcamentos where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, o.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera (Orcamento o) {
		String sql = "update orcamentos set cliente_id=?,personagem=?,serie=?,local=?,data=?,comentarios=? where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, o.getCliente_id());
			stmt.setString(2, o.getPersonagem());
			stmt.setString(3, o.getSerie());
			stmt.setString(4, o.getLocal());
			stmt.setDate(5, new Date(o.getData().getTimeInMillis()));
			stmt.setString(6, o.getComentarios());
			stmt.setLong(7, o.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Orcamento> listaEmEspera() {
		try {
			ArrayList<Orcamento> orcamentos = new ArrayList();
			PreparedStatement stmt = this.con.prepareStatement("select orcamentos.id, cliente_id, personagem, serie, local, data, comentarios"
					+ " from orcamentos"
					+ " LEFT JOIN encomendas"
					+ " ON orcamentos.id = orcamento_id"
					+ " WHERE orcamento_id IS NULL;");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Orcamento o = new Orcamento();
				o.setId(rs.getLong("id"));
				o.setCliente_id(rs.getLong("cliente_id"));
				o.setPersonagem(rs.getString("personagem"));
				o.setSerie(rs.getString("serie"));
				o.setLocal(rs.getString("local"));
				o.setComentarios(rs.getString("comentarios"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data"));
				o.setData(data);
				
				orcamentos.add(o);
			}
			rs.close();
			stmt.close();
			return orcamentos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
