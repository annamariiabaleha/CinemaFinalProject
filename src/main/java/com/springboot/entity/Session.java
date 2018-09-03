package com.springboot.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "session")
@NoArgsConstructor
@Getter @Setter
public class Session extends BaseEntity {
	
	private Date date;
	
	private String time;
	
	@Column (name = "seats")
	private String seats;
	
	@Column (columnDefinition = "Decimal(5,2)")
	private BigDecimal price;
	
	@ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn (name = "movie_id")
	private Movie movie;
	
	@ManyToOne (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn (name = "hall_id")
	private Hall hall;
	
	@OneToMany (mappedBy = "session", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Ticket> ticket;
}
