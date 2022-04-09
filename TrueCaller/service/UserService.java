package TrueCaller.service;

import TrueCaller.Repository.SpamRepository;
import TrueCaller.Repository.UserRepository;
import TrueCaller.entities.PhoneDirectory;
import TrueCaller.entities.User;
import TrueCaller.enums.ActivationStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
  public void addUser(String name, String phoneNumber, String phone) {
    User newUser =
        User.builder()
            .userId(UUID.randomUUID().toString())
            .status(ActivationStatus.ACTIVE)
            .phoneNumber(phoneNumber)
            .BlockedList(new HashMap<>())
            .contacts(new ArrayList<>())
            .phoneDirectory(new PhoneDirectory())
            .name(name)
            .build();
    saveUser(newUser);
  }

  private void saveUser(User user) {
    UserRepository.getUser().put(user.getUserId(), user);
  }

  private User getUser(String userId) {
    return UserRepository.getUser().get(userId);
  }

  public void addContacts(User user, List<User> contacts) {
    User auser = getUser(user.getUserId());
    PhoneDirectory phoneDirectory =
        UserRepository.getUser().get(user.getUserId()).getPhoneDirectory();
    phoneDirectory.addContact(contacts.get(0).getName(), user);
    auser.setContacts(contacts);
    saveUser(auser);
  }

  public void addContacts(User user, User contacts) {
    User auser = getUser(user.getUserId());
    auser.getContacts().add(contacts);
    saveUser(auser);
  }

  public void addToSpam(User currUser, User spamUser) {
    SpamRepository.getSpamList().put(spamUser.getUserId(), spamUser);
    log.info("Added to spam number :  {}", spamUser.getPhoneNumber());
  }

  public void blockNumber(User currUser, User spamUser) {
    User user = getUser(currUser.getUserId());
    user.getBlockedList().put(spamUser.getUserId(), spamUser);
    saveUser(user);
    log.info("Added to spam number :  {}", spamUser.getPhoneNumber());
  }

  public void unblockNumber(User currUser, User spamUser) {
    User user = getUser(currUser.getUserId());
    user.getBlockedList().remove(spamUser.getUserId());
    saveUser(user);
    log.info("Added to spam number :  {}", spamUser.getPhoneNumber());
  }
}
