package com.quanti.service;

import java.util.List;

import com.quanti.model.TopicVotation;
import com.quanti.model.User;

public interface TopicVotationManager {
	
	public List<TopicVotation> getTopTrendList();
	
	public TopicVotation getFullTopicVotation(Long id) throws TopicVotationNotFoundException;
	
	public TopicVotation getTopicVotation(Long id) throws TopicVotationNotFoundException;

	public List<TopicVotation> getTopicVotationByUser(User user);
	
	public List<TopicVotation> getTopicVotationByOwner(User owner);
	
	public List<TopicVotation> getTopicVotationByVotesOwner(User user);
	
	public List<TopicVotation> search(String word);
	
	public TopicVotation save(TopicVotation topicVotation);
	
	public TopicVotation edit(TopicVotation topicVotation);


}
