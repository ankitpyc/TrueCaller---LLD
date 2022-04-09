package TrueCaller;

import TrueCaller.entities.User;
import java.util.List;

public interface UserSearch {

  public List<User> searchUserByName();

  public List<User> searchUserByContactNumber();

}
