package br.com.tdv.springbootarchetype.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tdv.springbootarchetype.models.Cnpj;
import br.com.tdv.springbootarchetype.repositories.CnpjRepository;

@Service
public class CnpjService {

	@Autowired
	private CnpjRepository cnpjRepository;
	
	public List<Cnpj> findAll(){
		return cnpjRepository.findAll();
	}
	
	
}
