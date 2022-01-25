package com.bturkmen.IssueManagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bturkmen.IssueManagement.entity.Issue;

public interface IIssueService {
	
	Issue save(Issue issue);
	Issue getById(Long id);
	Page<Issue> getAllPageable(Pageable pageable);
	Boolean delete(Issue issue);
}
