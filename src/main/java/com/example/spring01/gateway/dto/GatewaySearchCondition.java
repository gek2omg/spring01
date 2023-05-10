package com.example.spring01.gateway.dto;

import lombok.Data;

@Data
public class GatewaySearchCondition {
    private String ipaddress;
    private Integer port;
}
