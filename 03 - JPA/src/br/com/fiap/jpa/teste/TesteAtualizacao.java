package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Categoria;
import br.com.fiap.jpa.entity.Produto;

public class TesteAtualizacao {

	public static void main(String[] args) {
		//Criar EntityManager 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle"); 
		EntityManager em = fabrica.createEntityManager(); 
		
		//Instanciar um produto com id que existe no banco 
		Produto prod = new Produto("SamSung", 2000, 1500, null, null, Categoria.ELETRONICO); 
		prod.setId(1);
		
		//Realizar o merge (passar o produto para o EM gerenciar) 
		em.merge(prod); 
		
		//commit 
		em.getTransaction().begin(); 
		em.getTransaction().commit();
		
		//fechar as paradas 
		em.close(); 
		fabrica.close();

	}

}
