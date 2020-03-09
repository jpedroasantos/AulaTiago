package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * Classe que gerencia o objeto da Fabrica de EntityManager, 
 * permitindo somente uma única instância da fábrica 
 */
public class EntityManagerFactorySingleton {
	
	//atributo estático que armazena uma unica instancia 
	private static EntityManagerFactory fabrica;
	
	//construtor privado -> não é possivel instanciar a classe
	private EntityManagerFactorySingleton() {}
	
	//metodo estatico que retorna uma unica instancia
	public static EntityManagerFactory getInstance() {
		if (fabrica == null) {
		fabrica = Persistence.createEntityManagerFactory("oracle"); 
		}
		return fabrica; 
	}
}
