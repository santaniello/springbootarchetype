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

import br.com.tdv.springbootarchetype.builders.PessoaBuilder;
import br.com.tdv.springbootarchetype.builders.TelefoneBuilder;
import br.com.tdv.springbootarchetype.confs.JpaConfigurationDev;
import br.com.tdv.springbootarchetype.helpers.RandomValueGeneratorHelper;
import br.com.tdv.springbootarchetype.models.Pessoa;
import br.com.tdv.springbootarchetype.models.PessoaTipo;
import br.com.tdv.springbootarchetype.models.Telefone;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@ContextConfiguration(classes = {JpaConfigurationDev.class, TelefoneRepository.class, PessoaRepository.class})
@Transactional // <== Não faz commit no banco, nao grava nenhum registro
public class TelefoneRepositoryTest {

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private PessoaRepository pessoaRepositorie;
	
	@Test
	public void testCreateTelefone(){
		Pessoa pessoa = new PessoaBuilder()
				.withId(null)
				.withNome( RandomValueGeneratorHelper.anyString() )
				.withDataCadastro(Calendar.getInstance())
				.withTipo( PessoaTipo.CLIENTE )
				.build();
		pessoa = pessoaRepositorie.save( pessoa );
		System.out.println( pessoa );
		Assert.assertTrue("o id Pessoa deve ser maior que 0 depois de inserido", pessoa.getId() > 0);
		
		Telefone telefoneCreate = new TelefoneBuilder().build();
		telefoneCreate.setPessoa(pessoa);
		System.out.println( telefoneCreate );
		telefoneRepository.save( telefoneCreate );
		Assert.assertTrue("o id Telefone deve ser maior que 0 depois de inserido", telefoneCreate.getId() > 0);
	}
	
}
