package com.guigo.projeto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guigo.projeto.entities.AgendamentoTransferencia;
import com.guigo.projeto.entities.Conta;
import com.guigo.projeto.repositories.AgendamentoTransferenciaRepository;
import com.guigo.projeto.repositories.ContaRepository;

@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}
	
	@Autowired
	private AgendamentoTransferenciaRepository agendamentoRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Conta conta1 = new Conta("123456");
		Conta conta2 = new Conta("123450");
		Conta conta3 = new Conta("123459");
		
		AgendamentoTransferencia agend1 = new AgendamentoTransferencia(null, conta1, conta2, 200.00, 5.0, Instant.now(), null  );
		Date.from(LocalDate.now());
		
		
		//Criar conversor de taxa para porcentagem
	

	}

}
