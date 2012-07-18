package com.quanti.dao;

import java.util.List;

import com.quanti.model.Group;
import com.quanti.model.app.User;

public interface GroupDao {

	public void createGroup(Group group);
	
	public void deleteUserFromGroup(Group group, User user);
	
	public void editGroup(Group group);
	
	public List<Group> loadNonAcceptedGroupsBy(User user);
	
	public List<Group> loadAcceptedGroupsBy(User user);
	
	public Group loadGroupBy(Long id);
	
}
