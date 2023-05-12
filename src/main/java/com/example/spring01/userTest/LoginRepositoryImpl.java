package com.example.spring01.userTest;


import java.util.List;

import javax.persistence.EntityManager;

import com.example.spring01.userTest.dto.LoginListDto;
import com.example.spring01.userTest.dto.QLoginListDto;
import com.example.spring01.userTest.entity.QLogin;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class LoginRepositoryImpl implements LoginRepositoryCustom{
	
	private final JPAQueryFactory queryFactory;

    public LoginRepositoryImpl(EntityManager em) {

        this.queryFactory = new JPAQueryFactory(em);
    }
	

	@Override
	public LoginListDto searchUserIdV1(String userId) {
		
		// TODO Auto-generated method stub
		
		LoginListDto loginDto =  queryFactory
                .select(new QLoginListDto(
                		QLogin.login.userId,
                		QLogin.login.password))
                .from(QLogin.login)
                .where(
                		QLogin.login.userId.eq(userId)
                )                
                .fetchOne();

 
        return loginDto;    				
	}
	
}
