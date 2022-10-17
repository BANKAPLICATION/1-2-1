package services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-command-service")
public interface UserFeignClient {

  @GetMapping(path = "/email/{id}")
  String getEmail(@PathVariable(name = "id") Long id);

  @GetMapping(path = "/users/by-id/{id}")
  ResponseEntity<Object> getUser(@PathVariable(name = "id") Long id);

  @GetMapping(path = "/users/by-RM/{id}")
  Long getCountOfUsersByRM(@PathVariable("id") Long id);
}
