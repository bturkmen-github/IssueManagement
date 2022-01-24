package com.bturkmen.IssueManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bturkmen.IssueManagement.entity.IssueHistory;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long>{

}
