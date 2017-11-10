package br.com.tdv.springbootarchetype.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tdv.springbootarchetype.models.Telefone;



@Repository
public interface TelefoneRepository extends CrudRepository<Telefone, Long> {

}
