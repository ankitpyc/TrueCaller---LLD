package TrueCaller.entities;

import TrueCaller.enums.AccountType;
import TrueCaller.enums.ActivationStatus;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
  private String userId;
  private String name;
  private String phoneNumber;
  private ActivationStatus status;
  private List<User> contacts;
  private AccountType accountType;
  private Map<String,User> BlockedList;
  private PhoneDirectory phoneDirectory;
}
