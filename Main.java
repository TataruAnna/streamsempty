package collections.streamsempty;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //1 ce este un stream
        //afiseaza cate numere din lista sunt mai mari decat 5
        //versiunea clasica
        List<Integer> numbers = List.of(1, 4, 7, 6, 2, 9, 7, 8);
        int count = 0;
        for (Integer number : numbers) {
            if (number > 5) {
                count++;
            }
        }
        System.out.println(count);

        //versiunea care foloseste stream-uri
        long countNumbers = numbers.stream()
                .filter(number -> number > 5)
                .count();
        System.out.println(countNumbers); //5


        //afiseaza companiile din lista in mod unic, scrise cu litere mari
        List<String> companies = List.of(
                "Google", "Amazon", "Samsung",
                "GOOGLE", "amazon", "Oracle"
        );

        companies.stream()
                .map(s -> s.toUpperCase()) // transforma fiecare String in litere mari
                .distinct() // pastreaza doar elementele unice
                .forEach(c -> System.out.println(c)); // afiseaza fiecare companie


        //2. filter

        //3. filter cu collect

        //4. map

        //5. flatmap

        //6. reduce

        //7. collect

        //8. grouping and aggregatin collectors

        //9. matching

        //10. finding



    }
}
