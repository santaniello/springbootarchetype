package br.com.tdv.springbootarchetype.repositories;

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
import br.com.tdv.springbootarchetype.confs.JpaConfigurationDev;
import br.com.tdv.springbootarchetype.models.Cnpj;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@ContextConfiguration(classes = {JpaConfigurationDev.class, CnpjRepository.class})
@Transactional // <== Não faz commit no banco, nao grava nenhum registro
public class CnpjRepositoryTest {

	@Autowired
	private CnpjRepository cnpjRepository;
	
	@Test
	public void testCreateTelefone(){
		Cnpj cnpj = new CnpjBuilder().build();
		cnpjRepository.save( cnpj );
		Assert.assertTrue("o id [CNPJ] deve ser maior que 0 depois de inserido", cnpj.getId() > 0);
	}
	
}
