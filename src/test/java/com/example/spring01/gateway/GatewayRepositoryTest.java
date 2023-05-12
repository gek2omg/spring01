package com.example.spring01.gateway;

import com.example.spring01.gateway.entity.Gateway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GatewayRepositoryTest {

    @Autowired
    private GatewayRepository gatewayRepository;

    @Test
    public void 게이트웨이등록() {

        List<Integer> port = new ArrayList<>();

        port.add(502);
        port.add(503);
        port.add(504);
        port.add(505);
        port.add(506);
        port.add(507);

        Random random = new Random();


        IntStream.rangeClosed(1, 100).forEach(i -> {

            int randomIndex = random.nextInt(port.size());
            int randomPort = port.get(randomIndex);

            Gateway gateway = Gateway.builder()
                    .ipaddress("192.162.0." + i)
                    .port(randomPort)
                    .regdate(LocalDateTime.now())
                    .build();

            gatewayRepository.save(gateway);
        });
    }
}