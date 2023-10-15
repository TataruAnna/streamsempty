package collections.streamsempty.functionalprogramming;

import java.util.ArrayList;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 23));
        persons.add(new Person("Ana", 60));
        persons.add(new Person("Mihai", 65));

        persons.sort((Person p1, Person p2) -> p1.getAge().compareTo(p2.getAge()) );
        System.out.println(persons);

        for(Person p : persons){
            p.setAge(p.getAge()+1);
        }
        //sau

        persons.forEach(person -> person.setAge(person.getAge()+1));
        System.out.println(persons);



    }
}
