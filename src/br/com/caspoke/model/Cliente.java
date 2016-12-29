package br.com.caspoke.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	@OneToMany(mappedBy="cliente", targetEntity=Orcamento.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Orcamento> orcamentos;
	@NotEmpty
    @Column(unique=true, nullable=false)
    private String ssoId;
	@NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CLIENTE_X_CLIENTE_PROFILE", 
             joinColumns = { @JoinColumn(name = "CLIENTE_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "CLIENTE_PROFILE_ID") })
    private Set<ClienteProfile> profiles = new HashSet<ClienteProfile>();
	
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
	public String getSsoId() {
		return ssoId;
	}
	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}
	public Set<ClienteProfile> getProfiles() {
		return profiles;
	}
	public void setProfiles(Set<ClienteProfile> profiles) {
		this.profiles = profiles;
	}
	
	
}
