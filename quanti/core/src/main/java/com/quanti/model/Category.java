package com.quanti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.compass.annotations.SearchableId;

@Entity
@Table(name="category")
public class Category implements Serializable{
	private static final long serialVersionUID = -3255908181758444571L;
	
	private Long id;
	private String name;
	
	@Id
	public Long getId() {
		return id;
	}
	
	@Column(name="description", nullable=false)
	public String getName() {
		return name;
	}
	
	public void setId(Long id) { this.id = id; }
	public void setName(String name) { this.name = name;}
	
	
}