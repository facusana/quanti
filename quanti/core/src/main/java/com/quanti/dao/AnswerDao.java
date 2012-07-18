package com.quanti.dao;

import java.util.Set;

import com.quanti.model.Answer;

public interface AnswerDao {

	public Set<Answer> getAnswersBy(Long topicVotationId);
	public void saveAnswer(Answer answer);
	public void editAnswer(Answer answer);
	public void deleteAnswer(Answer answer);
	
}
