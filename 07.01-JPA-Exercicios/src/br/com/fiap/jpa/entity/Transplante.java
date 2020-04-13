package br.com.fiap.jpa.entity;

import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity 
@Table(name = "TB_TRANSPLANTE")
@SequenceGenerator(name = "transplante", sequenceName="SEq_TB_TRNASPLANTE", allocationSize=1)
public class Transplante {
	
	@Id 
	@Column(name = "CD_TRANSPLANTE", nullable = false)
	@GeneratedValue(generator = "transplante", strategy = GenerationType.SEQUENCE)
	private int codigo; 
	
	@Column(name = "DT_TRANSPLANTE")
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	@JoinColumn(name = "CD_ORGAO", nullable = false, unique = true)
	private Orgao orgao; 
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER) 
	@JoinColumn(name = "CD_PACIENTE", nullable = false)
	private Paciente paciente;

	public Transplante(Calendar data, Orgao orgao, Paciente paciente) {
		super();
		this.data = data;
		this.orgao = orgao;
		this.paciente = paciente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
