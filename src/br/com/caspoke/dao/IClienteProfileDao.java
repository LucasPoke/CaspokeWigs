package br.com.caspoke.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.caspoke.model.ClienteProfile;

public interface IClienteProfileDao {
	
	public ClienteProfile buscaPorId(int id);
	public ClienteProfile buscaPorTipo(String tipo);
	public List<ClienteProfile> lista();
}
