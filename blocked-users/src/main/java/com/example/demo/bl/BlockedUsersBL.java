/**
 * 
 */
package com.example.demo.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dl.BlockedUsersDL;
import com.example.demo.entity.BlockedUsers;

/**
 * @author Markanto.v
 *
 */
@Component
public class BlockedUsersBL {

	@Autowired
	private BlockedUsersDL serviceDL;
	
	//This method is used to get the blocked users details//
	public List<BlockedUsers> getAllBlockedUsersDetails(){
		
		return this.serviceDL.findAllBlockedUsersDetails();
	}
	//End of get() method
	
	//This method is used to fetch the user by his/her isBlockedStatus
	public List<BlockedUsers> findByIsBlocked(boolean blockedStatus){
		
		return this.serviceDL.findByIsBlocked(blockedStatus);
	}
	//End of findByIsBlocked() Method

	//This method is used to unblock the user of the specific employee id
	public BlockedUsers unBlockUser(Long employeeId) {

		return this.serviceDL.unBlockUser(employeeId);
	}
	//End of unBlock() method
}
