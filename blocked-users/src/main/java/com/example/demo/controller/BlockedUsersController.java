/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bl.BlockedUsersBL;
import com.example.demo.dl.BlockedUsersDL;
import com.example.demo.entity.BlockedUsers;
import com.example.demo.repo.BlockedUsersRepository;

/**
 * @author Markanto.v
 *
 */
@RestController
@RequestMapping(path="/admin/blockedusers")
public class BlockedUsersController {

	@Autowired
	private BlockedUsersBL serviceBL;
	
	@Autowired
	private BlockedUsersDL serviceDL;
	
	@Autowired
	private BlockedUsersRepository repo;
	
	// This method is used to get the details of all blocked users//
	@GetMapping(path="/list")
	public ResponseEntity<List<BlockedUsers>> getAllBlockedUsersDetails(){
		
		List<BlockedUsers> blockedList=this.serviceBL.findByIsBlocked(true);
		return ResponseEntity.status(HttpStatus.OK).body(blockedList);
	}
	//End of getAll() method
	
	//This method is used to unblock the user by his/her employeeid//
	@PutMapping(path="/action/unblock/yes/{employeeid}")
	public ResponseEntity<BlockedUsers> unBlockUser(@PathVariable("employeeid") Long employeeId){
		
		BlockedUsers user=this.serviceBL.unBlockUser(employeeId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	//End of unblock() method
}
