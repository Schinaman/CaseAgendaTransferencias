package com.guigo.projeto;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
		
		
		
		//Criar conversor de taxa para porcentagem
		
		Conta conta1 = new Conta("123456");
		Conta conta2 = new Conta("123450");
		Conta conta3 = new Conta("123459");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//Order order1 = new Order(null, sdf.parse("30/09/2017 10:32"), client1, end1);
		AgendamentoTransferencia agendamento1 = new AgendamentoTransferencia(null, conta1, conta2, 200.00, sdf.parse("30/09/2022") );

		Date today = Calendar.getInstance().getTime();        
		String todayAsString = sdf.format(today);
		Date data1 = sdf.parse(todayAsString);
		
	    long diffInMillies = Math.abs(sdf.parse("30/09/2022").getTime() - sdf.parse("30/09/2022").getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		
		
		contaRepository.saveAll(Arrays.asList(conta1,conta2,conta3));
		agendamentoRepository.saveAll(Arrays.asList(agendamento1));
	}
	
	
	//"America/Sao_Paulo"

}
