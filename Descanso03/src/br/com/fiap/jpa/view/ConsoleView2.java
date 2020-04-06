package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.LoginDAO;
import br.com.fiap.jpa.dao.impl.LoginDAOImpl;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.entity.Login;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.entity.TipoEndereco;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ConsoleView2 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um LoginDAO();
		LoginDAO dao = new LoginDAOImpl(em);
		
		//Instanciar um Cliente
		Cliente cli = new Cliente("Joao", "Pedro", Calendar.getInstance());
		
		//Instanciar um login
		Login log = new Login("123456", "jpads1", cli); 
		
		//Adicionar 3 pedidos no cliente
		cli.addPedidos(new Pedido(100, 2, Calendar.getInstance()));
		cli.addPedidos(new Pedido(3000, 1, Calendar.getInstance()));
		cli.addPedidos(new Pedido(10, 5, Calendar.getInstance()));
		
		//Criar lista de endereco e instanciar 2 enderecos
		List<Endereco> end = new ArrayList<Endereco>(); 
		end.add(new Endereco("Tomas de Souza", TipoEndereco.AVENIDA, 433));
		end.add(new Endereco("José Churriguerra", TipoEndereco.RUA, 95)); 
		end.add(new Endereco("Estrada de itapecerica", TipoEndereco.ESTRADA, 100));
		
		cli.setEnderecos(end);
		
		//Cadastrar o login 
		dao.cadastrar(log);
		try {
			dao.commit();
			System.out.println("Login cadastrado");
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close(); 
		fabrica.close();
	}

}
