package com.bturkmen.IssueManagement.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bturkmen.IssueManagement.dto.ProjectDto;
import com.bturkmen.IssueManagement.service.impl.ProjectService;
import com.bturkmen.IssueManagement.util.ApiPaths;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {
	
	private final ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService=projectService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id",required = true) Long id) {
		ProjectDto p = projectService.getById(id);
		return ResponseEntity.ok(p);
	}
	
	@PostMapping
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {
		return ResponseEntity.ok(projectService.save(projectDto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id",required = true) Long id,@RequestBody ProjectDto project) {
		return ResponseEntity.ok(projectService.update(id,project));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id) {
		ProjectDto p = projectService.getById(id);
		return ResponseEntity.ok(projectService.delete(p));
	}
	
}
