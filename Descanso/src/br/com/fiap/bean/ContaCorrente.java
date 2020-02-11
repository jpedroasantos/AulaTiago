package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta{
	
	private TipoConta tipo;  
	
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	public ContaCorrente() {}
	
	@Override 
	public void depositar(double valor) {
		saldo += valor;
	} 
	
	public void retirar(double valor) throws SaldoInsuficienteException {
		if(tipo == TipoConta.COMUM && saldo < valor) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		} 
		saldo -= valor;
	}
	
	public TipoConta getTipoconta() {
		return tipo;
	}

	public void setTipoconta(TipoConta tipoconta) {
		this.tipo = tipoconta;
	} 
	
	
	
	
}
