package com.example.evsa_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//어노테이션 통해 Auto Configuration에서 DataSource 관련 설정 로드를 WAS 구동시 하지 않도록 exclude
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EvsaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvsaBackendApplication.class, args);
    }

}
