package br.com.tdv.springbootarchetype.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tdv.springbootarchetype.models.Cnpj;


@Repository
public interface CnpjRepository extends CrudRepository<Cnpj, Long> {
	
	public List<Cnpj> findAll();

}
