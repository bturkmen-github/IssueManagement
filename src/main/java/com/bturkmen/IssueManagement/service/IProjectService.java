package com.bturkmen.IssueManagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bturkmen.IssueManagement.entity.Project;

public interface IProjectService {
	Project save(Project project);
	Project getById(Long id);
	Page<Project> getAllPageable(Pageable pageable);
	Boolean delete(Project project);
	
	List<Project> getByProjectCode(String projectCode);
	List<Project> getByProjectCodeContains(String projectCode);
}
