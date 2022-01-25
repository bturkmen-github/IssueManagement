package com.bturkmen.IssueManagement.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bturkmen.IssueManagement.entity.User;
import com.bturkmen.IssueManagement.repository.UserRepository;
import com.bturkmen.IssueManagement.service.IUserService;

@Service
public class UserService implements IUserService{
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}

	@Override
	public User save(User user) {

		if(user.getEmail()==null) {
			throw new IllegalArgumentException("Username Email cannot be null");
		}
		
		return userRepository.save(user);
	}

	@Override
	public User getById(Long id) {
		return userRepository.getById(id);
	}

	@Override
	public Page<User> getAllPageable(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(User user) {
		userRepository.delete(user);
		return null;
	}

	@Override
	public User getByUserName(String userName) {
		return userRepository.getByUserName(userName);
	}

}
