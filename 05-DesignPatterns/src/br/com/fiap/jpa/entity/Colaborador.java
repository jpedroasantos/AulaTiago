package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="TB_COLABORADOR")
@SequenceGenerator(name = "colab", sequenceName="SQ_TB_FUNCIONARIO", allocationSize = 1)
public class Colaborador {
	
	@Id
	@Column(name="CD_COLABORADOR", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "colab")
	private int cd_colaborador; 
	
	@Column(name="NM_COLABORADOR", nullable = false)
	private String nm_colaborador;
	
	@Column(name = "DS_CARGO")
	private String ds_cargo; 
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_ADMISSAO")
	private Calendar dt_admissao; 
	
	@Column(name = "VL_SALARIO")
	private float vl_salario;
	
	public Colaborador() {
		super();
	}

	public Colaborador(String nm_colaborador, String ds_cargo, Calendar dt_admissao, float vl_salario) {
		super();
		this.nm_colaborador = nm_colaborador;
		this.ds_cargo = ds_cargo;
		this.dt_admissao = dt_admissao;
		this.vl_salario = vl_salario;
	}

	public int getCd_colaborador() {
		return cd_colaborador;
	}

	public void setCd_colaborador(int cd_colaborador) {
		this.cd_colaborador = cd_colaborador;
	}

	public String getNm_colaborador() {
		return nm_colaborador;
	}

	public void setNm_colaborador(String nm_colaborador) {
		this.nm_colaborador = nm_colaborador;
	}

	public String getDs_cargo() {
		return ds_cargo;
	}

	public void setDs_cargo(String ds_cargo) {
		this.ds_cargo = ds_cargo;
	}

	public Calendar getDt_admissao() {
		return dt_admissao;
	}

	public void setDt_admissao(Calendar dt_admissao) {
		this.dt_admissao = dt_admissao;
	}

	public float getVl_salario() {
		return vl_salario;
	}

	public void setVl_salario(float vl_salario) {
		this.vl_salario = vl_salario;
	}
}
