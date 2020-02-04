package br.com.fiap.revisao.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.revisao.bean.Computador;

public class TesteColecao {

	public static void main(String[] args) {
		//Criando lista
		List<Computador> computadores = new ArrayList<Computador>();
		for(int i = 0; i < 10; i++) {
			Computador c =  new Computador("i"+i, i*100); 
			computadores.add(c);
		} 
		
		for (Computador c : computadores) {
			System.out.println(c.getNome() + " " + c.getPreco());
		} 
		
		//Criando mapa <Chave, Valor>
		Map<String, Computador> mapa = new HashMap<String, Computador>(); 
		//Adicionar dois computadores no mapa
		mapa.put("dell", new Computador("DELL I3", 1000)); 
		mapa.put("hp", new Computador("HP i7", 2000)); 
		//Recuperando o computador através da chave 
		Computador c = mapa.get("dell"); 
		System.out.println(c.getNome() + " " + c.getPreco());
	}

}
