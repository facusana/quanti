package com.quanti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanti.dao.VoteDao;
import com.quanti.model.TopicVotation;
import com.quanti.model.User;
import com.quanti.model.Vote;
import com.quanti.model.VoteFilter;
import com.quanti.service.VoteManager;


@Service("voteManager")
public class VoteManagerImpl implements VoteManager{

	@Autowired
	private VoteDao voteDao;

	public void setVoteDao(VoteDao voteDao) {
		this.voteDao = voteDao;
	}

	public Vote save(Vote vote) {
		return voteDao.saveVote(vote);
	}

	public List<Vote> getVotesByUser(User user) {
		List<Vote> votes = voteDao.getVotesBy(user);
		return votes;
	}

	public List<Vote> findVotesByTopicAndVoteFilter(TopicVotation topicVotation, VoteFilter voteFilter) {
		List<Vote> votes = voteDao.getVotesBy(topicVotation, voteFilter);
		return votes;
	}
	
}
