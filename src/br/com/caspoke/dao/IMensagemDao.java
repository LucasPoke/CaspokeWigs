package br.com.caspoke.dao;

import br.com.caspoke.model.Mensagem;

public interface IMensagemDao {

	public Mensagem buscaPorId(long id);
	public void insere(Mensagem m);
	public void remove(Mensagem m);
	public void altera(Mensagem m);
}
