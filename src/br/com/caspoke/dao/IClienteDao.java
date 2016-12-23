package br.com.caspoke.dao;

import java.util.List;

import br.com.caspoke.model.Cliente;

public interface IClienteDao {

	public List<Cliente> buscaPorNome(String nome);
	public Cliente buscaPorLogin(Cliente c);
	public List<Cliente> lista();
	public Cliente buscaPorId(long id);
	public void insere(Cliente c);
	public void remove(Cliente c);
	public void altera(Cliente c);
}