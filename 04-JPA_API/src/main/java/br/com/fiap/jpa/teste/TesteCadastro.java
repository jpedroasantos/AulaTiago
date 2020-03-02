package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.EnderecoDAOImpl;
import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.entity.Tipo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EnderecoInexistenteException;

public class TesteCadastro {

	public static void main(String[] args) {
		Endereco end;
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle"); 
		EntityManager em = fabrica.createEntityManager(); 
		
		end = new Endereco("05857180", "D", Tipo.RUA); 
		
		EnderecoDAOImpl dao = new EnderecoDAOImpl(em); 
		
		dao.cadastrar(end);  
		try {
			dao.commit(); 
			System.out.println("Cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		} 
		
		//Pesquisar o endereço cadastrado 
		try {
			Endereco busca = dao.pesquisar(end.getCodigo()); 
			System.out.println(busca.getLogradouro());
		} catch (EnderecoInexistenteException e){
			e.printStackTrace();
		}
		
		//Atualizar o endereco 
		try {
			end.setLogradouro("Av. Paulista"); 
			dao.atualizar(end); 
			dao.commit();
			System.out.println("Atualizado!");
		} catch (EnderecoInexistenteException | CommitException e){
			e.printStackTrace();
		} 
		
		//Remover o endereco 
		try {
			dao.deletar(end.getCodigo()); 
			dao.commit(); 
			System.out.println("Removido!");
		} catch (EnderecoInexistenteException | CommitException e){
			e.printStackTrace();
		}
		
		em.close(); 
		fabrica.close();

	}

}
