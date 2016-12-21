package br.com.caspoke.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
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
	@OneToOne(optional = false)
	@JoinColumn(name = "orcamento_id")
	private Orcamento orcamento;
	@Column(nullable = false)
	private BigDecimal preco;
	private BigDecimal frete;
	private String rastreio_br;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="status_id", nullable = false)
	private StatusEncomenda status;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(nullable = false)
	private Calendar data_cadastro;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar data_inicio;
	
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
	public StatusEncomenda getStatus() {
		return status;
	}
	public void setStatus(StatusEncomenda status) {
		this.status = status;
	}
	public Calendar getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Calendar data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Calendar getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Calendar data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	
	
}
