package com.bturkmen.IssueManagement.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bturkmen.IssueManagement.entity.Project;
import com.bturkmen.IssueManagement.repository.ProjectRepository;
import com.bturkmen.IssueManagement.service.IProjectService;

@Service
public class ProjectService implements IProjectService {
	
	private final ProjectRepository projectRepository;
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository=projectRepository;
	}

	@Override
	public Project save(Project project) {

		if(project.getProjectCode()==null) {
			throw new IllegalArgumentException("Project Code cannot be Null");
		}
		
		return projectRepository.save(project);
	}

	@Override
	public Project getById(Long id) {
		return projectRepository.getById(id);
	}

	@Override
	public Page<Project> getAllPageable(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(Project project) {
		projectRepository.delete(project);
		return true;
	}

	@Override
	public List<Project> getByProjectCode(String projectCode) {
		return projectRepository.getByProjectCode(projectCode);
	}

	@Override
	public List<Project> getByProjectCodeContains(String projectCode) {
		return projectRepository.getByProjectCodeContains(projectCode);
	}

}
