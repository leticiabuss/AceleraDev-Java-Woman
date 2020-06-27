package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class CandidateId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
    private User user;

    @ManyToOne
    private acceleration acceleration;

    @ManyToOne
    private company company;
}
