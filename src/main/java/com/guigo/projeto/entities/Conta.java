package com.guigo.projeto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@NonNull
	@Column(unique=true)
	private String conta;
	
	@OneToMany (mappedBy = "contaOrigem")
	private List<AgendamentoTransferencia> transferenciasContaOrigem = new ArrayList<AgendamentoTransferencia>();
	
	@OneToMany (mappedBy = "contaDestino")
	private List<AgendamentoTransferencia> transferenciasContaDestino = new ArrayList<AgendamentoTransferencia>();
	

}
