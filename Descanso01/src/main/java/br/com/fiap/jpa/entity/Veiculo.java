package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name="T_VEICULO") 
@SequenceGenerator(name = "vei", sequenceName="SQ_T_VEICULO", allocationSize = 1)
public class Veiculo {
	
	@Id 
	@Column(name="CD_VEICULO", nullable = false) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vei")
	private int cd_veiculo; 
	
	@Column(name="DS_PLACA", nullable = false, length = 9)
	private String ds_placa; 
	
	@Column(name="DS_COR", nullable = false, length = 20)
	private String ds_cor; 
	
	@Column(name="NR_ANO")
	private int nr_ano;
	
	public Veiculo() {
		super();
	}

	public Veiculo(String ds_placa, String ds_cor, int nr_ano) {
		super();
		this.ds_placa = ds_placa;
		this.ds_cor = ds_cor;
		this.nr_ano = nr_ano;
	}

	public int getCd_veiculo() {
		return cd_veiculo;
	}

	public void setCd_veiculo(int cd_veiculo) {
		this.cd_veiculo = cd_veiculo;
	}

	public String getDs_placa() {
		return ds_placa;
	}

	public void setDs_placa(String ds_placa) {
		this.ds_placa = ds_placa;
	}

	public String getDs_cor() {
		return ds_cor;
	}

	public void setDs_cor(String ds_cor) {
		this.ds_cor = ds_cor;
	}

	public int getNr_ano() {
		return nr_ano;
	}

	public void setNr_ano(int nr_ano) {
		this.nr_ano = nr_ano;
	} 
}
