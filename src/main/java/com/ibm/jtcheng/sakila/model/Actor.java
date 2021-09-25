package com.ibm.jtcheng.sakila.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = Actor.TABLE_NAME)
@Setter
@Getter
public class Actor {
	public static final String TABLE_NAME = "actor";

	@Id
	@Column(name = "actor_id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "last_update")
	private LocalDateTime lastUpdate;

}
