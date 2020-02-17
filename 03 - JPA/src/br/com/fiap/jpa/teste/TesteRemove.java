package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Produto;

public class TesteRemove {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle"); 
		EntityManager em = fabrica.createEntityManager(); 
		
		Produto prod = em.find(Produto.class, 1); 
		
		em.remove(prod); 
		
		em.getTransaction().begin(); 
		em.getTransaction().commit();
		
		em.close(); 
		fabrica.close();
	}

}
