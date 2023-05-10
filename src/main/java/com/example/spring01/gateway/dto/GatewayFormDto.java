package com.example.spring01.gateway.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class GatewayFormDto {
    @NotEmpty(message = "IP주소는 필수 입력입니다.")
    private String ipaddress;
    @NotNull(message = "포트번호는 필수 입력입니다.")
    private Integer port;
    private LocalDateTime regdate;


    // 기본 생성자
    public GatewayFormDto() {
        this.regdate = LocalDateTime.now(); // 현재 시간으로 초기화
    }

    // 모든 필드를 포함한 생성자
    public GatewayFormDto(String ipaddress, Integer port, LocalDateTime regdate) {
        this.ipaddress = ipaddress;
        this.port = port;
        this.regdate = regdate;
    }

}
