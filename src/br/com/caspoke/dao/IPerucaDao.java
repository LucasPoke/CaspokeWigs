package br.com.caspoke.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.caspoke.model.Cor;
import br.com.caspoke.model.Peruca;

public interface IPerucaDao {
	
	public List<Peruca> lista();
	public Peruca buscaPorId(long id);
	public List<Peruca> buscaPorCor(Cor cor);
	public void insere(Peruca p);
	public void remove(Peruca p);
	public void altera(Peruca p);
	public void insereVarias(ArrayList<Peruca> perucas);
}
