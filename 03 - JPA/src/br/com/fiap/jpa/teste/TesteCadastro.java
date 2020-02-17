package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Categoria;
import br.com.fiap.jpa.entity.Produto;

public class TesteCadastro {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle"); 
		EntityManager em = fabrica.createEntityManager(); 
		
		//Instanciar o objeto 
		Produto prod = new Produto("Xiaomi", 1000, 950, null, null, Categoria.ELETRONICO); 
		
		em.persist(prod); // cadastra o produto (Gerenciado pelo EntityManager) 
		
		em.getTransaction().begin(); 
		em.getTransaction().commit();
		
		em.close(); 
		fabrica.close();
	}

}
