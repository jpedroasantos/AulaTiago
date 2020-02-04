package br.com.fiap.revisao.main;

import br.com.fiap.revisao.bean.Computador;
import br.com.fiap.revisao.bean.Embalagem;

public class TesteEnum {

	public static void main(String[] args) {
		//Criar um computador e atribuir a embalagem 
		Computador note = new Computador ("Positivo", 1500); 
		note.setEmbalagem(Embalagem.MADEIRA); 
		
		//Validar se a embalagem é de papelão 
		if (note.getEmbalagem() == Embalagem.ISOPOR) {
			System.out.println("Produto embalado em isopor");
		} else {
			System.out.println("Produto embalado em outro material");
		}

	}

}
