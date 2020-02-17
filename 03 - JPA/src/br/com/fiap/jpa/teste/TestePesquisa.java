package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Produto;

public class TestePesquisa {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle"); 
		EntityManager em = fabrica.createEntityManager();  
		
		//Pesquisar o produto de c�digo
		Produto prod = em.find(Produto.class, 2); 
		
		System.out.println("Nome: " + prod.getNome()); 
		System.out.println("Categoria: " + prod.getCategoria()); 
		System.out.println("Valor Liquido: " + prod.getValorLiquido());
		
		//Alterar o  valor do produto 
		
		prod.setValor(1500); 
		
		em.getTransaction().begin(); //Come�a a transa��o 
		em.getTransaction().commit(); 
		
		
		em.close(); 
		fabrica.close();
		
	}

}
