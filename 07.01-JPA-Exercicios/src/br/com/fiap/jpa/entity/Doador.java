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
@Table(name="TB_DOADOR")
@SequenceGenerator(name="doador", sequenceName="SEQ_TB_DOADOR", allocationSize=1)
public class Doador {
	
	@Id 
	@Column(name = "CD_DOADOR", nullable = false) 
	@GeneratedValue(generator = "doador", strategy = GenerationType.SEQUENCE)
	private int codigo; 
	
	@Column(name = "NM_DOADOR", nullable = false, length = 80)
	private String nome; 
	
	@Column(name = "DT_NASCIMENTO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataNasc; 
	
	@Column(name = "DS_TIPO_SANGUINEO", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoSanguineo tipo;
	
	@Column(name = "ST_VIVO")
	private boolean statusVivo; 
	
	@Column(name = "VL_PESO")
	private double peso;
	
	@OneToMany(mappedBy="doador", cascade = CascadeType.ALL)
	private List<Orgao> orgaos = new ArrayList<Orgao>();
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "TB_DOADOR_INSTITUICAO", 
			joinColumns = @JoinColumn(name = "CD_DOADOR"), 
			inverseJoinColumns = @JoinColumn(name = "CD_INSTITUICAO"))
	private List<Instituicao> instituicoes;
	
	public void addOrgao(Orgao orgao) {
		orgaos.add(orgao); 
		orgao.setDoador(this);
	}
	
	public Doador() {
		super();
	}

	public Doador(String nome, Calendar dataNasc, TipoSanguineo tipo, boolean statusVivo, double peso) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.tipo = tipo;
		this.statusVivo = statusVivo;
		this.peso = peso;
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

	public boolean isStatusVivo() {
		return statusVivo;
	}

	public void setStatusVivo(boolean statusVivo) {
		this.statusVivo = statusVivo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public List<Orgao> getOrgaos() {
		return orgaos;
	}

	public void setOrgaos(List<Orgao> orgaos) {
		this.orgaos = orgaos;
	}

	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	} 
	
}
