package br.com.fiap.revisao.bean;

// classe abstrata -> n�o pode ser instanciada, pode conter metodos abstratos
public abstract class Produto {
	
	private String nome; 
	protected double preco; 
	private Embalagem embalagem;
	
	public Produto(String nome, double preco) {
		this.nome = nome; 
		this.preco = preco;
	} 
	
	public double descontar(double desconto) {
		return preco - desconto;
	} 
	
	//sobrecarga de m�todos(mesmo m�todo, parametros diferentes)
	public double descontar(int porcentagem) {
		return (preco * porcentagem) / 100;
	} 
	
	//metodo abstrato -> metodo sem implementa��o
	public abstract void aumentar(double valor); 
	
	
	public String getNome() {
		return this.nome;
	} 
	
	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	public double getPreco() {
		return this.preco; 
	} 
	
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Embalagem getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(Embalagem embalagem) {
		this.embalagem = embalagem;
	}
}
