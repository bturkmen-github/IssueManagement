package com.bturkmen.IssueManagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bturkmen.IssueManagement.dto.ProjectDto;
import com.bturkmen.IssueManagement.entity.Project;

public interface IProjectService {
	ProjectDto save(ProjectDto project);
	ProjectDto getById(Long id);
	Page<Project> getAllPageable(Pageable pageable);
	Boolean delete(ProjectDto project);
	
	ProjectDto getByProjectCode(String projectCode);
	List<ProjectDto> getByProjectCodeContains(String projectCode);
}
