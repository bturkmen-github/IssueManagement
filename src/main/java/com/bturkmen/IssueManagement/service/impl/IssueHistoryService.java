package com.bturkmen.IssueManagement.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bturkmen.IssueManagement.entity.IssueHistory;
import com.bturkmen.IssueManagement.repository.IssueHistoryRepository;
import com.bturkmen.IssueManagement.service.IIssueHistoryService;

@Service
public class IssueHistoryService implements IIssueHistoryService {
	
	private final IssueHistoryRepository issueHistoryRepository;
	
	public IssueHistoryService(IssueHistoryRepository issueHistoryRepository) {
		this.issueHistoryRepository=issueHistoryRepository;
	}

	@Override
	public IssueHistory save(IssueHistory issueHistory) {
		
		if(issueHistory.getDate()==null) {
			throw new IllegalArgumentException("Issue History Date Cannot be Null");
		}
			
		return issueHistoryRepository.save(issueHistory);
	}

	@Override
	public IssueHistory getById(Long id) {
		return issueHistoryRepository.getById(id);
	}

	@Override
	public Page<IssueHistory> getAllPageable(Pageable pageable) {
		return issueHistoryRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(IssueHistory issueHistory) {
		issueHistoryRepository.delete(issueHistory);
		return Boolean.TRUE;
	}

}
