package com.quanti.service;

public class TopicVotationNotFoundException extends Exception{

	private static final long serialVersionUID = 3984377778542816237L;
	
	public TopicVotationNotFoundException(final String message){
		super(message);
	}
}
