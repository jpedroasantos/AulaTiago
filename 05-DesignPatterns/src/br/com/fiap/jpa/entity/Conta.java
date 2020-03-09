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

@Entity
@Table(name="TB_CONTA") 
@SequenceGenerator(name = "conta", sequenceName = "SQ_TB_CONTA", allocationSize = 1)
public class Conta {
	
	@Id 
	@Column(name="CD_CONTA", nullable = false) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta")
	private int cd_conta; 
	
	@Column(name="NR_AGENCIA", nullable = false)
	private int nr_agencia; 
	
	@Enumerated(EnumType.STRING) 
	@Column(name="DS_TIPO")
	private TipoConta tipo;
	
	@Column(name="VL_SALDO")
	private float vl_saldo; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_ABERTURA")
	private Calendar dt_abertura;
	
	
	public Conta() {
		super();
	}

	public Conta(int nr_agencia, TipoConta tipo, float vl_saldo, Calendar dt_abertura) {
		super();
		this.nr_agencia = nr_agencia;
		this.tipo = tipo;
		this.vl_saldo = vl_saldo;
		this.dt_abertura = dt_abertura;
	}

	public int getCd_conta() {
		return cd_conta;
	}

	public void setCd_conta(int cd_conta) {
		this.cd_conta = cd_conta;
	}

	public int getNr_agencia() {
		return nr_agencia;
	}

	public void setNr_agencia(int nr_agencia) {
		this.nr_agencia = nr_agencia;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public float getVl_saldo() {
		return vl_saldo;
	}

	public void setVl_saldo(float vl_saldo) {
		this.vl_saldo = vl_saldo;
	}

	public Calendar getDt_abertura() {
		return dt_abertura;
	}

	public void setDt_abertura(Calendar dt_abertura) {
		this.dt_abertura = dt_abertura;
	} 
} 
