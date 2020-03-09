package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.dao.impl.GenericDAOImpl;
import br.com.fiap.jpa.entity.Colaborador;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View2 {
	
	public static void main(String[] args) {
	EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance(); 
	EntityManager em = fabrica.createEntityManager(); 
	
	//Utilizando o DAO generico
	//Instanciando uma classe anonima
	GenericDAO<Colaborador, Integer> dao = new GenericDAOImpl<Colaborador, Integer>(em) {};
	
	Colaborador c = new Colaborador("José", "Programador Senior", Calendar.getInstance(), 15000.00f);
	
	try {
	dao.cadastrar(c);
	dao.commit(); 
	System.out.println("Colaborador cadastrado !");
	} catch (CommitException e) {
		System.out.println("Erro ao cadastrar");
	} 
	
	//fecha as paradas
	em.close();
	fabrica.close(); 
	
	}
}
