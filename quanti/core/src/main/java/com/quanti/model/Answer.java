package com.quanti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer implements Serializable{
	private static final long serialVersionUID = -1263498564071256935L;
	
	private Long id;
	private String description;
	private String url;
	private Long quantity = 0L;
	private TopicVotation topicVotation;
	
	public Answer(){
		
	}
	
	public Answer(String description){
		this.description = description;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	@Column(nullable=false)
	public String getDescription() {
		return description;
	}
	
	@Column(nullable=true)
	public String getUrl() {
		return url;
	}
	
	@Column(nullable=false)
	public Long getQuantity() {
		return quantity;
	}
	
	@ManyToOne(cascade={CascadeType.REFRESH})
	@JoinColumn(name="topic_votation_id")
	public TopicVotation getTopicVotation() {
		return topicVotation;
	}
	
	public void setId(Long id) {this.id = id;}
	public void setDescription(String description) {this.description = description;}
	public void setUrl(String url) {this.url = url;}
	public void setQuantity(Long quantity) {this.quantity = quantity;}
	public void setTopicVotation(TopicVotation topicVotation) {this.topicVotation = topicVotation;}
	
	
}
