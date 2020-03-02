package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EnderecoInexistenteException;

public class EnderecoDAOImpl implements EnderecoDAO{
	
	private EntityManager em;
	
	//Construtor que recebe o EntityManager
	public EnderecoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Override
	public void cadastrar(Endereco end) {
		em.persist(end); 
	}

	@Override
	public Endereco pesquisar(int codigo) throws EnderecoInexistenteException {
		Endereco end = em.find(Endereco.class, codigo);
		if(end == null) {
			throw new EnderecoInexistenteException();
		} 
		return end;
	}

	@Override
	public void atualizar(Endereco end) throws EnderecoInexistenteException {
		pesquisar(end.getCodigo()); 
		em.merge(end);
	}

	@Override
	public void deletar(int codigo) throws EnderecoInexistenteException{
		Endereco end = pesquisar(codigo); 
		em.remove(end);
	} 
	
	public void commit() throws CommitException { 
		try {
			em.getTransaction().begin(); 
			em.getTransaction().commit(); 
		} catch(Exception e) {
			e.printStackTrace(); 
			em.getTransaction().rollback(); 
			throw new CommitException(e.getMessage());
		}
	}

}
