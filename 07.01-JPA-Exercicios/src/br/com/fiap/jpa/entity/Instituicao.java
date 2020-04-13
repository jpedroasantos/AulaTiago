package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_INSTITUICAO")
@SequenceGenerator(name = "instituicao", sequenceName = "SEQ_TB_INSTITUICAO", allocationSize = 1)
public class Instituicao {
	
	@Id
	@Column(name="CD_INSTITUICAO", nullable = false) 
	@GeneratedValue(generator = "instituicao", strategy = GenerationType.SEQUENCE)
	private int codigo; 
	
	@Column(name="NM_INSTITUICAO", nullable = false, length = 100)
	private String nome;
	
	@ManyToMany(mappedBy = "instituicoes")
	private List<Paciente> paciente;
	
	@ManyToMany(mappedBy= "instituicoes") 
	private List<Doador> doador;
	
	public Instituicao() {
		super();
	}

	public Instituicao(String nome) {
		super();
		this.nome = nome;
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

	public List<Paciente> getPaciente() {
		return paciente;
	}

	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}

	public List<Doador> getDoador() {
		return doador;
	}

	public void setDoador(List<Doador> doador) {
		this.doador = doador;
	}
}
