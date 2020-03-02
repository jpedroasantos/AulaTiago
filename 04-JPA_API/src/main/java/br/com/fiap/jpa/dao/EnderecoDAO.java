package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EnderecoInexistenteException;

public interface EnderecoDAO {
	
	void cadastrar(Endereco end); 
	
	Endereco pesquisar(int codigo) throws EnderecoInexistenteException; 
	
	void atualizar(Endereco end) throws EnderecoInexistenteException; 
	
	void deletar(int codigo) throws EnderecoInexistenteException;

	void commit() throws CommitException; 
	
}
