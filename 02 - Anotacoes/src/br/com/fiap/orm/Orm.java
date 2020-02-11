package br.com.fiap.orm;

import br.com.fiap.anotacao.Tabela;

public class Orm {
	public String gerarSql(Object o) {
		//Recuperar a anotacao @Tabela da classe 
		Tabela anotacao = o.getClass().getAnnotation(Tabela.class);
		//Retornar o SQL do select 
		return "SELECT * FROM " + anotacao.nome(); 
		
	}
}
