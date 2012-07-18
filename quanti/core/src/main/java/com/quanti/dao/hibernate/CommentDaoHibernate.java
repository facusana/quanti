package com.quanti.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.quanti.dao.CommentDao;
import com.quanti.model.Comment;
import com.quanti.model.TopicVotation;

@Repository("commentDao")
public class CommentDaoHibernate extends GenericDaoHibernate<Comment, Long> implements CommentDao {

	public CommentDaoHibernate(){
		super(Comment.class);
	}

	public List<Comment> getCommentsBy(TopicVotation topicVotation) {
		DetachedCriteria dc = DetachedCriteria.forClass(Comment.class);
		dc.add(Restrictions.eq("topicVotation", topicVotation));
		return getHibernateTemplate().findByCriteria(dc);
	}
	
}
