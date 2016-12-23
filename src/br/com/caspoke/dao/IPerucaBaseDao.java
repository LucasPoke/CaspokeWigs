package br.com.caspoke.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.caspoke.model.Cor;
import br.com.caspoke.model.PerucaBase;

public interface IPerucaBaseDao {
	
	public List<PerucaBase> lista();
	public PerucaBase buscaPorId(long id);
	public void insere(PerucaBase p);
	public void remove(PerucaBase p);
	public void altera(PerucaBase p);
}
