package br.com.caspoke.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private Calendar data_inicio;
	@Column(nullable = false)
	private StatusEncomenda status;
	
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
	public Calendar getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Calendar data_inicio) {
		this.data_inicio = data_inicio;
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
	
	
}
