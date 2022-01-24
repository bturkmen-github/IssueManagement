package com.bturkmen.IssueManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bturkmen.IssueManagement.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
