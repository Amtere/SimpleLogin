package com.amdev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Usuarios")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name="author_generator", sequenceName = "sequence_p", allocationSize = 1)
    @Column(name = "id")
	private int id;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "password")
	private String password;

	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
