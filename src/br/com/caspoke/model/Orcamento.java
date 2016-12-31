package br.com.caspoke.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private String personagem;
	private String serie;
	private String local;
	@Temporal(TemporalType.DATE) //informa como salvar no banco
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar data_cadastro;
	private boolean aceito;
	@OneToMany(mappedBy="orcamento", targetEntity=Mensagem.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Mensagem> mensagens;
	
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
	public Calendar getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Calendar data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public boolean isAceito() {
		return aceito;
	}
	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}
	public List<Mensagem> getMensagens() {
		return mensagens;
	}
	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
	
}
