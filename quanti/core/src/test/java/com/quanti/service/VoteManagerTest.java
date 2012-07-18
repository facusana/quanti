package com.quanti.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quanti.model.Answer;
import com.quanti.model.TopicVotation;
import com.quanti.model.User;
import com.quanti.model.Vote;
import com.quanti.model.VoteFilter;
import static org.junit.Assert.*;

public class VoteManagerTest extends BaseManagerTestCase {

	private Log log = LogFactory.getLog(VoteManagerTest.class);
	
	@Autowired
	private VoteManager voteManager;
	
	@Test
	public void testSave(){
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
		Vote voteSaved = voteManager.save(vote);
		assertNotNull(voteSaved);
	}
	
	@Test
	public void testGetVotesByUser(){
		User user = new User();
		user.setId(1L);
		
		List<Vote> votes = voteManager.getVotesByUser(user);
		assertNotNull(votes);
		
		for(Vote vote : votes){
			assertEquals(user.getId(),vote.getVotant().getId());
		}
	}
	
	@Test
	public void testFindVotesByTopicAndVoteFilter(){
		TopicVotation tv = new TopicVotation();
		tv.setId(1L);
		
		VoteFilter vf = new VoteFilter();
		//TODO Add filters.
		
		List<Vote> votes = voteManager.findVotesByTopicAndVoteFilter(tv, vf);
		
	}
}
