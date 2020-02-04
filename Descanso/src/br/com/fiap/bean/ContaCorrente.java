package br.com.fiap.bean;

import java.util.Calendar;

public class ContaCorrente extends Conta{
	
	private TipoConta tipo;  
	
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo) {
		super(agencia, numero, dataAbertura, saldo);
	}
	
	@Override 
	public double depositar(double valor) {
		return saldo += valor;
	} 
	
	public double retirar(double valor) {
		if(tipo.equals(TipoConta.COMUM) && saldo < 0) {
			Exception e = new Exception(); 
			e.printStackTrace();
		} 
		return saldo - valor;
	}
 
	public TipoConta getTipoconta() {
		return tipo;
	}

	public void setTipoconta(TipoConta tipoconta) {
		this.tipo = tipoconta;
	} 
	
	
	
	
}
