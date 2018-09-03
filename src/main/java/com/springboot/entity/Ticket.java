package com.springboot.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "ticket")
@NoArgsConstructor
@Getter @Setter
public class Ticket extends BaseEntity {
	
	private int row;
	
	private int seat;
	
	private boolean isApproved;
	
	private Timestamp creationTime;
	
	@ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn (name = "session_id")
	private Session session;
	
	@ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn (name = "user_id")
	private UserEntity user;
	
}
