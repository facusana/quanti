package com.quanti.service;

import java.util.List;

import com.quanti.model.Comment;
import com.quanti.model.TopicVotation;

public interface CommentManager {

	public Comment saveComment(Comment comment);
	
	public List<Comment> getCommentsBy(TopicVotation topicVotation);
	
	
}
