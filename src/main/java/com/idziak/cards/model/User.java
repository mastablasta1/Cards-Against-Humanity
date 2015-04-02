package com.idziak.cards.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "\"User\"")
@NamedQuery(name = User.FIND_BY_NICKNAME, query = "SELECT u FROM \"User\" u WHERE u.nickname = :nickname")
public class User implements Serializable {

	public static final String FIND_BY_NICKNAME = "User.findByNickname";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@Size(min = 4, max = 32)
	private String nickname;

	@Size(min = 6, max = 32)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
