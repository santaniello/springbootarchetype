package br.com.tdv.springbootarchetype.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tdv.springbootarchetype.models.Pessoa;
import br.com.tdv.springbootarchetype.models.PessoaCnpj;


@Repository
public interface PessoaCnpjRepository extends CrudRepository<PessoaCnpj, Long> {

	List<PessoaCnpj> findByPessoa(Pessoa pessoa);
	
}
