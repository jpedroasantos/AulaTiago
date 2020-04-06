package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_LOGIN")
@SequenceGenerator(name="login", sequenceName="SEQ_TB_LOGIN", allocationSize = 1)
public class Login {
	
	@Id
	@Column(name="CD_LOGIN")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login")
	private int codigo; 
	
	@Column(name="DS_SENHA", nullable = false, length = 20) 
	private String senha; 
	
	@Column(name="NM_LOGIN",nullable = false, length = 20, unique = true)
	private String login;
	
	//Mapear relacionamento 1 para 1
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="CD_CLIENTE", nullable = false, unique = true)
	private Cliente cliente;
	
	public Login(String senha, String login, Cliente cliente) {
		super();
		this.senha = senha;
		this.login = login;
		this.cliente = cliente;
	}

	public Login() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
