package com.bturkmen.IssueManagement.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name ="issue_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class IssueHistory extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(name = "issue_id")
	@ManyToOne(optional = true,fetch = FetchType.LAZY)
	private Issue issue;
	
	@JoinColumn(name = "assignee_user_id")
	@ManyToOne(optional = true,fetch = FetchType.LAZY)
	private User assignee;
	

}
