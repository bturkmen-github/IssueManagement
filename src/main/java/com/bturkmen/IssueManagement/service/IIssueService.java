package com.bturkmen.IssueManagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bturkmen.IssueManagement.dto.IssueDto;
import com.bturkmen.IssueManagement.dto.ProjectDto;
import com.bturkmen.IssueManagement.entity.Issue;
import com.bturkmen.IssueManagement.util.TPage;

public interface IIssueService {
	
	IssueDto save(IssueDto issue);
	IssueDto getById(Long id);
	TPage<IssueDto> getAllPageable(Pageable pageable);
	Boolean delete(IssueDto issue);
	Boolean deleteById(Long id);
	IssueDto update(Long id,IssueDto issue);
}
