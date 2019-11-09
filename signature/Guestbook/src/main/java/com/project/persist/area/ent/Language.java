package com.project.persist.area.ent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Language {

	private Integer id;
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@SequenceGenerator(name = "pais_sequence", sequenceName = "pais_sequence")
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "pais_sequence")
	//@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 30, updatable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



}
