package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.DoadorDAO;
import br.com.fiap.jpa.entity.Doador;

public class DoadorDAOImpl extends GenericDAOImpl<Doador, Integer> implements DoadorDAO{

	public DoadorDAOImpl(EntityManager em) {
		super(em);
	}

}
