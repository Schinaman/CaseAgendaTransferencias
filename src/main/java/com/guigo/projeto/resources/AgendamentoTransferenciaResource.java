package com.guigo.projeto.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guigo.projeto.entities.AgendamentoTransferencia;
import com.guigo.projeto.services.AgendamentoTransferenciaService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoTransferenciaResource {
	
	@Autowired
	private AgendamentoTransferenciaService service;

	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody AgendamentoTransferencia obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	

	
	
}