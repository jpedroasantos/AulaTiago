package br.com.fiap.jpa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.jpa.dao.ContaDAO;
import br.com.fiap.jpa.dao.impl.ContaDAOImpl;
import br.com.fiap.jpa.entity.Conta;
import br.com.fiap.jpa.entity.TipoConta;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;

class ContaDAOTest {
	
	static ContaDAO dao;
	Conta conta;
	
	@BeforeAll //metodo que será realizado antes de todos os metodos
	static void inicializar() {
		// Criar uma instancia da Conta, ContaDAO, EntityManager e EMF
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		dao = new ContaDAOImpl(em);
	}
	
	@BeforeEach //metodo chamado antes de cada teste
	void cadastrar() {
		conta = new Conta(222, TipoConta.CORRENTE, 100, Calendar.getInstance());

		// Cadastrar a conta
		dao.cadastrar(conta);
		try {
			dao.commit();
		} catch (CommitException e) {
			fail("falha no teste");
		}

	}

	@Test 
	@DisplayName("Atualização de conta com sucesso")
	void atualizaSucessoTest() {
		conta.setTipo(TipoConta.POUPANCA); 
		conta.setVl_saldo(999); 
		
		dao.atualizar(conta); 
		try {
			dao.commit();
		} catch(CommitException e) {
			fail("Falha no teste");
		} 
		
		try {
			//Pesquisa a conta 
			Conta busca = dao.pesquisar(conta.getCd_conta());
			//Valida se os dados foram alterados
			assertEquals(TipoConta.POUPANCA, busca.getTipo()); 
			assertEquals(999, busca.getVl_saldo());
		} catch (KeyNotFoundException e) {
			fail("Falha no teste");
		}
	}
	
	@Test
	@DisplayName("Deletar conta com sucesso")
	void deletarSucessoTest() {
		try {
			dao.deletar(conta.getCd_conta());
			dao.commit();
		} catch (KeyNotFoundException | CommitException e) {
			fail("Falha no teste");
		} 
		//Valida se realmente apagou a conta
		//se o metodo lançar exceção o teste funcionou
		assertThrows(KeyNotFoundException.class, () -> { dao.pesquisar(conta.getCd_conta()); });
	}
	
	@Test
	@DisplayName("Pesquisa de conta com sucesso")
	void buscaSucessoTest() { 
		try { 
			//pesquisa a conta cadastrada
			Conta busca = dao.pesquisar(conta.getCd_conta());
			//validar se retornou a conta 
			assertEquals(conta.getCd_conta(), busca.getCd_conta());
		} catch (KeyNotFoundException e) {
			fail("Falha no teste");
		}
		
		
	}

	@Test
	@DisplayName("Cadastro de conta com sucesso")
	void cadastroSucessoTest() {

		// Validar se foi cadastrado com sucesso
		assertNotEquals(0, conta.getCd_conta()); // valida se gerou codigo para outra conta

	}

}
