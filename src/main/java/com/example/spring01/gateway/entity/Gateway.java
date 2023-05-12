package com.example.spring01.gateway.entity;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Builder
@RequiredArgsConstructor
@Table(name = "tb_gateway")
public class Gateway {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ipaddress;
    private Integer port;
    private LocalDateTime regdate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }

    public Gateway(Long id, String ipaddress, Integer port, LocalDateTime regdate) {
        this.id = id;
        this.ipaddress = ipaddress;
        this.port = port;
        this.regdate = regdate;
    }

}
