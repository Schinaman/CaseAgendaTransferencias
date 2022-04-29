package com.guigo.projeto.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Conta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private String conta;
	
	
	
//	@Setter(AccessLevel.NONE)
//	@OneToMany (mappedBy = "article_id") 
//	private Set<Tag> tags = new HashSet<Tag>();

}
