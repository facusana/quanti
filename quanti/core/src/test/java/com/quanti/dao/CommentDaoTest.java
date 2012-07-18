package com.quanti.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quanti.model.Comment;
import com.quanti.model.TopicVotation;
import com.quanti.model.User;

public class CommentDaoTest extends BaseDaoTestCase{

	@Autowired
	private CommentDao dao;
	
	@Test
	public void testSave() throws Exception{
		User user = new User();
		user.setId(1L);

		TopicVotation tv = new TopicVotation("tv_comment","comment Q?");
		tv.setId(1L);
		
		Comment comment = new Comment("This is the comment");
		tv.addComment(comment);
		comment.setOwner(user);
		
		Comment cSaved = dao.save(comment);
		
		assertNotNull(cSaved);
		assertEquals(comment.getComment(), cSaved.getComment());
	}
	
	@Test
	public void testGetCommentsByTopicVotation() throws Exception{
		TopicVotation tv = new TopicVotation();
		tv.setId(1L);
		
		List<Comment> comments = dao.getCommentsBy(tv);
		assertNotNull(comments);
		assertTrue(comments.size() > 0);
		log.debug("Quantity comments: " + comments.size());
	}
}
