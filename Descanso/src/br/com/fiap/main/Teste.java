package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.Conta;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Teste {

	public static void main(String[] args) {
		
		ContaCorrente cc = 
				new ContaCorrente(1, 222, Calendar.getInstance(), 200, TipoConta.COMUM); 
		
		ContaPoupanca cp =
				new ContaPoupanca(1, 123, new GregorianCalendar(2019, Calendar.MAY, 20), 1000, 3); 
		
		List<Conta> lista = new ArrayList<Conta>(); 
		lista.add(cp); 
		lista.add(cc); 
		lista.add(new ContaCorrente(1, 32, Calendar.getInstance(), 8000, TipoConta.ESPECIAL)); 
		
		for (Conta conta : lista) {
			System.out.println(conta.getSaldo());
		} 
		
		try {
			cc.retirar(5000);
		}  catch (SaldoInsuficienteException e1) {
			System.err.println(e1.getMessage());
		}
	}

}
