package com.example.spring01.userTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.spring01.gateway.GatewayRepositoryCustom;
import com.example.spring01.gateway.entity.Gateway;
import com.example.spring01.userTest.dto.LoginListDto;

public interface LoginRepository extends JpaRepository<Gateway, Long>,
        QuerydslPredicateExecutor<Gateway>,
        LoginRepositoryCustom {
	
}
