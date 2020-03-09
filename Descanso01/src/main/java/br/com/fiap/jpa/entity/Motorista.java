package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name = "T_MOTORISTA") 
public class Motorista {
	
	@Id
	@Column(name="NR_CARTEIRA", nullable = false)
	private int nr_carteira; 
	
	@Column(name="NM_MOTORISTA", nullable = false) 
	private String nm_motorista;  
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASC")
	private Calendar dt_nascimento; 
	
	@Column(name="FL_CARTEIRA") 
	@Lob 
	private byte[] fl_carteira; 
	
	@Column(name="DS_GENERO")
	private String ds_genero;
	
	public Motorista() {
		super();
	}

	public Motorista(int nr_carteira, String nm_motorista, Calendar dt_nascimento, byte[] fl_carteira,
			String ds_genero) {
		super();
		this.nr_carteira = nr_carteira;
		this.nm_motorista = nm_motorista;
		this.dt_nascimento = dt_nascimento;
		this.fl_carteira = fl_carteira;
		this.ds_genero = ds_genero;
	}

	public int getNr_carteira() {
		return nr_carteira;
	}

	public void setNr_carteira(int nr_carteira) {
		this.nr_carteira = nr_carteira;
	}

	public String getNm_motorista() {
		return nm_motorista;
	}

	public void setNm_motorista(String nm_motorista) {
		this.nm_motorista = nm_motorista;
	}

	public Calendar getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Calendar dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public byte[] getFl_carteira() {
		return fl_carteira;
	}

	public void setFl_carteira(byte[] fl_carteira) {
		this.fl_carteira = fl_carteira;
	}

	public String getDs_genero() {
		return ds_genero;
	}

	public void setDs_genero(String ds_genero) {
		this.ds_genero = ds_genero;
	} 
}
