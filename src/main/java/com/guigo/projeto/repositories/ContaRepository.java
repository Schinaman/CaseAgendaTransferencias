package com.guigo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guigo.projeto.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, String>{

}
