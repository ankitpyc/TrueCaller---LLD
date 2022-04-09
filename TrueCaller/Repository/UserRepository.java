package TrueCaller.Repository;

import TrueCaller.entities.User;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {

  private static Map<String, User> userMap;
  private static UserRepository userRepository = null;

  private UserRepository() {
    userMap = new HashMap<>();
  }

  public static Map<String, User> getUser() {
    if (userRepository == null) userRepository = new UserRepository();
    return userMap;
  }
}
