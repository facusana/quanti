package com.quanti.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.annotation.NotTransactional;

import com.quanti.model.Answer;
import com.quanti.model.Category;
import com.quanti.model.TopicVotation;
import com.quanti.model.User;

public class TopicVotationDaoTest extends BaseDaoTestCase {

	@Autowired
	private TopicVotationDao dao;
	
	@Test
	@ExpectedException(DataAccessException.class)
	public void testGetTopicVotationInvalid() throws Exception{
		//should throw DAExc.
		dao.get(-100L);
	}
	
	@Test
	public void testGetTopicVotation() throws Exception{
		TopicVotation tv = dao.get(1L);
		assertNotNull(tv);

		log.debug("Trying to retreive Answers.");
		List<Answer> as = tv.getAnswers();
		assertNotNull(as);
		//assertEquals(2, as.size());
		
	}
	
	@Test
	@NotTransactional
	public void testUpdateTopicVotation() throws Exception{
		TopicVotation tv = dao.get(1L);
		tv.setTopicName("Es un test?");
		
		dao.save(tv);
		flush();
		
		tv = dao.get(1L);
		assertEquals("Es un test?", tv.getTopicName());		
	}
	
	@Test
	public void testSaveTopicVotation(){
		
		TopicVotation tv = new TopicVotation("tv_test", "Is this a new Question?");
		
		Answer as1 = new Answer("Answer1");
		tv.addAnswer(as1);
		Answer as2 = new Answer("Answer2");	
		tv.addAnswer(as2);
		
		Category cat = new Category();
		cat.setId(1L);
		tv.setCategory(cat);
		
		User user = new User();
		user.setId(1L);
		tv.setOwner(user);
		
		log.debug("Trying to save TopicVotation + 2 answers!");
		TopicVotation tvSaved = dao.saveTopicVotation(tv);
		assertNotNull(tv);
		log.debug(tv);
		
		assertEquals(tv.getTopicName(), tvSaved.getTopicName());
		assertEquals(tv.getQuestion(), tvSaved.getQuestion());
		//TODO: Test answers are the same
		assertEquals(cat, tvSaved.getCategory());
		assertEquals(user, tvSaved.getOwner());
	}
	
	@Test
	public void testGetTopicVotationByUser(){
		User user = new User();
		user.setId(1L);
		
		List<TopicVotation> tvList = dao.getTopicVotationByUser(user);
		assertNotNull(tvList);
		
		for(TopicVotation tv : tvList){
			assertEquals(user.getId(), tv.getOwner().getId());
		}
	}
	
	@Test
	public void testRemoveTopicVotation(){
		
	}
	
}
