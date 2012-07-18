package com.quanti.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.quanti.dao.VoteDao;
import com.quanti.model.TopicVotation;
import com.quanti.model.User;
import com.quanti.model.Vote;
import com.quanti.model.VoteFilter;

@Repository("voteDao")
public class VoteDaoHibernate extends GenericDaoHibernate<Vote, Long> implements VoteDao {

	public VoteDaoHibernate(){
		super(Vote.class);
	}
	
	public Vote saveVote(Vote vote){
		getHibernateTemplate().saveOrUpdate(vote);
		getHibernateTemplate().flush();
		return vote;
	}

	public List<Vote> getVotesBy(User user) {
		DetachedCriteria dc = DetachedCriteria.forClass(Vote.class);
		dc.add(Restrictions.eq("votant", user));
		return getHibernateTemplate().findByCriteria(dc);
	}

	public List<Vote> getVotesBy(TopicVotation topicVotation, VoteFilter filter) {
		// TODO create query.
		//SELECT v.answer_id, count(*) from `quanti`.`vote` v JOIN `quanti`.`user` u where user_id=u.id and u.birthdate>'1950-06-06' and topic_votation_id = 1 group by answer_id;
		return null;
	}
	
}
