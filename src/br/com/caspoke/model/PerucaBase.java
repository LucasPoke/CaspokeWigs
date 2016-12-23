package br.com.caspoke.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class PerucaBase extends Peruca {

	private int quantidade;
	private String rastreio;
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getRastreio() {
		return rastreio;
	}
	public void setRastreio(String rastreio) {
		this.rastreio = rastreio;
	}
}
