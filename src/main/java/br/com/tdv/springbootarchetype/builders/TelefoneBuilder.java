package br.com.tdv.springbootarchetype.builders;

import br.com.tdv.springbootarchetype.models.Pessoa;
import br.com.tdv.springbootarchetype.models.Telefone;

public class TelefoneBuilder {
	private Telefone telefone = new Telefone(null, "11", String.valueOf(Math.random()), new PessoaBuilder().build());
	
	public TelefoneBuilder withId(Long id){
		this.telefone.setId(id);
		return this;
	}
	
	public TelefoneBuilder withDdd(String ddd){
		this.telefone.setDdd(ddd);
		return this;
	}
	
	public TelefoneBuilder withNumero(String numero){
		this.telefone.setNumero(numero);
		return this;
	}
	
	public TelefoneBuilder withPessoa(Pessoa pessoa){
		this.telefone.setPessoa(pessoa);
		return this;
	}
	
	public Telefone build(){
		return telefone;
	}
	
}
