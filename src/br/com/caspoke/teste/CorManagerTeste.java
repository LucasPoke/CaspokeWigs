package br.com.caspoke.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.caspoke.dao.IPerucaDao;
import br.com.caspoke.dao.jpa.JpaPerucaDao;
import br.com.caspoke.model.Cor;
import br.com.caspoke.model.Peruca;

public class CorManagerTeste {

	public static void main (String args[]) {
		JpaPerucaDao dao = new JpaPerucaDao();
		
		List<Peruca> perucas = dao.lista();
		ArrayList<String> coresNaoCadastradas = new ArrayList();
		ArrayList<String> coresCadastradas = new ArrayList(Arrays.asList(Cor.values()));
		
		for (int i = 0; i < perucas.size(); i++)
		{
			if(!coresCadastradas.contains(perucas.get(i).getCor()))
				coresNaoCadastradas.add(perucas.get(i).getCor());
		}
		
		System.out.println("Cores não cadastradas: ");
		for (int i = 0; i < coresNaoCadastradas.size(); i++)
		{
			System.out.println(coresNaoCadastradas.get(i));
		}
	}
}
