package org.example;

import org.example.dto.Car;
import org.example.dto.RequestWrapperDto;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "userservice", url = "http://localhost:8888")
public interface UserClient {

  @RequestMapping(method = RequestMethod.POST, path = "/user-service/users")
  IdObject createUser(@RequestBody User user);

  @RequestMapping(method = RequestMethod.POST, path = "/user-service/users")
  IdObject createUser(@RequestBody User user, @RequestHeader Map<String,String> headers);

  @RequestMapping(method = RequestMethod.POST, path = "/user-service/users")
  IdObject createUser(@RequestBody RequestWrapperDto<User> user, @RequestHeader Map<String,String> headers);

  @RequestMapping(method = RequestMethod.POST, path = "/user-service/car")
  IdObject createCar(@RequestBody RequestWrapperDto<Car> user, @RequestHeader Map<String,String> headers);
}