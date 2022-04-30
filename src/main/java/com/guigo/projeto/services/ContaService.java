package com.guigo.projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigo.projeto.entities.Conta;
import com.guigo.projeto.repositories.ContaRepository;

@Service
public class ContaService {
	@Autowired
	private ContaRepository repo; 
	
	public List<Conta> findAll(){
		return repo.findAll();
	}

	public Conta insert(Conta obj) {
		return repo.save(obj);
	}
	

}
