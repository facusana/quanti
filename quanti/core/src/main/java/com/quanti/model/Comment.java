package com.quanti.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

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
@Table(name="comment")
public class Comment implements Serializable{
	private static final long serialVersionUID = 6123781718846924084L;
	
	private Long id;
	private User owner;
	private String comment;
	private Calendar date;
	private TopicVotation topicVotation;

	public Comment(){
		
	}
	
	public Comment(String comment){
		this.comment = comment;
		//FIXME change TimeZone.
		date = new GregorianCalendar(TimeZone.getTimeZone("GMT-0"));
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="owner_id")
	public User getOwner() {
		return owner;
	}
	
	@Column(nullable=false)
	public String getComment() {
		return comment;
	}
	
	@Column(nullable=false)
	public Calendar getDate() {
		return date;
	}
	
	@ManyToOne(cascade={CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="topic_votation_id")
	public TopicVotation getTopicVotation() {
		return topicVotation;
	}

	public void setId(Long id) {this.id = id;}
	public void setOwner(User owner) {this.owner = owner;}
	public void setComment(String comment) {this.comment = comment;}
	public void setDate(Calendar date) {this.date = date;}
	public void setTopicVotation(TopicVotation topicVotation) {this.topicVotation = topicVotation;}
	
	
	
}
