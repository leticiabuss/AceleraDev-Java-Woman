package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class submissionId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
    private user user;

    @ManyToOne
    private challenge challenge;
}
