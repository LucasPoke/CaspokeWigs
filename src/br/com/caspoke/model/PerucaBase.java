package br.com.caspoke.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PerucaBase {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private int quantidade;
	private String rastreio;
	private boolean chegou;
	@ManyToOne(optional = false)
	@JoinColumn(name = "peruca_id")
	Peruca peruca;
	@ManyToOne
	@JoinColumn(name = "encomenda_id")
	Encomenda encomenda;
	
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Peruca getPeruca() {
		return peruca;
	}
	public void setPeruca(Peruca peruca) {
		this.peruca = peruca;
	}
	public boolean isChegou() {
		return chegou;
	}
	public void setChegou(boolean chegou) {
		this.chegou = chegou;
	}
	public Encomenda getEncomenda() {
		return encomenda;
	}
	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}
}
