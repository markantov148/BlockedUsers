/**
 * 
 */
package com.example.demo.dl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BlockedUsers;
import com.example.demo.repo.BlockedUsersRepository;

/**
 * @author Markanto.v
 *
 */
@Service("blockedUsersService")
public class BlockedUsersDL {

	@Autowired
	private BlockedUsersRepository repo;
	
	//This method returns the list of all blocked users//
	public List<BlockedUsers> findAllBlockedUsersDetails(){
		
		return this.repo.findAll();
	}
	//End of findAll() method
	
	//This method is used to save the blocked users details to the list//
	public BlockedUsers saveBlockedUsersDetails(BlockedUsers blockedUsersDetails) {
		
		return this.repo.save(blockedUsersDetails);
		
	}
	//End of saving the blocked users details method
	
	//This method is to blocked user by employeeid to unblock
	public Optional<BlockedUsers> findEmployeeById(Long id){
		
		return this.repo.findById(id);
	}
	//end of findById() method

	
	//This method is used to unblock the user from the list//
	public BlockedUsers unBlockUser(Long employeeId) {
		
		Optional<BlockedUsers> user=this.repo.findById(employeeId);
		BlockedUsers unblockedUser=user.get();
		
		unblockedUser.setBlocked(false);
		
		return this.repo.save(unblockedUser);
	}
	//End of unblock() method
	
	//This method is to return blocked users whose blocked status are true
	public List<BlockedUsers> findByIsBlocked(boolean blockedStatus){
		
		return this.repo.findByIsBlocked(true);
	}
	//end of findByIsBlocked() method
}
