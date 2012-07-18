package com.quanti.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserManagerTest extends BaseManagerTestCase{
	private Log log = LogFactory.getLog(UserManagerTest.class);
	
	@Autowired
	private UserManager userManager;
	
	@Test
	public void testSaveUser() throws Exception{}
	
	@Test
	public void testDeleteUser() throws Exception{} 

	@Test
	public void testEditPassword() throws Exception{}
	
	@Test
	public void testEditInformation() throws Exception{}
	
	@Test
	public void testEditLocation() throws Exception{}
	
	
}
