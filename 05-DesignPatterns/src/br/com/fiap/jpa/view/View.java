package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ContaDAO;
import br.com.fiap.jpa.dao.impl.ContaDAOImpl;
import br.com.fiap.jpa.entity.Conta;
import br.com.fiap.jpa.entity.TipoConta;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Obter uma instancia da fabrica
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = fabrica.createEntityManager(); 
		
		//Instanciar o DAO
		ContaDAO dao = new ContaDAOImpl(em); 
		
		//Cadastrar uma conta
		Conta conta = new Conta(2, TipoConta.CORRENTE, 1200, Calendar.getInstance()); 
		
		try {
			dao.cadastrar(conta); 
			dao.commit(); 
			System.out.println("Conta cadastrada!");
		} catch (CommitException e) {
			System.out.println("Erro ao cadastrar a conta");
		}
		
		
		//feche as paradas 
		em.close();
		fabrica.close();

	}

}
