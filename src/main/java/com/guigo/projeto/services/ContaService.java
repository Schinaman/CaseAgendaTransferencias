package com.guigo.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigo.projeto.entities.Conta;
import com.guigo.projeto.repositories.ContaRepository;
import com.guigo.projeto.services.exceptions.ObjectNotFoundException;

@Service
public class ContaService {
	@Autowired
	private ContaRepository repo; 
	
	public List<Conta> findAll(){
		return repo.findAll();
	}
	
	public Conta findById(String conta) {
		Optional<Conta> obj = repo.findById(conta);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Conta: " + conta + ", Tipo: " + Conta.class.getName()));
	}

	public Conta insert(Conta obj) {
		return repo.save(obj);
	}
	

}
