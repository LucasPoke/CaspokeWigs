package br.com.caspoke.model;

public enum Permissao {

	NORMAL("NORMAL"),
	PARCIAL("PARCIAL"),
	TOTAL("TOTAL");
	
	String tipo;
	
	private Permissao(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
}
