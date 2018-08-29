package project.银行;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
public class Customer extends Person{
      private String Cardnum;
      private String Password;
      private BigDecimal Money;

     public Customer(){
     }

     public Customer(String Name, String Age, String Gender, String cardnum,String password,BigDecimal money) {
          super(Name, Age, Gender);
          this.Cardnum=cardnum;
          this.Password=password;
          this.Money=money;
     }
}
