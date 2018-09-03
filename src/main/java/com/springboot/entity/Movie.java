package com.springboot.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movie")
@NoArgsConstructor
@Getter @Setter
public class Movie extends BaseEntity {

	@NotEmpty (message = "Movie name can't be empty")
	@Column( name = "name")
	private String name;
	
	private int age;
	
	private String language;
	
	private String genre;
	
	private String duration;
	
	private String production;
	
	private String staring;
	
	@NotEmpty (message = "info can't be empty")
	@Column( name = "info")
	private String info;
	
	@NotEmpty (message = "Technology can't be empty")
	@Column( name = "technology")
	private String technology;
	
	@NotEmpty (message = "Start date can't be empty")
	@Column ( name = "start_date")
	private Date startDate;

	
	@NotEmpty (message = "Finish date can't be empty")
	@Column ( name = "finish_date")
	private Date finishDate;
	
	@NotEmpty (message = "Select image")
	@Column(name = "image_path")
	private String imagePath;
	
	@OneToMany (mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Session> session;
}
