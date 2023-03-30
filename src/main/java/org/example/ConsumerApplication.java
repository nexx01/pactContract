package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableFeignClients
//@RibbonClient(name = "userservice", configuration = RibbonConfiguration.class)
  @EnableReactiveFeignClients("org.example")
public class ConsumerApplication {
  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class);
  }


}