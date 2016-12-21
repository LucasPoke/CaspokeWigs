package br.com.caspoke.model;

public class Estoque {

	private long id;
	private long peruca_id;
	private long encomenda_id;
	private int quantidade;
	private String rastreio;
	private boolean emMaos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPeruca_id() {
		return peruca_id;
	}
	public void setPeruca_id(long peruca_id) {
		this.peruca_id = peruca_id;
	}
	public long getEncomenda_id() {
		return encomenda_id;
	}
	public void setEncomenda_id(long encomenda_id) {
		this.encomenda_id = encomenda_id;
	}
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
	public boolean isEmMaos() {
		return emMaos;
	}
	public void setEmMaos(boolean emMaos) {
		this.emMaos = emMaos;
	}
	
}
