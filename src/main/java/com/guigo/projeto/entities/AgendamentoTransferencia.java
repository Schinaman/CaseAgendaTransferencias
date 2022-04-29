package com.guigo.projeto.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class AgendamentoTransferencia implements Serializable{
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long agendamentoTransacaoId;
private Conta contaOrigem;
private Conta contaDestino;
private Double valorTransferencia;
private Double taxa;
private Instant dataTransferencia;
private Instant dataAgendamento;


}