package hello.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok s = new HelloLombok();
        s.setName("hah");
        String name = s.getName();
    }

}
