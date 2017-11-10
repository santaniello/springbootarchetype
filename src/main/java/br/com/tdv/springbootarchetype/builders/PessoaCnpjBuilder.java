package br.com.tdv.springbootarchetype.builders;

import java.util.Calendar;

import br.com.tdv.springbootarchetype.models.Cnpj;
import br.com.tdv.springbootarchetype.models.Pessoa;
import br.com.tdv.springbootarchetype.models.PessoaCnpj;


public class PessoaCnpjBuilder {

	private PessoaCnpj pessoaCnpj = new PessoaCnpj(null, new PessoaBuilder().build(), new CnpjBuilder().build(), Calendar.getInstance());
	
	public PessoaCnpj build(){
		return this.pessoaCnpj;
	}
	
	public PessoaCnpjBuilder withId(Long id){
		this.pessoaCnpj.setId(id);
		return this;
	}
	
	public PessoaCnpjBuilder withPessoa(Pessoa pessoa){
		this.pessoaCnpj.setPessoa(pessoa);
		return this;
	}
	
	public PessoaCnpjBuilder withCnpj(Cnpj cnpj){
		this.pessoaCnpj.setCnpj(cnpj);
		return this;
	}
	
	public PessoaCnpjBuilder withDataCadastro(Calendar dataCadastro){
		this.pessoaCnpj.setDataCadastro(dataCadastro);
		return this;
	}
}
