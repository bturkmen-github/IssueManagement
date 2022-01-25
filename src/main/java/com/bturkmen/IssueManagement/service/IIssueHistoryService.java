package com.bturkmen.IssueManagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bturkmen.IssueManagement.entity.IssueHistory;

public interface IIssueHistoryService {
	IssueHistory save(IssueHistory issueHistory);
	IssueHistory getById(Long id);
	Page<IssueHistory> getAllPageable(Pageable pageable);
	Boolean delete(IssueHistory issueHistory);
}
