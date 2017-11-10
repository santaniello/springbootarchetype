package br.com.tdv.springbootarchetype.builders;

import java.util.Calendar;

import br.com.tdv.springbootarchetype.helpers.RandomValueGeneratorHelper;
import br.com.tdv.springbootarchetype.models.Pessoa;
import br.com.tdv.springbootarchetype.models.PessoaTipo;



public class PessoaBuilder {

	private Pessoa pessoa = new Pessoa(
			null,
			RandomValueGeneratorHelper.anyString(),
			PessoaTipo.CLIENTE,
			Calendar.getInstance());
	
	public Pessoa build() {
		return this.pessoa;
	}
	
	public PessoaBuilder withId(Long id){
		this.pessoa.setId(id);
		return this;
	}
	
	public PessoaBuilder withNome(String nome){
		this.pessoa.setNome(nome);
		return this;
	}
	
	public PessoaBuilder withTipo(PessoaTipo tipo){
		this.pessoa.setTipo(tipo);
		return this;
	}
	
	public PessoaBuilder withDataCadastro(Calendar dataCadastro){
		this.pessoa.setDataCadastro(dataCadastro);
		return this;
	}
	

}
