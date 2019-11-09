package com.project.persist.area.ent;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country implements Serializable{
    private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String code;

	@Id
	@GeneratedValue()
	//@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "code", length = 60)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
