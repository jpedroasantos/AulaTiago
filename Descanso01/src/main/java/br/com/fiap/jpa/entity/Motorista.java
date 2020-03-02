package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table(name = "T_MOTORISTA") 
public class Motorista {
	
	private int nr_carteira; 
	
	private String nm_motorista; 
	
	private Calendar dt_nascimento; 
	
	
}
