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

import com.bturkmen.IssueManagement.dto.IssueDto;
import com.bturkmen.IssueManagement.service.impl.IssueService;
import com.bturkmen.IssueManagement.util.ApiPaths;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {
	
	private final IssueService issueService;
	
	public IssueController(IssueService issueService) {
		this.issueService=issueService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id) {
		IssueDto p = issueService.getById(id);
		return ResponseEntity.ok(p);
	}
	
	@PostMapping
	public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issueDto) {
		return ResponseEntity.ok(issueService.save(issueDto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id",required = true) Long id,@RequestBody IssueDto issueDto) {
		return ResponseEntity.ok(issueService.update(id,issueDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id) {
		return ResponseEntity.ok(issueService.deleteById(id));
	}
	
}
