package br.com.caspoke.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Orcamento {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(name="cliente_id") //O hibernate não salva um cliente, salva a coluna "cliente_id"
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name="encomenda_id")
	private Encomenda encomenda;
	private String personagem;
	private String serie;
	private String local;
	@Temporal(TemporalType.DATE) //informa como salvar no banco
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar data;
	private String comentarios;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	
	
	
}
