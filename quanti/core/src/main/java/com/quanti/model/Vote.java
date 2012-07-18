package com.quanti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quanti.model.User;

@Entity
@Table(name="vote")
public class Vote implements Serializable{
	private static final long serialVersionUID = -1903032781786507180L;
	
	private Long id;
	private User votant;
	private TopicVotation topicVotation;
	private Answer selectedAnswer;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	@ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	public User getVotant() {
		return votant;
	}
	
	@ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="topic_votation_id")
	public TopicVotation getTopicVotation() {
		return topicVotation;
	}
	
	@ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinColumn(name="answer_id")
	public Answer getSelectedAnswer() {
		return selectedAnswer;
	}
	
	public void setId(Long id) {this.id = id;}
	public void setVotant(User votant) {this.votant = votant;}
	public void setTopicVotation(TopicVotation topicVotation) {this.topicVotation = topicVotation;}
	public void setSelectedAnswer(Answer selectedAnswer) {this.selectedAnswer = selectedAnswer;}
	
}
