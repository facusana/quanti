package com.quanti.dao;

import java.util.List;

import com.quanti.model.Comment;
import com.quanti.model.TopicVotation;

public interface CommentDao extends GenericDao<Comment, Long> {

	public List<Comment> getCommentsBy(TopicVotation topicVotation);
}
