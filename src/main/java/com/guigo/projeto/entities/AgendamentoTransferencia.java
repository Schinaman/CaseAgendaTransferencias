package com.guigo.projeto.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AgendamentoTransferencia implements Serializable{
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long agendamentoTransacaoId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="contaOrigem_id")
	@NonNull
private Conta contaOrigem;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="contaDestino_id")
	@NonNull
private Conta contaDestino;


	@NonNull
private Double valorTransferencia;


@NonNull
@JsonFormat(pattern="dd/MM/yyyy")
private Date dataTransferencia;

@NonNull
@JsonFormat(pattern="dd/MM/yyyy")
private Date dataAgendamento;

private Double taxaValor;
private Double taxaPercent;

//Variaveis das Taxas
static final Double taxaPercentA = 0.03;
static final Double taxaValorA = 12.00;
static final Double taxaPercentB;
static final Double taxaValorB = 12.00;
static final Double taxaPercentC1 = 0.082;
static final Double taxaValorC1;
static final Double taxaPercentC2 = 0.069;
static final Double taxaValorC2;
static final Double taxaPercentC3 = 0.047;
static final Double taxaValorC3;
static final Double taxaPercentC4 = 0.017;
static final Double taxaValorC4;



public AgendamentoTransferencia(Long agendamentoTransacaoId, @NonNull Conta contaOrigem,
		@NonNull Conta contaDestino, @NonNull Double valorTransferencia, Date dataAgendamento) throws ParseException {
	super();
	this.agendamentoTransacaoId = agendamentoTransacaoId;
	this.contaOrigem = contaOrigem;
	this.contaDestino = contaDestino;
	this.valorTransferencia = valorTransferencia;
	this.dataAgendamento = dataAgendamento;
	
	//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	this.dataTransferencia = new Date();//sdf.parse("30/09/2022");
}



private long calculaDiffDias(Date data1, Date data2) {
	
	if  (data1.getTime() > data2.getTime() && 
			data1.getDay()>data2.getDay()) {
				throw new IllegalArgumentException("Data de Agendamento menor que data atual");  
	}
    long diffInMillies = Math.abs(data2.getTime() - data1.getTime());
	long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	return diff;
}

private void calculaTaxa() {
	
//Agendamento precisa ser maior que Hoje
	long diff = calculaDiffDias(this.dataTransferencia, this.dataAgendamento);
	

//Taxa por prazo
	String tipoTaxa = null;
	if ((int)diff == 0) tipoTaxa = "taxaTipoA";
	if ((int)diff > 0 && (int)diff <= 10 ) tipoTaxa = "taxaTipoB";
	if ((int)diff > 10 && (int)diff <= 20 ) tipoTaxa = "taxaTipoC1";
	if ((int)diff > 20 && (int)diff <= 30 ) tipoTaxa = "taxaTipoC2";
	if ((int)diff > 30 && (int)diff <= 40 ) tipoTaxa = "taxaTipoC3";
	if ((int)diff > 40) tipoTaxa = "taxaTipoC4";
	
	switch (tipoTaxa) {
	  case "taxaTipoA":
	    this.taxaPercent = taxaPercentA;
	    this.taxaValor =  this.getValorTransferencia() * taxaPercentA;
	    break;
	  case "taxaTipoB":
		this.taxaPercent = taxaPercentB;
		this.taxaValor =  this.getValorTransferencia() * taxaPercentB;
	    break;
	  case "taxaTipoC1":
		this.taxaPercent = taxaPercentC1;
		this.taxaValor =  this.getValorTransferencia() * taxaPercentC1;
		break;
	  case "taxaTipoC2":
		this.taxaPercent = taxaPercentC2;
		this.taxaValor =  this.getValorTransferencia() * taxaPercentC2;
		break;
	  case "taxaTipoC3":
		this.taxaPercent = taxaPercentC3;
		this.taxaValor =  this.getValorTransferencia() * taxaPercentC3;
	    break;
	  case "taxaTipoC4":
		this.taxaPercent = taxaPercentC4;
		this.taxaValor =  this.getValorTransferencia() * taxaPercentC4;
		break;	
	}

//Validação para operação tipo D (prazos)
	if (tipoTaxa == "taxaTipoA" && this.valorTransferencia > 1.000) throw new IllegalArgumentException("Para este prazo o valor transferido precisa ser menor que 1.000");
	if (tipoTaxa == "taxaTipoB" && !(this.valorTransferencia >= 1.001 || this.valorTransferencia <= 2.000)) throw new IllegalArgumentException("Para este prazo valor transferido precisa ser entre 1.001 e 2000");
	if (tipoTaxa == "taxaTipoC" && this.valorTransferencia <= 2.000) throw new IllegalArgumentException("Para este prazo valor transferido precisa ser maior que 2000");
	
}

}