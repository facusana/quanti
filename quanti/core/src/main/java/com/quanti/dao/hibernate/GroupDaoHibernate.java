package com.quanti.dao.hibernate;

import java.util.List;

import com.quanti.model.Group;
import com.quanti.model.app.User;

public class GroupDaoHibernate {

	public void createGroup(Group group){
		//TODO TBD.
	}
	
	public void deleteUserFromGroup(Group group, User user){
		//If the group doesnt have more users the group must be deleted.
		
	}
	
	public void editGroup(Group group){
		
	}
	
	public List<Group> loadNonAcceptedGroupsBy(User user){
		return null;
	}
	
	public List<Group> loadAcceptedGroupsBy(User user){
		return null;
	}
	
	public Group loadGroupBy(Long id){
		return null;
	}
	
}
