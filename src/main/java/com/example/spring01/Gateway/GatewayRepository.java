package com.example.spring01.Gateway;

import com.example.spring01.Gateway.entity.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayRepository extends JpaRepository<Gateway, Long>,
        QuerydslPredicateExecutor<Gateway>,
        GatewayRepositoryCustom {


}
