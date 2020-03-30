package br.com.fiap.jpa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.fiap.jpa.util.Calculadora;

class CalculadoraTest {

	@Test
	void test() {
		Calculadora calc = new Calculadora(); 
		int soma = calc.somar(5, 3); 
		assertEquals(8, soma);
	}

}
