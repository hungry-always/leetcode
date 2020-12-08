package demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.function.*;

public class Test1 {
    @Test
    public void test() {
        Function<String, Person> function1 = Person::new;
        System.out.println(function1);
        Function<String, Person> function2 = name -> new Person(name);
        System.out.println(function2.apply("af").name);
        System.out.println(function1.apply("af").name);

    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Person{
    String name;
    String age;

    public Person(String name) {
        this.name = name;
    }

}
