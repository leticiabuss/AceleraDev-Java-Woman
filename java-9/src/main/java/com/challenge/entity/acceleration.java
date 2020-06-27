package com.challenge.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class acceleration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer acceleration_id;
	
	@NotBlank
	@NotNull
	@Size(min = 1, max = 100)
	private String name;
	
	@NotBlank
	@NotNull
	@Size(min = 1, max = 50)
	private String slug;
	
	@ManyToOne
	private challenge challenge;
	
	 @CreatedDate
	 @Column(name = "created_at")
	 private LocalDate createAt;
	
	@OneToMany
	private List<candidate> candidate;
	
}
