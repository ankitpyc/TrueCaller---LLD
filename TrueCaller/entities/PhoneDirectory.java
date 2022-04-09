package TrueCaller.entities;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

class ContactNode {
  public Character character;
  public Boolean isEndNode;
  public User user;
  public ContactNode contactNodes[];

  public ContactNode(Character c) {
    this.character = c;
    this.isEndNode = false;
    this.user = null;
    this.contactNodes = new ContactNode[26];
    for (ContactNode contactNodes : contactNodes) {
      contactNodes = null;
    }
  }
}

@Slf4j
public class PhoneDirectory {
  public static PhoneDirectory phoneDirectory = null;
  private ContactNode rootNode = null;

  public PhoneDirectory() {
    rootNode = new ContactNode('*');
  }

  public void addContact(String contactName, User user) {
    ContactNode dummyRoot = rootNode;
    for (Character c : contactName.toCharArray()) {
      int index = c - 'a';
      if (dummyRoot.contactNodes[index] == null) dummyRoot.contactNodes[index] = new ContactNode(c);
      dummyRoot = dummyRoot.contactNodes[index];
    }
    dummyRoot.isEndNode = true;
    dummyRoot.user = user;
    log.info("Added new User : userId  : {} |||  name :  {}", dummyRoot.user.getName());
  }

  public void SearchContact(String contactName, User user) {
    ContactNode dummyRoot = rootNode;
    for (Character c : contactName.toCharArray()) {
      int index = c - 'a';
      if (dummyRoot.contactNodes[index] == null) {
        log.info("Contact not found  {} ",contactName);
        return;
      }
      dummyRoot = dummyRoot.contactNodes[index];
    }
    dummyRoot.isEndNode = true;
    dummyRoot.user = user;
    log.info("Added new User : userId  : {} |||  name :  {}", dummyRoot.user.getName());
  }

  public List<User> getContact(String contactName, User user) {
    ContactNode dummyRoot = rootNode;
    List<User> contactDetails = new ArrayList<>();
    for (Character c : contactName.toCharArray()) {
      int index = c - 'a';
      if (dummyRoot.contactNodes[index] == null) {
        return contactDetails;
      }
      dummyRoot = dummyRoot.contactNodes[index];
    }
    return contactDetails;
  }
}
