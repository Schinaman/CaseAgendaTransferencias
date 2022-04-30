package com.guigo.projeto.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


private Double taxa;
//private String stringDataAgendamento;



public AgendamentoTransferencia(Long agendamentoTransacaoId, @NonNull Conta contaOrigem,
		@NonNull Conta contaDestino, @NonNull Double valorTransferencia, Date dataAgendamento) throws ParseException {
	super();
	this.agendamentoTransacaoId = agendamentoTransacaoId;
	this.contaOrigem = contaOrigem;
	this.contaDestino = contaDestino;
	this.valorTransferencia = valorTransferencia;
	this.dataAgendamento = dataAgendamento;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	this.dataTransferencia = new Date();//sdf.parse("30/09/2022");
}






}