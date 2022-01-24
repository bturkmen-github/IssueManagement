package com.bturkmen.IssueManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bturkmen.IssueManagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
