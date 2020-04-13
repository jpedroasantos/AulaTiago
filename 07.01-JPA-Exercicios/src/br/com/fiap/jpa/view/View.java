package br.com.fiap.jpa.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.OrgaoDAO;
import br.com.fiap.jpa.dao.impl.OrgaoDAOImpl;
import br.com.fiap.jpa.entity.Doador;
import br.com.fiap.jpa.entity.Instituicao;
import br.com.fiap.jpa.entity.Orgao;
import br.com.fiap.jpa.entity.Paciente;
import br.com.fiap.jpa.entity.TipoSanguineo;
import br.com.fiap.jpa.entity.Transplante;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance(); 
		EntityManager em = fabrica.createEntityManager(); 
		
		OrgaoDAO dao = new OrgaoDAOImpl(em); 
		
		Orgao orgao = new Orgao("Coração", 4, true); 
		
		Doador doador = new Doador("Abrelincon", new GregorianCalendar(1990, Calendar.SEPTEMBER, 13), TipoSanguineo.A_POSITIVO, false, 79.5);
		
		Paciente paciente = new Paciente("João", new GregorianCalendar(2001, Calendar.AUGUST, 7), TipoSanguineo.A_POSITIVO, 68); 
		
		Transplante transplante = new Transplante(Calendar.getInstance(), orgao, paciente); 
		
		orgao.setDoador(doador); 
		orgao.setTransplante(transplante);
		
		Instituicao instituicao = new Instituicao("Unimed");
		List<Instituicao> lista = new ArrayList<Instituicao>(); 
		lista.add(instituicao); 
		
		paciente.setInstituicoes(lista);
		doador.setInstituicoes(lista);
		
		dao.cadastrar(orgao);
		try {
			dao.commit();
			System.out.println("Transplante cadastrado");
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}

}
