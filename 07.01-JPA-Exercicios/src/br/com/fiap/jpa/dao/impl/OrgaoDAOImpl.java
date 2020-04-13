package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.OrgaoDAO;
import br.com.fiap.jpa.entity.Orgao;

public class OrgaoDAOImpl extends GenericDAOImpl<Orgao, Integer> implements OrgaoDAO{

	public OrgaoDAOImpl(EntityManager em) {
		super(em);
	}
	
}
