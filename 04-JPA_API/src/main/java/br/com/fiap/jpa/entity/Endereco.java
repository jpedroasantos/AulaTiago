package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity 
@Table(name="TB_ENDERECO") 
@SequenceGenerator(name = "end", sequenceName="SQ_TB_ENDERECO", allocationSize = 1)
public class Endereco {
	
	@Id
	@Column(name="CD_ENDERECO", nullable=false) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "end")
	private int codigo; 
	
	@Column(name="NR_CEP", nullable = false, length = 8)
	private String cep; 
	
	@Column(name="DS_LOGRADOURO", length = 50, nullable = false)
	private String logradouro; 
	
	@Enumerated(EnumType.STRING) 
	@Column(name="DS_TIPO")
	private Tipo tipo; 
	
	@CreationTimestamp //Cria a data de cadatro automaticamnete
	@Temporal(TemporalType.DATE) 
	@Column(name="DT_CADASTRO")
	private Calendar dataCadastro;
	
	public Endereco() {
		super();
	}

	public Endereco(String cep, String logradouro, Tipo tipo) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	} 
}
