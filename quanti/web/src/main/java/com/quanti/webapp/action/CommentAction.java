package com.quanti.webapp.action;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;

import com.opensymphony.xwork2.Preparable;
import com.quanti.model.Comment;
import com.quanti.model.TopicVotation;
import com.quanti.service.CommentManager;
import com.quanti.service.TopicVotationManager;
import com.quanti.service.TopicVotationNotFoundException;

public class CommentAction extends BaseAction implements Preparable{
	private static final long serialVersionUID = 7113415573926172839L;
	private CommentManager commentManager;
	private TopicVotationManager topicVotationManager;
	
	private Comment comment;
	
	
	public void prepare() throws Exception {
		
		
	}
	
	public String save() throws Exception{
		//TODO ya viene?
		Long tvId = Long.valueOf(getRequest().getParameter("topicVotation.id"));
		String commentStr = getRequest().getParameter("comment.comment");
		
		try{
			TopicVotation tv = topicVotationManager.getTopicVotation(tvId);
			comment.setTopicVotation(tv);
			commentManager.saveComment(comment);
			
			return SUCCESS;
		} catch (AccessDeniedException ade) {
			log.warn(ade.getMessage());
			getResponse().sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		} catch (TopicVotationNotFoundException tvnfe) {
			addActionError(getText("errors.not.found.topic_votation"));
			return INPUT;
		}
	}
	

}
