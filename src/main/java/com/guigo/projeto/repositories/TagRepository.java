package com.guigo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guigo.projeto.entities.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

}
