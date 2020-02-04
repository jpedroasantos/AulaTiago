package br.com.fiap.bean;

import java.util.Calendar;

public class ContaPoupanca extends Conta implements ContaInvestimento{
	private float taxa; 
	private static final float rendimento = 0.03f; 
	
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo) {
		super(agencia, numero, dataAbertura, saldo);
	}
	
	@Override 
	public double depositar(double valor) {
		return saldo += valor;
	}   
	
	@Override
	public double sacar(double valor) {
		return saldo -= valor;
	}
	
	@Override
	public float calcularRetornoInvestimento() {
		return (float) (saldo * rendimento);
	}
	public float getTaxa() {
		return taxa;
	}


	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
}
