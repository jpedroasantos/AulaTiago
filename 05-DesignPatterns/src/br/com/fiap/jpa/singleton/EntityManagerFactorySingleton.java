package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * Classe que gerencia o objeto da Fabrica de EntityManager, 
 * permitindo somente uma �nica inst�ncia da f�brica 
 */
public class EntityManagerFactorySingleton {
	
	//atributo est�tico que armazena uma unica instancia 
	private static EntityManagerFactory fabrica;
	
	//construtor privado -> n�o � possivel instanciar a classe
	private EntityManagerFactorySingleton() {}
	
	//metodo estatico que retorna uma unica instancia
	public static EntityManagerFactory getInstance() {
		if (fabrica == null) {
		fabrica = Persistence.createEntityManagerFactory("oracle"); 
		}
		return fabrica; 
	}
}
