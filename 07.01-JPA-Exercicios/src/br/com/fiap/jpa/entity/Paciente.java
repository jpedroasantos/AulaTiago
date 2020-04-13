package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PACIENTE") 
@SequenceGenerator(name="paciente", sequenceName="SEQ_TB_PACIENTE", allocationSize = 1)
public class Paciente {
	
	@Id 
	@Column(name = "CD_PACIENTE", nullable = false)
	@GeneratedValue(generator = "paciente", strategy = GenerationType.SEQUENCE)
	private int codigo; 
	
	@Column(name = "NM_PACIENTE", nullable = false, length = 80)
	private String nome; 
	
	@Column(name = "DT_NASCIMENTO", nullable = false) 
	@Temporal(TemporalType.DATE)
	private Calendar dataNasc; 
	
	@Column(name = "DS_TIPO_SANGUINEO", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoSanguineo tipo; 
	
	@Column(name= "VL_PESO")
	private double peso;
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Transplante> transplantes = new ArrayList<Transplante>();
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "TB_PACIENTE_INSTITUICAO", 
			joinColumns = @JoinColumn(name="CD_PACIENTE"),
			inverseJoinColumns = @JoinColumn(name = "CD_INSTITUICAO"))
	private List<Instituicao> instituicoes;
	
	public Paciente() {
		super();
	}

	public Paciente(String nome, Calendar dataNasc, TipoSanguineo tipo, double peso) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.tipo = tipo;
		this.peso = peso;
	}
	
	public void addTransplante(Transplante transplante) {
		transplantes.add(transplante); 
		transplante.setPaciente(this);
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

	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public TipoSanguineo getTipo() {
		return tipo;
	}

	public void setTipo(TipoSanguineo tipo) {
		this.tipo = tipo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	} 
}
