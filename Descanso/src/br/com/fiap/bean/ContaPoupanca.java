package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements ContaInvestimento{
	private float taxa; 
	private static final float RENDIMENTO = 0.03f; 
	
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}

	public ContaPoupanca() {}
	
	@Override 
	public void depositar(double valor) {
		saldo += valor;
	}   
	
	@Override
	public void retirar(double valor) throws SaldoInsuficienteException{
		if(valor + taxa > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		} 
		saldo -= valor + taxa;
	}
	
	@Override
	public double calcularRetornoInvestimento() {
		return saldo * RENDIMENTO;
	} 
	
	public float getTaxa() {
		return taxa;
	}


	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
}
