package com.example.spring01.userTest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Table(name = "member")
public class Login {
	@Id
	private Long memberId;
	
	private String userId;
	
    private String password;
	
    public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Login(String userId, String password) {		
		this.userId = userId;
		this.password = password;
	}   
    
    
}
