package br.com.caspoke.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false, unique=true)
	private String email;
	@Temporal(TemporalType.DATE) //informa como salvar no banco
	@DateTimeFormat(pattern="dd/MM/yyyy") //para o Spring popular o Calendar
	private Calendar data;
	@Column(nullable = false)
	private String senha;
	private String permissao;
	@OneToMany(mappedBy="cliente", targetEntity=Orcamento.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Orcamento> orcamentos;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}
	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}
	public String getPermissao() {
		return permissao;
	}
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
	
}
