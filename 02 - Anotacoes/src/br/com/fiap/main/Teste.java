package br.com.fiap.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.bean.Produto;

public class Teste {

	public static void main(String[] args) {
		Produto prod = new Produto(); 
		
		System.out.println("ATRIBUTOS: ");
		//Recuperar os atributos da classe 
		Field[] atributos = prod.getClass().getDeclaredFields();  
		
		//Exibir os atributos 
		for (Field a : atributos) {
			//Recuperar anotação @coluna 
			Coluna anotacao = a.getAnnotation(Coluna.class);  
			//Exibir o nome + anotação
			System.out.println(a.getName() + " - " + anotacao.nome() + " - " + anotacao.chave()); 
		}
		
		System.out.println("METODOS: "); 
		//recuperar os metodos da classe 
		Method[] metodos = prod.getClass().getDeclaredMethods(); 
		//Exibir os nomes dos metodos da classe 
		for(Method m : metodos) {
			System.out.println(m.getName());
		}

	}

}
