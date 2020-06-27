package com.challenge.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
	
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class user {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull
	    @NotBlank
	    @Size(max = 100)
	    @Column(name = "full_name")
	    private String fullName;

	    @NotNull
	    @NotBlank
	    @Email
	    @Size(max = 100)
	    private String email;

	    @NotNull
	    @NotBlank
	    @Size(max = 50)
	    private String nickname;

	    @NotNull
	    @NotBlank
	    @Size(max = 255)
	    private String password;

	    @CreatedDate
	    @Column(name = "created_at")
	    private LocalDate createdAt;

	    @OneToMany
	    private List<submission> submissions;

	    @OneToMany
	    private List<candidate> candidates;
}
