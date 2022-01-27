package com.bturkmen.IssueManagement.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bturkmen.IssueManagement.dto.ProjectDto;
import com.bturkmen.IssueManagement.service.impl.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	private final ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService=projectService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
		ProjectDto p = projectService.getById(id);
		return ResponseEntity.ok(p);
	}
}
