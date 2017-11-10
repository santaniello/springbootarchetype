package br.com.tdv.springbootarchetype.repositories;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.tdv.springbootarchetype.builders.CnpjBuilder;
import br.com.tdv.springbootarchetype.builders.PessoaBuilder;
import br.com.tdv.springbootarchetype.builders.PessoaCnpjBuilder;
import br.com.tdv.springbootarchetype.confs.JpaConfigurationDev;
import br.com.tdv.springbootarchetype.models.Cnpj;
import br.com.tdv.springbootarchetype.models.Pessoa;
import br.com.tdv.springbootarchetype.models.PessoaCnpj;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@ContextConfiguration(classes = {JpaConfigurationDev.class, PessoaRepository.class,PessoaCnpjRepository.class,CnpjRepository.class  })
@Transactional // <== Não faz commit no banco, nao grava nenhum registro
public class PessoaCnpjRepositoryTest {

	@Autowired
	private PessoaRepository pessoaRepositorie; 
	
	@Autowired
	private PessoaCnpjRepository pessoaCNPJRepository;
	
	@Autowired
	private CnpjRepository cnpjRepository; 
	
	@Test
	public void testCreatePessoaCNPJ(){
		Pessoa pessoa = pessoaRepositorie.save( new PessoaBuilder().build() );
		Assert.assertTrue("id [Pessoa] deve ser maior que 0 depois de inserido", pessoa.getId() > 0);
		
		Cnpj cnpj = cnpjRepository.save( new CnpjBuilder().build() );
		Assert.assertTrue("id [CNPJ] deve ser maior que 0 depois de inserido", cnpj.getId() > 0);
		
		PessoaCnpj pessoaCNPJ = new PessoaCnpjBuilder()
				.withPessoa(pessoa)
				.withCnpj(cnpj)
				.build();
		pessoaCNPJRepository.save( pessoaCNPJ );
		Assert.assertTrue("id [PessoaCNPJ] deve ser maior que 0 depois de inserido", pessoaCNPJ.getId() > 0);
		
		List<PessoaCnpj> findByPessoa = pessoaCNPJRepository.findByPessoa(pessoa);
		Assert.assertNotNull("Lista de Enderecos deve ser diferente de null", findByPessoa);
		Assert.assertTrue("Lista de [cnpjByPessoa] deve ser maior que 0 conforme create Pessoa", findByPessoa.size() > 0);
		Assert.assertTrue("Lista de [cnpjByPessoa] deve ser ter 1 itens conforme create Pessoa", findByPessoa.size() == 1);
	}
	
}
