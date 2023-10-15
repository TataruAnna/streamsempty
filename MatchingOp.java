package collections.streamsempty;

import collections.streamsempty.helperclasses.Person;

import java.util.ArrayList;
import java.util.List;

public class MatchingOp {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23,"India"));
        list.add(new Person("Joe", 18,"USA"));
        list.add(new Person("Ryan", 54,"Canada"));
        list.add(new Person("Iyan", 5,"India"));
        list.add(new Person("Ray", 63,"China"));
        //1. verifica daca lista de persoana contine cel putin o persoana din Canada

        boolean containsCanadians = list.stream()
                .anyMatch(person -> person.getCountry().equals("Canada"));
        System.out.println(containsCanadians);
        //2. verifica daca toate persoanele din lista sunt din Canada

        boolean areAllCanadians = list.stream()
                .allMatch(person -> person.getCountry().equals("Canada"));
        System.out.println(areAllCanadians);
        //3. verifica daca nu exista nicio persoana din Rusia

        boolean anyRussians = list.stream()
                .noneMatch(person-> person.getCountry().equals("Rusia"));
        System.out.println(anyRussians);

    }
}

