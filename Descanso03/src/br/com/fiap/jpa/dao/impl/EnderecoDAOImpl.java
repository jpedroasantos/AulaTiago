package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.EnderecoDAO;
import br.com.fiap.jpa.entity.Endereco;

public class EnderecoDAOImpl extends GenericDAOImpl<Endereco, Integer> implements EnderecoDAO{

	public EnderecoDAOImpl(EntityManager em) {
		super(em);
	}
	
}
