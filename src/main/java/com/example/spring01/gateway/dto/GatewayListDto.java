package com.example.spring01.gateway.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GatewayListDto {
    private Long id;
    private String ipaddress;
    private Integer port;
    private LocalDateTime regdate;

    @QueryProjection
    public GatewayListDto(Long id, String ipaddress, Integer port, LocalDateTime regdate) {
        this.id = id;
        this.ipaddress = ipaddress;
        this.port = port;
        this.regdate = regdate;
    }
}
