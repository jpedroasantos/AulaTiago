package br.com.fiap.revisao.bean;

public class Computador extends Produto{
	
	private static final double taxa = 0.05;
	
	public Computador(String nome, double preco) {
		super(nome, preco);
	}
	
	//sobrescrita de metodos(mesmo método na classe filha)  
	@Override
	public double descontar(double desconto) {
		return preco * (1 + taxa) - desconto;
	} 
	
	@Override
	public void aumentar(double valor) {
		this.preco += valor;
	}
}
