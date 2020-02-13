package com.perscholas.casestudy.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Accounts
 *
 */

@NamedQueries({
	@NamedQuery(query = "SELECT a FROM Accounts a", name= "GetAllAccounts"),
	@NamedQuery(query = "SELECT a FROM Accounts a WHERE a.email = :accountEmail", name = "GetAccountByEmail")	
})
@Entity
public class Accounts implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private int id;
	
	private String email;
	
	private String password;
	
	private String nickname;

	/**
	 * 
	 */
	public Accounts() {
		super();
	}   
	
	
	/**
	 * @param id
	 * @param email
	 * @param password
	 * @param nickname
	 */
	public Accounts( String email, String password, String nickname) {
		//this.setId(id);
		this.setEmail(email);
		this.setPassword(password);
		this.setNickname(nickname);
	}


	/**
	 * @return
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}   
	/**
	 * @return
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}   
	/**
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}   
	/**
	 * @return
	 */
	public String getNickname() {
		return this.nickname;
	}

	/**
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Accounts [id=" + id + ", email=" + email + ", password=" + password + ", nickname=" + nickname + "]";
	}
   
}
