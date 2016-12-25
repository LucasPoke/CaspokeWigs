package br.com.caspoke.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Encomenda {

	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	@JoinColumn(name="orcamento_id")
	private Orcamento orcamento;
	private BigDecimal preco;
	private BigDecimal frete;
	private String rastreio_br;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar data_pagamento;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar data_final;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar data_envio;
	
	@Column(nullable = false)
	private StatusEncomenda status;
	private int tempoConfeccao; //em Semanas
	@OneToMany(mappedBy = "encomenda")
	private List<PerucaBase> perucasBase;
	
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public BigDecimal getFrete() {
		return frete;
	}
	public void setFrete(BigDecimal frete) {
		this.frete = frete;
	}
	public String getRastreio_br() {
		return rastreio_br;
	}
	public void setRastreio_br(String rastreio_br) {
		this.rastreio_br = rastreio_br;
	}
	public Calendar getData_pagamento() {
		return data_pagamento;
	}
	public void setData_pagamento(Calendar data_pagamento) {
		this.data_pagamento = data_pagamento;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	public StatusEncomenda getStatus() {
		return status;
	}
	public void setStatus(StatusEncomenda status) {
		this.status = status;
	}
	public Calendar getData_final() {
		return data_final;
	}
	public void setData_final(Calendar data_final) {
		this.data_final = data_final;
	}
	public Calendar getData_envio() {
		return data_envio;
	}
	public void setData_envio(Calendar data_envio) {
		this.data_envio = data_envio;
	}
	public int getTempoConfeccao() {
		return tempoConfeccao;
	}
	public void setTempoConfeccao(int tempoConfeccao) {
		this.tempoConfeccao = tempoConfeccao;
	}
	public List<PerucaBase> getPerucasBase() {
		return perucasBase;
	}
	public void setPerucasBase(List<PerucaBase> perucasBase) {
		this.perucasBase = perucasBase;
	}
	
	
}
