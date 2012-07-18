package com.quanti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanti.dao.CommentDao;
import com.quanti.model.Comment;
import com.quanti.model.TopicVotation;
import com.quanti.service.CommentManager;

@Service("commentManager")
public class CommentManagerImpl implements CommentManager{

	@Autowired
	private CommentDao commentDao;
	
	public Comment saveComment(Comment comment) {
		return commentDao.save(comment);
	}

	public List<Comment> getCommentsBy(TopicVotation topicVotation) {
		
		return commentDao.getCommentsBy(topicVotation);
	}
	
	

	
	
}
