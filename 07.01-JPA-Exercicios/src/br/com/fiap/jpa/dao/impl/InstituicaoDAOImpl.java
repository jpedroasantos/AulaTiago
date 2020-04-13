package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.InstituicaoDAO;
import br.com.fiap.jpa.entity.Instituicao;

public class InstituicaoDAOImpl extends GenericDAOImpl<Instituicao, Integer> implements InstituicaoDAO{

	public InstituicaoDAOImpl(EntityManager em) {
		super(em);
	}

}
