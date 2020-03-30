package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CLIENTE") 
@SequenceGenerator(name = "cliente", sequenceName = "SEQ_TB_CLIENTE", allocationSize = 1)
public class Cliente {
	
	@Id
	@Column(name="CD_CLIENTE", nullable = false, length = 50)
	@GeneratedValue(generator = "cliente", strategy = GenerationType.SEQUENCE)
	private int codigo; 
	
	@Column(name="NM_CLIENTE", nullable = false, length = 50)
	private String nome; 
	
	@Column(name="DS_SOBRENOME")
	private String sobrenome; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASCIMENTO")
	private Calendar dtNasc;
	
	//relacionamento bidirecional precisa do mappedBy (atributo do outro lado da relação)
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;
	
	//mapeamento bidirecional 1 para 1
	//mappedBy -> utilizado quando for bidirecional
	//mappedBy -> atributo que mapeia a FK, na outra classe(Login)
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Login login;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Calendar getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Calendar dtNasc) {
		this.dtNasc = dtNasc;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	} 
}
