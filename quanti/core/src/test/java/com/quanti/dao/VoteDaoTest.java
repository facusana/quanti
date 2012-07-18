package com.quanti.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quanti.model.Answer;
import com.quanti.model.TopicVotation;
import com.quanti.model.User;
import com.quanti.model.Vote;

public class VoteDaoTest extends BaseDaoTestCase{

	@Autowired
	private VoteDao dao;
	
	@Test
	public void testSaveVote(){
		TopicVotation topicVotation = new TopicVotation();
		topicVotation.setId(1L);

		User userInSession = new User();
		userInSession.setId(1L);
		
		Answer answer = new Answer();
		answer.setId(1L);
		
		Vote vote = new Vote();
		vote.setTopicVotation(topicVotation);
		vote.setVotant(userInSession);
		vote.setSelectedAnswer(answer);
		Vote voteSaved = dao.saveVote(vote);
		assertNotNull(voteSaved);
		
	}
	
	@Test
	public void testGetVotesByUser(){
		User user = new User();
		user.setId(1L);
		
		List<Vote> votes = dao.getVotesBy(user);
		assertNotNull(votes);
		
		for(Vote vote : votes){
			assertEquals(user.getId(),vote.getVotant().getId());
		}
		
	}
	
	@Test
	public void testFindVotesByTopicAndVoteFilter(){
		
	}
	
	
	
}
