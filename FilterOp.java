package collections.streamsempty;

import collections.streamsempty.helperclasses.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOp {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(12);
        list1.add(23);
        list1.add(45);
        list1.add(6);
        //1. printeaza numerele din lista care sunt mai mari decat 10

        list1.stream()
                .filter(number -> number>10)
                .forEach(number -> System.out.println(number));

        List<String> programmingLanguages = Arrays.asList("Java", "", "scala", "Kotlin", "", "clojure");
        //2. printeaza cate string-uri din lista care incep cu litera mare si care nu sunt goale

        long countLang = programmingLanguages.stream()
                .filter(lang -> lang.length()>0)
                .filter(lang -> Character.isUpperCase(lang.charAt(0)))
                .count();
        System.out.println(countLang);

        long countLang2 = programmingLanguages.stream()
                .filter(lang -> lang.length()>0 && Character.isUpperCase(lang.charAt(0))) // se poate pune o singura linie de cod dar e mai greu de citit
                .count();

        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23, "USA"));
        list.add(new Person("Joe", 18, "USA"));
        list.add(new Person("Ryan", 54, "USA"));
        list.add(new Person("Iyan", 5, "USA"));
        list.add(new Person("Ray", 63, "USA"));
        //3. printeaza care sunt persoanele active (cu varsta mai mare decat 18 si mai mica decat 60 de ani)
        System.out.println(findActivePersones(list));
    }
    public static List<Person> findActivePersones(List<Person> persons){
        return persons.stream()
                .filter(person -> person.getAge()>18 && person.getAge()<60)
                .collect(Collectors.toList());
    }
}


