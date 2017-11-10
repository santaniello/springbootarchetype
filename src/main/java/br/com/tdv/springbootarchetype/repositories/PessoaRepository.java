package br.com.tdv.springbootarchetype.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tdv.springbootarchetype.models.Pessoa;



@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
