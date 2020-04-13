package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.TransplanteDAO;
import br.com.fiap.jpa.entity.Transplante;

public class TransplanteDAOImpl extends GenericDAOImpl<Transplante, Integer> implements TransplanteDAO{

	public TransplanteDAOImpl(EntityManager em) {
		super(em);
	}

}
