package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Produto;

public class TesteRefresh {

	public static void main(String[] args) {
		// criar o EntityManager 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle"); 
		EntityManager em = fabrica.createEntityManager();
		
		//pesquisar um produto pelo codigo
		Produto prod = em.find(Produto.class, 1); 
		
		//exibir o nome do produto 
		System.out.println(prod.getNome());
		
		//fazer um set no nome do produto 
		prod.setNome("Motorola");
		
		//exibir o nome do produto 
		System.out.println(prod.getNome());
		
		//fazer um refresh 
		em.refresh(prod); 
		
		//exibir o nome do produto 
		System.out.println(prod.getNome());
		
		//fechar a paradas
		em.close(); 
		fabrica.close();
	}

}
