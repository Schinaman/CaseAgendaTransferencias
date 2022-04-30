package com.guigo.projeto.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guigo.projeto.entities.Conta;
import com.guigo.projeto.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaResource {
	
	@Autowired
	private ContaService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> list = service.findAll();
		//List<Conta> list = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Conta obj) { //@Valid intercepta a bean Validation que vem do DTO; aula 39
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getConta()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	

	
	
}