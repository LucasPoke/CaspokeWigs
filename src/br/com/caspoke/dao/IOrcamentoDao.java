package br.com.caspoke.dao;

import java.util.List;

import br.com.caspoke.model.Orcamento;

public interface IOrcamentoDao {
	
	public List<Orcamento> lista();
	public List<Orcamento> listaEmEspera();
	public Orcamento buscaPorId(long id);
	public void insere(Orcamento o);
	public void remove(Orcamento o);
	public void altera(Orcamento o);
	public List<Orcamento> listaAceitos();
	
}
