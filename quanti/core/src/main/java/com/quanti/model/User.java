package com.quanti.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = -8271248473937083986L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private Calendar birthdate;
	private Boolean deleted;
	private Boolean working;
	//private Location location;
	
	private List<Comment> comments;
	private List<TopicVotation> ownerTopicVotations;
	private List<Vote> votes;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	@Column(nullable=false)
	public String getFirstName() {
		return firstName;
	}
	
	@Column(nullable=false)
	public String getLastName() {
		return lastName;
	}
	
	@Column(nullable=false)
	public String getUsername() {
		return username;
	}
	
	@Column(nullable=false)
	public String getEmail() {
		return email;
	}
	
	@Column(nullable=false)
	public Calendar getBirthdate() {
		return birthdate;
	}
	
	@Column(nullable=false)
	public Boolean getDeleted() {
		return deleted;
	}
	
	@Column
	public Boolean getWorking() {
		return working;
	}

	@OneToMany (mappedBy="owner", fetch = FetchType.LAZY)
	public List<Comment> getComments() {
		return comments;
	}

	@OneToMany (mappedBy="owner", fetch = FetchType.LAZY)
	public List<TopicVotation> getOwnerTopicVotations() {
		return ownerTopicVotations;
	}

	@OneToMany (mappedBy="votant", fetch = FetchType.LAZY)
	public List<Vote> getVotes() {
		return votes;
	}

	public void setId(Long id) {this.id = id;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setUsername(String username) {this.username = username;}
	public void setEmail(String email) {this.email = email;}
	public void setBirthdate(Calendar birthdate) {this.birthdate = birthdate;}
	public void setDeleted(Boolean deleted) {this.deleted = deleted;}
	public void setWorking(Boolean working) {this.working = working;}
	public void setComments(List<Comment> comments) {this.comments = comments;}
	public void setOwnerTopicVotations(List<TopicVotation> ownerTopicVotations) {this.ownerTopicVotations = ownerTopicVotations;}
	public void setVotes(List<Vote> votes) {this.votes = votes;}	
	
}
