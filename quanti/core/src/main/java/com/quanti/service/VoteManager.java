package com.quanti.service;

import java.util.List;

import com.quanti.model.TopicVotation;
import com.quanti.model.User;
import com.quanti.model.Vote;
import com.quanti.model.VoteFilter;


public interface VoteManager {

	public Vote save(Vote vote);
	
	public List<Vote> getVotesByUser(User user);
	
	public List<Vote> findVotesByTopicAndVoteFilter(TopicVotation topicVotation, VoteFilter voteFilter);
	
}
