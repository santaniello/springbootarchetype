package br.com.tdv.springbootarchetype.builders;

import br.com.tdv.springbootarchetype.helpers.RandomValueGeneratorHelper;
import br.com.tdv.springbootarchetype.models.Cnpj;

public class CnpjBuilder {

	private Cnpj cnpj = new Cnpj(null, RandomValueGeneratorHelper.anyIntegerStr());
	
	public Cnpj build(){
		return this.cnpj;
	}
	
	public CnpjBuilder withId(Long id){
		this.cnpj.setId(id);
		return this;
	}
	
	public CnpjBuilder withNumero(String numero){
		this.cnpj.setNumero(numero);
		return this;
	}
	
}
