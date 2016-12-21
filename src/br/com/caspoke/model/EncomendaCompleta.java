package br.com.caspoke.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class EncomendaCompleta {

	//ids
	private long id; //
	private long orcamento_id; //
	private long cliente_id; //de orcamento
	
	//Dados sobre cliente
	private String nome;
	private String email;
	
	//Dados sobre personagem
	private String personagem;
	private String serie;
	
	//Dados sobre encomenda
	private BigDecimal preco;
	private BigDecimal frete;
	private String rastreio; //rastreio_br
	private String status; //valor
	
	//Dados sobre orçamento
	private String local;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar data;
	private String comentarios;
	
	private ArrayList<EstoqueCompleto> perucas_base;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOrcamento_id() {
		return orcamento_id;
	}
	public void setOrcamento_id(long orcamento_id) {
		this.orcamento_id = orcamento_id;
	}
	public long getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(long cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPersonagem() {
		return personagem;
	}
	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
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
	public String getRastreio() {
		return rastreio;
	}
	public void setRastreio(String rastreio) {
		this.rastreio = rastreio;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public ArrayList<EstoqueCompleto> getPerucas_base() {
		return perucas_base;
	}
	public void setPerucas_base(ArrayList<EstoqueCompleto> perucas_base) {
		this.perucas_base = perucas_base;
	}
	
		
}
