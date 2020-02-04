package br.com.fiap.revisao.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteData {

	public static void main(String[] args) {
		//Obter um objeto com a data atual
		Calendar hoje = Calendar.getInstance(); 
		//Obter uma data especifica 
		Calendar carnaval = new GregorianCalendar(2020, Calendar.FEBRUARY, 22);
		//Exibir a data formatada 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		System.out.println(sdf.format(hoje.getTime())); 
		System.out.println(sdf.format(carnaval.getTime()));

	}

}
