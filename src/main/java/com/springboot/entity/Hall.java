package com.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.springboot.validator.HallNameConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hall")
@NoArgsConstructor
@Getter @Setter
public class Hall extends BaseEntity{
	
	@HallNameConstraint
	private String name;
	
//	@NotNull (message = "Set capacity")
	private int capacity;
	
//	@NotNull (message = "Set seats in row")
//	@Min(10)
	@Column (name = "seats_in_row")
	private int seatsInRow;
	
//	@NotEmpty (message = "Inappropriate info")
	private String info;
	
	@Column (name = "is_available", nullable = false)
	private Boolean isAvailable = true;
	
	@OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hall")
	private List<Session> session;
}
