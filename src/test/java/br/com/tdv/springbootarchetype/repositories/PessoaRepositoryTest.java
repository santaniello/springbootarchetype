package br.com.tdv.springbootarchetype.repositories;

import java.util.Calendar;

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
import br.com.tdv.springbootarchetype.builders.TelefoneBuilder;
import br.com.tdv.springbootarchetype.confs.JpaConfigurationDev;
import br.com.tdv.springbootarchetype.helpers.RandomValueGeneratorHelper;
import br.com.tdv.springbootarchetype.models.Cnpj;
import br.com.tdv.springbootarchetype.models.Pessoa;
import br.com.tdv.springbootarchetype.models.PessoaCnpj;
import br.com.tdv.springbootarchetype.models.PessoaTipo;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@ContextConfiguration(classes = {JpaConfigurationDev.class, 
								 PessoaRepository.class, 
								 TelefoneRepository.class,
								 PessoaCnpjRepository.class,
								 CnpjRepository.class})
@Transactional // <== Não faz commit no banco, nao grava nenhum registro
public class PessoaRepositoryTest {

	@Autowired
	private PessoaRepository pessoaRepositorie; 
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private PessoaCnpjRepository pessoaCNPJRepository;
	
	@Autowired
	private CnpjRepository cnpjRepository; 
	
	@Test
	public void testCreatePessoa(){
		Pessoa pessoa = new PessoaBuilder()
				.withId(null)
				.withNome( RandomValueGeneratorHelper.anyString() )
				.withDataCadastro(Calendar.getInstance())
				.withTipo( PessoaTipo.CLIENTE )
				.build();
		pessoa = pessoaRepositorie.save( pessoa );
		Assert.assertTrue("id [Pessoa] deve ser maior que 0 depois de inserido", pessoa.getId() > 0);
	}
	
	@Test
	public void testCreatePessoaWithTelefones(){
		Pessoa pessoaCreate = new PessoaBuilder()
				.withId(null)
				.withNome( RandomValueGeneratorHelper.anyString() )
				.withDataCadastro(Calendar.getInstance())
				.withTipo( PessoaTipo.CLIENTE )
				.build();
		pessoaCreate = pessoaRepositorie.save( pessoaCreate );
		Assert.assertTrue("id [Pessoa] deve ser maior que 0 depois de inserido", pessoaCreate.getId() > 0);
		
		telefoneRepository.save( new TelefoneBuilder().withPessoa(pessoaCreate).build() );
		telefoneRepository.save( new TelefoneBuilder().withPessoa(pessoaCreate).build() );
		
		Pessoa pessoaRead = pessoaRepositorie.findOne( pessoaCreate.getId() );
		Assert.assertNotNull("Lista de Enderecos deve ser diferente de null", pessoaRead.getTelefones());
		Assert.assertTrue("Lista de Enderecos deve ser maior que 0 conforme create Pessoa", pessoaRead.getTelefones().size() > 0);
		Assert.assertTrue("Lista de Enderecos deve ser ter 2 itens conforme create Pessoa", pessoaRead.getTelefones().size() == 2);
	}
	
	@Test
	public void testCreatePessoaWithCNPJ(){
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
		
		Pessoa pessoaCnpjs = pessoaRepositorie.findOne(pessoa.getId());
		Assert.assertNotNull("Lista de Enderecos deve ser diferente de null", pessoaCnpjs.getCnpjs());
		Assert.assertTrue("Lista de [cnpjByPessoa] deve ser maior que 0 conforme create Pessoa", pessoaCnpjs.getCnpjs().size() > 0);
		Assert.assertTrue("Lista de [cnpjByPessoa] deve ser ter 1 itens conforme create Pessoa", pessoaCnpjs.getCnpjs().size() == 1);
	}
}
