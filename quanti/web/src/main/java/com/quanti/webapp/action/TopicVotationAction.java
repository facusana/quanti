package com.quanti.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.quanti.model.TopicVotation;
import com.quanti.service.CommentManager;
import com.quanti.service.TopicVotationManager;
import com.quanti.service.TopicVotationNotFoundException;

public class TopicVotationAction extends BaseAction implements Preparable {
	private static final long serialVersionUID = 4902918571384883254L;
	private TopicVotationManager topicVotationManager;
	private CommentManager commentManager;
	
	
	private TopicVotation topicVotation;
	
	public void prepare() throws Exception {
		
	}

	public String find() throws Exception{
		//
		try{
			topicVotation = topicVotationManager.getTopicVotation(topicVotation.getId());
			return SUCCESS;
		} catch (TopicVotationNotFoundException e) {
			addActionError(getText("errors.not.found.topic_votation"));
			return INPUT;
		}
	}
	
}
