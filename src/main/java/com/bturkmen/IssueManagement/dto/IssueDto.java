package com.bturkmen.IssueManagement.dto;

import java.util.Date;

import com.bturkmen.IssueManagement.entity.IssueStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {

	private Long id;	
	private String description;
	private String details;
	private Date date;
	private IssueStatus issueStatus;
	private UserDto assignee;
	private ProjectDto project;
}
