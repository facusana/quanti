package com.quanti.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

import com.quanti.model.User;

@Entity
@Table(name="topic_votation")
@Searchable
public class TopicVotation implements Serializable {
	private static final long serialVersionUID = 4402810707676715509L;
	
	private Long id;	
	private String topicName;
	private String question;
	private List<Answer> answers;
	//private Comment ownerComment;
	private User owner;
	private List<Comment> comments;
	private String tags;
	private Calendar date;
	private Category category;
	private Long views;
	private Long quantity;
	private List<Vote> votes;

	public TopicVotation(){
		
	}
	
	public TopicVotation(String name, String question){
		this.topicName = name;
		this.question = question;
		answers = new ArrayList<Answer>();
		comments = new ArrayList<Comment>();
		votes = new ArrayList<Vote>();
		views=0L;
		quantity=0L;
		//FIXME change TimeZone.
		date = new GregorianCalendar(TimeZone.getTimeZone("GMT-0"));
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SearchableId
	public Long getId() {
		return id;
	}

	@Column(name = "topic_name", nullable = false)
	@SearchableProperty
	public String getTopicName() {
		return topicName;
	}

	@Column(nullable = false)
	public Calendar getDate() {
		return date;
	}

	@Column(nullable=false)
	public Long getViews() {
		return views;
	}

	@Column(nullable = false)
	public Long getQuantity() {
		return quantity;
	}
	
	@Column(nullable = false)
	public String getQuestion() {
		return question;
	}

	@OneToMany (cascade={CascadeType.ALL},mappedBy="topicVotation", fetch = FetchType.LAZY)
	//@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<Answer> getAnswers() {
		return answers;
	}

	/*Aca no tengo que poner cascade ALL si quiero que cuando borre un evento no se bore el cliente*/
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="owner_id")
	public User getOwner() {
		return owner;
	}

	@OneToMany (mappedBy="topicVotation", fetch=FetchType.LAZY)
	public List<Comment> getComments() {
		return comments;
	}

	@Column
	public String getTags() {
		return tags;
	}

	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="category_id")
	public Category getCategory() {
		return category;
	}

	@OneToMany(mappedBy="topicVotation", fetch=FetchType.LAZY)
	public List<Vote> getVotes() {
		return votes;
	}

	public void setId(Long id) { this.id = id; }
	public void setTopicName(String topicName) { this.topicName = topicName; }
	public void setDate(Calendar date) { this.date = date; }
	public void setViews(Long views) { this.views = views; }
	public void setQuantity(Long quantity) { this.quantity = quantity; }
	public void setQuestion(String question) { this.question = question; }
	public void setAnswers(List<Answer> answers) { this.answers = answers; }
	public void setOwner(User owner) { this.owner = owner; }
	public void setComments(List<Comment> comments) { this.comments = comments; }
	public void setTags(String tags) { this.tags = tags; }
	public void setCategory(Category category) { this.category = category; }
	public void setVotes(List<Vote> votes) {this.votes = votes;}

	public void addAnswer(Answer answer){
		answer.setTopicVotation(this);
		this.getAnswers().add(answer);
	}
	
	public void addComment(Comment comment){
		comment.setTopicVotation(this);
		this.getComments().add(comment);
	}
	
	/**
	 * @return true if the votation is editable
	 */
	@Transient
	public Boolean isEditable(){
		return quantity.equals(0);
	}
	
	
	
}
