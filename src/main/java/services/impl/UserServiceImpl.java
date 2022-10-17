package services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rm.toolkit.onetoone.dtos.UserInfo;
import com.rm.toolkit.onetoone.services.UserFeignClient;
import com.rm.toolkit.onetoone.services.UserService;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log
public class UserServiceImpl implements UserService {

  private UserFeignClient feignClient;
  private ObjectMapper mapper;

  public UserServiceImpl(UserFeignClient feignClient, ObjectMapper mapper) {
    this.feignClient = feignClient;
    this.mapper = mapper;
  }

  @SneakyThrows
  @Cacheable("users")
  public UserInfo getUser(Long id) {
    ResponseEntity<Object> user = feignClient.getUser(id);
    return mapper.convertValue(user.getBody(), UserInfo.class);
  }

  @Override
  public String getEmailUser(Long id) {
    String email = String.valueOf(feignClient.getEmail(id));
    return email;
  }

  @Override
  public Long getCountOfUsersByRM(Long id) {
    return feignClient.getCountOfUsersByRM(id);
  }
}
