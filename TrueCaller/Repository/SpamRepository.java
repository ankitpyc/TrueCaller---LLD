package TrueCaller.Repository;

import TrueCaller.entities.User;
import java.util.HashMap;
import java.util.Map;

public class SpamRepository {

  private static Map<String, User> spamMap;

  private static SpamRepository spamRepository = null;

  private SpamRepository() {
    spamMap = new HashMap<>();
  }

  public static Map<String, User> getSpamList() {
    if (spamRepository == null) spamRepository = new SpamRepository();
    return spamMap;
  }
}
