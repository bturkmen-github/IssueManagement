package com.bturkmen.IssueManagement.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bturkmen.IssueManagement.entity.Issue;
import com.bturkmen.IssueManagement.repository.IssueRepository;
import com.bturkmen.IssueManagement.service.IIssueService;

@Service
public class IssueService implements IIssueService {
	
	private final IssueRepository issueRepository;
	
	public IssueService(IssueRepository issueRepository) {
		this.issueRepository=issueRepository;
	}

	@Override
	public Issue save(Issue issue) {
		return issueRepository.save(issue);
	}

	@Override
	public Issue getById(Long id) {
		return issueRepository.getById(id);
	}

	@Override
	public Page<Issue> getAllPageable(Pageable pageable) {
		return issueRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(Issue issue) {
		issueRepository.delete(issue);
		return true;
	}

}
