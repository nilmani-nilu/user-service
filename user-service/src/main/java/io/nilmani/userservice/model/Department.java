package io.nilmani.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	
	private Long departmentID;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

}
