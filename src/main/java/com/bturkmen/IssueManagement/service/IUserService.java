package com.bturkmen.IssueManagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bturkmen.IssueManagement.entity.User;

public interface IUserService {
	User save(User user);
	User getById(Long id);
	Page<User> getAllPageable(Pageable pageable);
	Boolean delete(User user);
	User getByUserName(String userName);
}
