package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	//mapeamento bidirecional 1 para 1
	//mappedBy -> utilizado quando for bidirecional
	//mappedBy -> atributo que mapeia a FK, na outra classe(Login)
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Login login;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	//JoinTable modifica as configurações da tabela associativa(nome da tabela) 
	//joinColumns : coluna que armazena a PK da classe que estamos)
	//inverseJoinColumns : coluna que armazena a PK da classe que estamos relacionando 
	@JoinTable(name = "TB_CLIENTE_ENDERECO", 
			joinColumns = @JoinColumn(name="CD_CLIENTE"), 
			inverseJoinColumns = @JoinColumn(name="CD_ENDERECO"))
	private List<Endereco> enderecos;
	
	//Metodo que adiciona o pedido no cliente (Somente no OneToMany)
	public void addPedidos(Pedido pedido) {
		//adicionar o pedido na lista de pedidos 
		pedidos.add(pedido); 
		//setar o cliente nos pedidos 
		pedido.setCliente(this);
	}
	
	public Cliente(String nome, String sobrenome, Calendar dtNasc) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dtNasc = dtNasc;
	}

	public Cliente() {
		super();
	}

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

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	} 
}
