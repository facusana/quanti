package com.quanti.dao;

import java.util.List;

import com.quanti.model.TopicVotation;
import com.quanti.model.User;
import com.quanti.model.Vote;
import com.quanti.model.VoteFilter;

public interface VoteDao extends GenericDao<Vote, Long>{

	public Vote saveVote(Vote vote);
	
	public List<Vote> getVotesBy(User user);
	
	public List<Vote> getVotesBy(TopicVotation topicVotation, VoteFilter filter);
}
