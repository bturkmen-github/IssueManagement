package com.bturkmen.IssueManagement.service.impl;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bturkmen.IssueManagement.dto.IssueDto;
import com.bturkmen.IssueManagement.entity.Issue;
import com.bturkmen.IssueManagement.repository.IssueRepository;
import com.bturkmen.IssueManagement.service.IIssueService;
import com.bturkmen.IssueManagement.util.TPage;

@Service
public class IssueService implements IIssueService {
	
	private final IssueRepository issueRepository;
	private final ModelMapper modelMapper;
	
	public IssueService(IssueRepository issueRepository,ModelMapper modelMapper) {
		this.issueRepository=issueRepository;
		this.modelMapper=modelMapper;
	}

	@Override
	public IssueDto save(IssueDto issueDto) {
		
		if(issueDto.getDate()==null)
			throw new IllegalArgumentException("Issue Date cannot be null");
		
		Issue issueDb = modelMapper.map(issueDto, Issue.class);
		issueDb = issueRepository.save(issueDb);
		return modelMapper.map(issueDb, IssueDto.class);
	}

	@Override
	public IssueDto getById(Long id) {
		IssueDto issueDto = modelMapper.map(issueRepository.getById(id), IssueDto.class);
		return issueDto;
	}

	@Override
	public TPage<IssueDto> getAllPageable(Pageable pageable) {
		
		Page<Issue> data = issueRepository.findAll(pageable);
		TPage page = new TPage<IssueDto>();
		IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
		page.setStat(data, Arrays.asList(dtos));
		return page;
	}

	@Override
	public Boolean delete(IssueDto issueDto) {
		Issue issueDb = modelMapper.map(issueDto, Issue.class);		
		issueRepository.delete(issueDb);
		return true;
	}

}
