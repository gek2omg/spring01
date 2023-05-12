package com.example.spring01.userTest.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;
@Data
public class LoginListDto {
    
	private String userId;
    private String password;   
    
    @QueryProjection
    public LoginListDto(String userId, String password) {		
		this.userId = userId;
		this.password = password;
	}       
}
