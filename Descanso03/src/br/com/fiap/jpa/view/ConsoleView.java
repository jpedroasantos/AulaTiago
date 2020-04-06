package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Login;
import br.com.fiap.jpa.entity.Pedido;

public class ConsoleView {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle"); 
		EntityManager em = fabrica.createEntityManager(); 
		
		//Cadastrar login e cliente 
		Cliente cliente = new Cliente("Thiago", "Yamamoto", new GregorianCalendar(1990, Calendar.APRIL, 10));
		
		Login login = new Login("123456", "thyama", cliente); 
		
		cliente.addPedidos(new Pedido(10, 100, Calendar.getInstance()));
		cliente.addPedidos(new Pedido(20, 200, Calendar.getInstance()));
		cliente.addPedidos(new Pedido(30, 10, Calendar.getInstance()));
		
		//em.persist(cliente); 
		em.persist(login); 
		
		//Login busca = em.find(Login.class, 1);
		//em.remove(em.find(Login.class, 1));
		
		em.getTransaction().begin(); 
		em.getTransaction().commit(); 
		
		em.close(); 
		fabrica.close();
	}
}
