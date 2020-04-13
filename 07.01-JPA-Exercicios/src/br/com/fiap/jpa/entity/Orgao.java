package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="TB_ORGAO") 
@SequenceGenerator(name = "orgao", sequenceName = "SEQ_TB_ORGAO", allocationSize = 1)
public class Orgao {
	
	@Id
	@Column(name = "CD_ORGAO", nullable = false)
	@GeneratedValue(generator = "orgao", strategy=GenerationType.SEQUENCE)
	private int codigo; 
	
	@Column(name = "NM_ORGAO", nullable = false, length = 50)
	private String nome; 
	
	@Column(name = "DS_ISQUEMIA", nullable = false)
	private int isquemia; 
	
	@Column(name = "ST_VITAL")
	private boolean vital;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name="CD_DOADOR", nullable = false)
	private Doador doador;
	
	@OneToOne(mappedBy = "orgao", cascade = CascadeType.ALL)
	private Transplante transplante;
	
	public Orgao() {
		super();
	}

	public Orgao(String nome, int isquemia, boolean vital) {
		super();
		this.nome = nome;
		this.isquemia = isquemia;
		this.vital = vital;
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

	public int getIsquemia() {
		return isquemia;
	}

	public void setIsquemia(int isquemia) {
		this.isquemia = isquemia;
	}

	public boolean isVital() {
		return vital;
	}

	public void setVital(boolean vital) {
		this.vital = vital;
	}

	public Doador getDoador() {
		return doador;
	}

	public void setDoador(Doador doador) {
		this.doador = doador;
	}

	public Transplante getTransplante() {
		return transplante;
	}

	public void setTransplante(Transplante transplante) {
		this.transplante = transplante;
	} 
}
