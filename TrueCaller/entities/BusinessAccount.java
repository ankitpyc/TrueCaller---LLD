package TrueCaller.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BusinessAccount extends User {
  private String BusinessName;
  private Address address;
}
