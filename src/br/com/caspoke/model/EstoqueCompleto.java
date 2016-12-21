package br.com.caspoke.model;

import java.math.BigDecimal;

public class EstoqueCompleto {
	private long id;
	private long peruca_id;//de estoque
	private int quantidade;
	private String rastreio;
	private boolean emMaos;
	private BigDecimal preco;
	private int tamanho;
	private int peso;
	private String cor;
	private String local;
	private String vendedor;
	private String link;
	
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
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
