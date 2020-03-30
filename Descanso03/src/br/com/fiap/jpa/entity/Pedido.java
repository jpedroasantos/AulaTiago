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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PEDIDO")
@SequenceGenerator(name="pedido", sequenceName="SEQ_TB_PEDIDO", allocationSize = 1)
public class Pedido {
	
	@Id
	@Column(name="CD_PEDIDO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	private int codigo; 
	
	@Column(name="VL_PEDIDO", nullable = false)
	private float valor; 
	
	@Column(name="QT_PEDIDO", nullable = false)
	private int quantidade; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_PEDIDO")
	private Calendar dataPedido;
	
	//relacionamento muitos para 1 
	//Pensar na classe corrente para a classe da relação -> (Vários) Pedidos - (Um) Cliente
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinColumn(name="CD_CLIENTE", nullable = false)
	private Cliente cliente;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
