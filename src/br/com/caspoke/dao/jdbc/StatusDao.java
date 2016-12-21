package br.com.caspoke.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caspoke.model.Status;

@Repository
public class StatusDao {

	Connection con;
	
	@Autowired
	public StatusDao (DataSource dataSource) {
		try {
			this.con = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insere (Status s) {
		String sql = "insert into status (id, valor) values (?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, s.getId());
			stmt.setString(2, s.getValor());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Status> getLista () {
		try {
			ArrayList<Status> status = new ArrayList();
			PreparedStatement stmt = this.con.prepareStatement("select * from status");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Status s = new Status();
				s.setId(rs.getInt("id"));
				s.setValor(rs.getString("valor"));
				
				status.add(s);
			}
			rs.close();
			stmt.close();
			return status;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
