package com.quanti.dao;

import java.util.List;

import com.quanti.model.TopicVotation;
import com.quanti.model.User;

public interface TopicVotationDao extends GenericDao<TopicVotation, Long>{

	public List<TopicVotation> getTopicVotationByUser(User user);
	
	public List<TopicVotation> getTopicVotationByVotesOwner(User user);

	//public TopicVotation getFullTopicVotationBy(Long id);
	
	public TopicVotation getTopicVotationBy(String nameId);
	
	public List<TopicVotation> getTopicVotationSimilarBy(String nameId);
	
	public List<TopicVotation> getTopicVotationByQuestion(String question);
	
	public List<TopicVotation> getTopicVotationByTag(String tag);
	
	public List<TopicVotation> getTopicVotationTopTrend();
	
	public TopicVotation saveTopicVotation(TopicVotation topicVotation);
	
	public TopicVotation editTopicVotation(TopicVotation topicVotation);
	
	public void deleteTopicVotation(TopicVotation topicVotation);
	
	
	
}
