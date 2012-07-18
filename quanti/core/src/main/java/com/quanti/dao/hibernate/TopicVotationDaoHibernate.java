package com.quanti.dao.hibernate;

import java.util.List;

import javax.persistence.FetchType;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Distinct;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.quanti.dao.TopicVotationDao;
import com.quanti.model.TopicVotation;
import com.quanti.model.User;

@Repository("topicVotationDao")
public class TopicVotationDaoHibernate extends GenericDaoHibernate<TopicVotation, Long> implements TopicVotationDao{

    public TopicVotationDaoHibernate() {
        super(TopicVotation.class);
    }
	
	public List<TopicVotation> getTopicVotationByUser(final User user) {
		DetachedCriteria dc = DetachedCriteria.forClass(TopicVotation.class);
		dc.add(Restrictions.eq("owner", user));
		
		return getHibernateTemplate().findByCriteria(dc);
	}

//	public TopicVotation getFullTopicVotationBy(Long id) {
//		DetachedCriteria dc = DetachedCriteria.forClass(TopicVotation.class);
//		dc.createCriteria("comments")
//		.createCriteria("answers")
//		return null;
//	}
	
	
	public List<TopicVotation> getTopicVotationByVotesOwner(User user){
		DetachedCriteria dc = DetachedCriteria.forClass(TopicVotation.class);
		dc.createCriteria("votes")
		.add(Restrictions.eq("votant", user))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		//join TV with V where v.user_id = user.getId()
		return getHibernateTemplate().findByCriteria(dc);
	}

	public TopicVotation getTopicVotationBy(String nameId) {
		DetachedCriteria dc = DetachedCriteria.forClass(TopicVotation.class);
		dc.add(Restrictions.eq("topicName", nameId));
		//TODO return one value.
		//return getHibernateTemplate().findByCriteria(dc);
		return null;
	}
	
	public List<TopicVotation> getTopicVotationSimilarBy(String nameId){
		//TODO select * from `quanti`.`user` WHERE MATCH (username) AGAINST ("facu");
		return null;
	}

	public List<TopicVotation> getTopicVotationByQuestion(String question) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TopicVotation> getTopicVotationByTag(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TopicVotation> getTopicVotationTopTrend() {
		// TODO Auto-generated method stub
		return null;
	}

	public TopicVotation saveTopicVotation(TopicVotation topicVotation) {		
		getHibernateTemplate().saveOrUpdate(topicVotation);
		getHibernateTemplate().flush();
		return topicVotation;
	}

	public TopicVotation editTopicVotation(TopicVotation topicVotation) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteTopicVotation(TopicVotation topicVotation) {
		// TODO Auto-generated method stub
	}
}
