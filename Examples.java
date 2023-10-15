package collections.streamsempty;

import java.util.List;
import java.util.stream.Collectors;

public class Examples {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,4,5,7,6,2,9,7,8);
        //stream-ul e o banda, putem face operatii pe aceasta
        long countNumbers = numbers.stream()
                .filter(number -> number>5)
                .count();
        System.out.println(countNumbers);

        List<String> companies = List.of("Google","Amazon", "Samsung", "GOOGLE", "amazon", "Oracle");

        companies.stream()
                .map(company -> company.toUpperCase())
                .distinct()
                .forEach(company -> System.out.println(company)); // operatie finala

        List<String> newList = companies.stream()
                .map(company -> company.toUpperCase())
                .distinct()
                .collect(Collectors.toList()); //operatie finala

        System.out.println(newList);

    }
}
