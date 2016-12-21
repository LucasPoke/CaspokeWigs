package br.com.caspoke.dao;

import java.util.List;

import br.com.caspoke.model.Cliente;
import br.com.caspoke.model.Encomenda;

public interface IEncomendaDao {

	public List<Encomenda> lista();
	public Encomenda buscaPorId(long id);
	public void insere(Encomenda e);
	public void remove(Encomenda e);
	public void altera(Encomenda e);
}
