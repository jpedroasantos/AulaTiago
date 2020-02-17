package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostLoad;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_PRODUTO")
//name = nome da sequencia no java (@GeneratedValue) 
//sequence name = nome da sequencia no bd
@SequenceGenerator(name = "produto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class Produto {

	@Id
	@Column(name = "CD_PRODUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private int id;

	@Column(name = "NM_PRODUTO", nullable = false, length = 50)
	private String nome;

	@Column(name = "VL_PRODUTO")
	private double valor;

	@Transient // não será mapeado para base de dados
	private double valorLiquido;

	@Column(name = "DT_VENCIMENTO")
	@Temporal(TemporalType.DATE) // armazena no banco somente a data, sem horario
	private Calendar dataVencimento;

	@Column(name = "IMG_PRODUTO")
	@Lob // mapeia uma coluna do tipo BLOB, para armazenar arquivos no banco
	private byte[] imagem;

	@Column(name = "NM_CATEGORIA")
	@Enumerated(EnumType.STRING) // armazena a String no banco e não a posição
	private Categoria categoria;
	
	public Produto() {
		super();
	}

	public Produto(String nome, double valor, double valorLiquido, Calendar dataVencimento, byte[] imagem,
			Categoria categoria) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.valorLiquido = valorLiquido;
		this.dataVencimento = dataVencimento;
		this.imagem = imagem;
		this.categoria = categoria;
	}
	
	//Metodo executado depois de pesquisar 
	@PostLoad 
	public void carregar() {
		valorLiquido = valor * 0.85; 
		System.out.println("Carregando valor liquido.. após pesquisar no banco");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
