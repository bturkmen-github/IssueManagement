package com.bturkmen.IssueManagement.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bturkmen.IssueManagement.dto.ProjectDto;
import com.bturkmen.IssueManagement.entity.Project;
import com.bturkmen.IssueManagement.repository.ProjectRepository;
import com.bturkmen.IssueManagement.service.IProjectService;

@Service
public class ProjectService implements IProjectService {
	
	private final ProjectRepository projectRepository;
	private final ModelMapper modelMapper;
	
	public ProjectService(ProjectRepository projectRepository,ModelMapper modelMapper) {
		this.projectRepository=projectRepository;
		this.modelMapper=modelMapper;
	}

	@Override
	public ProjectDto save(ProjectDto project) {

		Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
		
		if(projectCheck!=null)
			throw new IllegalArgumentException("Project Code Already Exist");
		
		Project projectDb = modelMapper.map(project, Project.class);
		projectDb = projectRepository.save(projectDb);
		
		return modelMapper.map(projectDb, ProjectDto.class);
	}

	@Override
	public ProjectDto getById(Long id) {
		Project p = projectRepository.getById(id);	
		return modelMapper.map(p, ProjectDto.class);
	}

	@Override
	public Page<Project> getAllPageable(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(ProjectDto project) {
		Project p = modelMapper.map(project, Project.class);
		projectRepository.delete(p);
		return true;
	}

	@Override
	public ProjectDto getByProjectCode(String projectCode) {		
		Project p = projectRepository.getByProjectCode(projectCode);		
		return modelMapper.map(p, ProjectDto.class);
	}

	@Override
	public List<ProjectDto> getByProjectCodeContains(String projectCode) {
		return null;
	}

}
