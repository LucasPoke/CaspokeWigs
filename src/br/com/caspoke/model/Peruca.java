package br.com.caspoke.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("P")
public class Peruca {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private BigDecimal preco;
	@Column(nullable = false)
	private int tamanho;
	private int peso;
	@Column(nullable = false)
	private String cor;
	@Column(nullable = false)
	private String local;
	@Column(nullable = false)
	private String vendedor;
	@Column(nullable = false)
	private String link;
	private int avaliacao;
	private boolean temDivisao;
	private boolean semFranja;
	private boolean temOmbre;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	public boolean getTemDivisao() {
		return temDivisao;
	}
	public void setTemDivisao(boolean temDivisao) {
		this.temDivisao = temDivisao;
	}
	public boolean getSemFranja() {
		return semFranja;
	}
	public void setSemFranja(boolean semFranja) {
		this.semFranja = semFranja;
	}
	public boolean getTemOmbre() {
		return temOmbre;
	}
	public void setTemOmbre(boolean temOmbre) {
		this.temOmbre = temOmbre;
	}
	
	

}
