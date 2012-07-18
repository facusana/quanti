package com.quanti.service;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quanti.model.Answer;
import com.quanti.model.Category;
import com.quanti.model.Comment;
import com.quanti.model.TopicVotation;
import com.quanti.model.User;


public class TopicVotationManagerTest extends BaseManagerTestCase {
	private Log log = LogFactory.getLog(TopicVotationManagerTest.class);
	
	@Autowired
	private TopicVotationManager topicVotationManager;
	
	
//	public void testGetTopTrendList() throws Exception {
//		List<TopicVotation> list = topicVotationManager.getTopTrendList();
//		assertNotNull(list);
//		
//		log.debug(list);
//	}
	
	@Test
	public void testSave() throws Exception {
		TopicVotation tv = new TopicVotation("tv_test", "Is this a new Question?");
		
		Answer as1 = new Answer();
		Answer as2 = new Answer();
		as1.setDescription("Answer1");
		as2.setDescription("Answer2");
		tv.addAnswer(as1);
		tv.addAnswer(as2);
		
		Category cat = new Category();
		cat.setId(1L);
		tv.setCategory(cat);
		
		User user = new User();
		user.setId(1L);
		tv.setOwner(user);
		
		log.debug("Trying to save TopicVotation + 2 answers!");
		TopicVotation tvSaved = topicVotationManager.save(tv);
		assertNotNull(tv);
		log.debug(tv);
		
		assertEquals(tv.getTopicName(), tvSaved.getTopicName());
		assertEquals(tv.getQuestion(), tvSaved.getQuestion());
		//TODO: Test answers are the same
		assertEquals(cat, tvSaved.getCategory());
		assertEquals(user, tvSaved.getOwner());
	}
	
	@Test
	public void testGetTopicVotation() throws Exception {
		TopicVotation tv = topicVotationManager.getTopicVotation(1L);
		assertNotNull(tv);
		assertThat(tv.getViews(), not(Long.valueOf(0)));
		
		Category category = tv.getCategory();
		assertNotNull(category);
		assertNotNull(category.getName());
		
		User user = tv.getOwner();
		assertNotNull(user);
		assertNotNull(user.getUsername());
		
		List<Answer> answers = tv.getAnswers();
		assertNotNull(answers);

		List<Comment> comments = tv.getComments();
		assertNotNull(comments);		
	}
	
	@Test
	public void testGetFullTopicVotation() throws Exception{
		TopicVotation tv = topicVotationManager.getFullTopicVotation(1L);
		assertNotNull(tv);
		assertThat(tv.getViews(), not(Long.valueOf(0)));
		
		Category cat = tv.getCategory();
		assertNotNull(cat);
		assertNotNull(cat.getName());
		
		User user = tv.getOwner();
		assertNotNull(user);
		assertNotNull(user.getUsername());
		
		List<Answer> answers = tv.getAnswers();
		assertNotNull(answers);
		
		List<Comment> comments = tv.getComments();
		assertNotNull(comments);
		
	}
	
	@Test
	public void testGetTopicVotationByUser() throws Exception{
		User userInSession = new User();
		userInSession.setId(1L);
		
		List<TopicVotation> tvList = topicVotationManager.getTopicVotationByUser(userInSession);
		assertNotNull(tvList);
		
		for(TopicVotation tv : tvList){
			assertEquals(userInSession.getId(), tv.getOwner().getId());
		}
	}
	
	@Test
	public void testGetTopicVotationByVotesOwner() throws Exception{
		User user = new User();
		user.setId(1L);
		
		List<TopicVotation> tvList = topicVotationManager.getTopicVotationByVotesOwner(user);
		
		assertNotNull(tvList);
		
	}
	
	
	
}
