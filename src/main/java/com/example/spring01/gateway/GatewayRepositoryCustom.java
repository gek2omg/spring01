package com.example.spring01.gateway;

import com.example.spring01.gateway.dto.GatewayListDto;
import com.example.spring01.gateway.dto.GatewaySearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GatewayRepositoryCustom {

    Page<GatewayListDto> searchFindAllV1(GatewaySearchCondition condition, Pageable pageable);
    Page<GatewayListDto> searchFindAllV2(GatewaySearchCondition condition, Pageable pageable);
    Page<GatewayListDto> searchFindAllV3(GatewaySearchCondition condition, Pageable pageable);
    Page<GatewayListDto> searchFindAllV4(GatewaySearchCondition condition, Pageable pageable);
}
