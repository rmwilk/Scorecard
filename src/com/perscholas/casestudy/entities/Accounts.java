package com.perscholas.casestudy.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Accounts
 *
 */
@Entity

public class Accounts implements Serializable {

	   
	@Id
	private int id;
	private String email;
	private String password;
	private String nickname;
	private static final long serialVersionUID = 1L;

	public Accounts() {
		super();
	}   
	
	
	/**
	 * @param id
	 * @param email
	 * @param password
	 * @param nickname
	 */
	public Accounts(int id, String email, String password, String nickname) {
		this.setId(id);
		this.setEmail(email);
		this.setPassword(password);
		this.setNickname(nickname);
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
   
}
