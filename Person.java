package project.银行;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Person {
    @NonNull private String Name;
    @NonNull private String Age;
    @NonNull private String Gender;

    public Person(){

    }
}
