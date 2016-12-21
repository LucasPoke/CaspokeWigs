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

import br.com.caspoke.model.Encomenda;
import br.com.caspoke.model.EncomendaCompleta;

@Repository
public class JdbcEncomendaDao {

	private Connection con;
	
	@Autowired
	public JdbcEncomendaDao (DataSource dataSource) {
		try {
			this.con = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insere (Encomenda e) {
		System.out.println("entra aq");
		String sql = "insert into encomendas (orcamento_id, preco, frete, rastreio_br, status_id, data_inicio) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, e.getOrcamento_id());
			stmt.setBigDecimal(2, e.getPreco());
			stmt.setBigDecimal(3, e.getFrete());
			stmt.setString(4, e.getRastreio_br());
			stmt.setInt(5, e.getStatus_id());
			if (e.getData_inicio() != null)
				stmt.setDate(6, new Date(e.getData_inicio().getTimeInMillis()));
			else
				stmt.setDate(6, null);
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public ArrayList<Encomenda> getLista () {
		try {
			ArrayList<Encomenda> encomendas = new ArrayList();
			PreparedStatement stmt = this.con.prepareStatement("select * from encomendas");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Encomenda e = new Encomenda();
				e.setId(rs.getLong("id"));
				e.setPreco(rs.getBigDecimal("preco"));
				e.setFrete(rs.getBigDecimal("frete"));
				e.setRastreio_br(rs.getString("rastreio_br"));
				e.setStatus_id(rs.getInt("status_id"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_inicio"));
				e.setData_inicio(data);
				encomendas.add(e);
			}
			rs.close();
			stmt.close();
			return encomendas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<EncomendaCompleta> getListaCompleta () {
		try {
			ArrayList<EncomendaCompleta> encomendas = new ArrayList();
			PreparedStatement stmt = this.con.prepareStatement("select encomendas.id, orcamento_id, cliente_id, nome, email, personagem, serie, preco, frete, rastreio_br rastreio, valor status, local, data_inicio, comentarios from clientes "
					+ "join orcamentos on clientes.id = cliente_id "
					+ "join encomendas on orcamento_id = orcamentos.id "
					+ "join status on status_id = status.id "
					+ "order by status_id desc;");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				EncomendaCompleta e = new EncomendaCompleta();
				e.setId(rs.getLong("id"));
				e.setOrcamento_id(rs.getLong("orcamento_id"));
				e.setCliente_id(rs.getLong("cliente_id"));
				e.setNome(rs.getString("nome"));
				e.setEmail(rs.getString("email"));
				e.setPersonagem(rs.getString("personagem"));
				e.setSerie(rs.getString("serie"));
				e.setPreco(rs.getBigDecimal("preco"));
				e.setFrete(rs.getBigDecimal("frete"));
				e.setRastreio(rs.getString("rastreio"));
				e.setStatus(rs.getString("status"));
				e.setLocal(rs.getString("local"));
				e.setComentarios(rs.getString("comentarios"));
				Date d = rs.getDate("data_inicio");
				if (d!= null)
				{
					Calendar data = Calendar.getInstance();
					data.setTime(d);
					e.setData(data);
				}
				
				
				encomendas.add(e);
			}
			rs.close();
			stmt.close();
			return encomendas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleta (Encomenda e) {
		String sql = "delete from encomendas where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, e.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}
