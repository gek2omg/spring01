package com.example.spring01.gateway;

import com.example.spring01.gateway.dto.GatewayListDto;
import com.example.spring01.gateway.dto.GatewaySearchCondition;
import com.example.spring01.gateway.dto.QGatewayListDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import java.util.List;

import static com.example.spring01.gateway.entity.QGateway.*;
import static com.querydsl.core.types.ExpressionUtils.count;
import static org.springframework.util.StringUtils.hasText;


public class GatewayRepositoryImpl implements GatewayRepositoryCustom {
    private final JPAQueryFactory queryFactory;


    public GatewayRepositoryImpl(EntityManager em) {

        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<GatewayListDto> searchFindAllV1(GatewaySearchCondition condition, Pageable pageable) {

        List<GatewayListDto> content = queryFactory
                .select(new QGatewayListDto(
                        gateway.id,
                        gateway.ipaddress,
                        gateway.port,
                        gateway.regdate))
                .from(gateway)
                .where(
                        searchFindAllPredicateV1(condition)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(count(gateway.id))
                .from(gateway)
                .where(
                        searchFindAllPredicateV1(condition)
                )
                .fetch().get(0);


        return new PageImpl<>(content, pageable, total);
    }


    private BooleanBuilder searchFindAllPredicateV1(GatewaySearchCondition condition) {
        return new BooleanBuilder()
                .and(condIpaddress(condition.getIpaddress()));


    }


    private Predicate condIpaddress(String ipaddress) {
        BooleanBuilder builder = new BooleanBuilder();

        if(hasText(ipaddress)) {
            builder.and(gateway.ipaddress.like("%"+ipaddress+"%"));
        }

        return builder;

    }
}
