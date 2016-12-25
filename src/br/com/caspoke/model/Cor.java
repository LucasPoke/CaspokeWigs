package br.com.caspoke.model;

public enum Cor {

	Preto ("000000", "Preto"),
	Branco ("ffffff", "Branco"),
	Branco_prateado ("e2e2e2", "Branco prateado"),
	
	Cinza ("ababab", "Cinza"),
	//Cinza_escuro,
	
	Vermelho ("c51533", "Vermelho"),
	Vermelho_escuro ("6a0c14", "Vermelho escuro"),
	
	Marrom ("5c3e2f", "Marrom"),
	Marrom_claro ("9e6f4f", "Marrom claro"),
	Marrom_escuro ("3f2e28", "Marrom escuro"),
	
	Laranja ("c65624", "Laranja"),
	
	Loiro_claro ("c9ba93", "Loiro claro"),
	Loiro ("b59e6c", "Loiro"),
	Loiro_amarelado ("e3cc80", "Loiro amarelado"),
	
	Amarelo ("e5db1a", "Amarelo"),
	
	Verde_neon ("a7cd06", "Verde neon"),
	Verde_oliva ("878521", "Verde oliva"),
	Verde ("157044", "Verde"),
	Verde_escuro ("2c5144", "Verde escuro"),
	
	Turquesa ("2ca5a0", "Turquesa"),
	
	Azul_claro ("6fb9d2", "Azul claro"),
	Azul ("3364bb", "Azul"),
	Azul_petroleo ("4c7b97", "Azul petroleo"),
	Azul_escuro ("0260a8", "Azul escuro"),
	Azul_marinho ("20335e", "Azul marinho"),
	
	Roxo ("943cc4", "Roxo"),
	Lilas ("aa81ca", "Lilás"),
	Roxo_escuro ("4e2976", "Roxo escuro"),
	
	Rosa ("d346a6", "Rosa"),
	Rosa_claro ("e9afdf", "Rosa claro");
	
	private String cod;
	private String nome;
	
	private Cor (String cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}