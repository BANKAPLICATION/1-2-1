package services;

import com.rm.toolkit.onetoone.dtos.UserInfo;

public interface UserService {
  UserInfo getUser(Long id);

  String getEmailUser(Long id);

  Long getCountOfUsersByRM(Long id);
}
