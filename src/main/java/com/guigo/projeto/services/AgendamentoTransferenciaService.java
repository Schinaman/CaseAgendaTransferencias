package com.guigo.projeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigo.projeto.entities.AgendamentoTransferencia;
import com.guigo.projeto.repositories.AgendamentoTransferenciaRepository;

@Service
public class AgendamentoTransferenciaService {
	@Autowired
	private AgendamentoTransferenciaRepository repo; 
	

	public AgendamentoTransferencia insert(AgendamentoTransferencia obj) {
		return repo.save(obj);
	}
	

}
