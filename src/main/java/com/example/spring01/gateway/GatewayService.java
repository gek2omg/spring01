package com.example.spring01.gateway;

import com.example.spring01.gateway.dto.GatewayListDto;
import com.example.spring01.gateway.dto.GatewaySaveDto;
import com.example.spring01.gateway.dto.GatewaySearchCondition;
import com.example.spring01.gateway.entity.Gateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GatewayService {

    private final GatewayRepository gatewayRepository;


    public List<Gateway> getGatewayList() {

        return gatewayRepository.findAll();
    }

    public void save(Gateway gateway) {

        gatewayRepository.save(gateway);
    }

    @Transactional
    public void saveGatewayV1(GatewaySaveDto gatewaySaveDto) {

        Gateway gateway = new Gateway();
        gateway.setIpaddress(gatewaySaveDto.getIpaddress());
        gateway.setPort(gatewaySaveDto.getPort());
        gateway.setRegdate(gatewaySaveDto.getRegdate());

        gatewayRepository.save(gateway);
    }

    public Page<GatewayListDto> searchFindAllV1(GatewaySearchCondition condition, Pageable pageable) {

        return gatewayRepository.searchFindAllV1(condition, pageable);
    }
}