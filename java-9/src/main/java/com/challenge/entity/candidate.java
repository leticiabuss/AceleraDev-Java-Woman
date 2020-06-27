package com.challenge.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class candidate {
	
	  @EmbeddedId
	  private CandidateId candidateId;

	  @NotNull
	  @NotBlank
	  private Integer status;

	  @CreatedDate
	  @Column(name = "created_at")
	  private LocalDate createdAt;
	
	
}
