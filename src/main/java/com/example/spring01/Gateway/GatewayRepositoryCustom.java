package com.example.spring01.Gateway;

import com.example.spring01.Gateway.dto.GatewayListDto;
import com.example.spring01.Gateway.dto.GatewaySearchCondition;
import com.example.spring01.Gateway.entity.Gateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GatewayRepositoryCustom {

    Page<GatewayListDto> searchFindAllV1(GatewaySearchCondition condition, Pageable pageable);
}
