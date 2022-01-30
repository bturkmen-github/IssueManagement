package com.bturkmen.IssueManagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bturkmen.IssueManagement.entity.Project;



public interface ProjectRepository extends JpaRepository<Project, Long> {

	Project getByProjectCode(String projectCode);
	
	Project getByProjectCodeAndIdNot(String projectCode,Long id);
	
	List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode,String projectName);
	
	List<Project> getByProjectCodeContains(String projectCode);
	
	Page<Project> findAll(Pageable pageable);
	
	List<Project> findAll(Sort sort);
}
