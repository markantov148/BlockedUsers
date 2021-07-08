/**
 * 
 */
package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author Markanto.v
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Document(collection="blockedusers")
public class BlockedUsers {
	
	@Id
	long employeeId;
	String employeeName;
	String domainName;
	LocalDate blockedDate;
	boolean isBlocked;
}
