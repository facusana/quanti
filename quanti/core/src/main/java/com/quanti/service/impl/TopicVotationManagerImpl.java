package com.quanti.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.log.Log;
import com.quanti.dao.TopicVotationDao;
import com.quanti.model.TopicVotation;
import com.quanti.model.User;
import com.quanti.service.TopicVotationManager;
import com.quanti.service.TopicVotationNotFoundException;

@Service("topicVotationManager")
public class TopicVotationManagerImpl implements TopicVotationManager {

	@Autowired
	private TopicVotationDao topicVotationDao;

	public void setTopicVotationDao(TopicVotationDao topicVotationDao) {
		this.topicVotationDao = topicVotationDao;
	}
	
	public List<TopicVotation> getTopTrendList(){
		return topicVotationDao.getTopicVotationTopTrend();
	}
	
	public TopicVotation getFullTopicVotation(Long id) throws TopicVotationNotFoundException{
		TopicVotation tv = this.getTopicVotation(id);
		tv.getAnswers();
		tv.getComments();
		tv.getCategory();
		return tv;
	}
	
	public TopicVotation getTopicVotation(Long id) throws TopicVotationNotFoundException{
		try{			
			TopicVotation tv = topicVotationDao.get(id);
			tv.setViews(tv.getViews()+1);
			topicVotationDao.saveTopicVotation(tv);
			return tv;
		} catch (DataIntegrityViolationException dive) {
			//Log.warn
			throw new TopicVotationNotFoundException("Topic Votation w/ID:"+ id +" not found");
		}
	}
	
	public List<TopicVotation> getTopicVotationBy(String nameId){
		List<TopicVotation> tvs; 
		try{
			TopicVotation tv = topicVotationDao.getTopicVotationBy(nameId);
			tvs = new ArrayList<TopicVotation>();
			tvs.add(tv);
		} catch (DataIntegrityViolationException dive) {
			tvs = topicVotationDao.getTopicVotationSimilarBy(nameId);
		}
		return tvs;
	}

	public List<TopicVotation> getTopicVotationByUser(User user) {
		List<TopicVotation> tvs = topicVotationDao.getTopicVotationByUser(user);
		return tvs;
	}
	
	public List<TopicVotation> getTopicVotationByOwner(User owner) {
		//TODO Retrieve the user in session.
		return topicVotationDao.getTopicVotationByUser(owner);
	}
	
	public List<TopicVotation> getTopicVotationByVotesOwner(User votesOwner){
		//TODO Retrieve the user in session. 
		return topicVotationDao.getTopicVotationByVotesOwner(votesOwner);
	}
	
	public List<TopicVotation> search(String word){
		List<TopicVotation> list = new ArrayList<TopicVotation>();
		TopicVotation byId = topicVotationDao.getTopicVotationBy(word);
		List<TopicVotation> qList = topicVotationDao.getTopicVotationByQuestion(word);
		List<TopicVotation> tList = topicVotationDao.getTopicVotationByTag(word);

		if(byId != null){
			list.add(byId);
		}
		if(!qList.isEmpty()){
			list.addAll(qList);
		}
		if(!tList.isEmpty()){
			list.addAll(tList);
		}
		return list;
	}
	
	public TopicVotation save(TopicVotation topicVotation){
		return topicVotationDao.saveTopicVotation(topicVotation);
	}
	
	public TopicVotation edit(TopicVotation topicVotation){
		if(!topicVotation.isEditable()){
			//throw exception.
		}
		return topicVotationDao.editTopicVotation(topicVotation);		
	}
}
