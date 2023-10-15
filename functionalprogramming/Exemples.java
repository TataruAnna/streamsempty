package collections.streamsempty.functionalprogramming;

import java.util.function.*;

public class Exemples {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Boolean> isDivisible = (x,y) -> x % y == 0; //am definit functia, nu am apelat-o
        System.out.println(isDivisible.apply(4,2));

        Function<String, Integer> returnLength = s -> s.length();
        System.out.println(returnLength.apply("test"));

        RadioBroadcast digiFM = message -> System.out.println("esti la digi fM " + message); // imi definesc functia
        RadioBroadcast kissFM = message -> System.out.println("esti la kiss fM " + message); // imi definesc functia

        digiFM.play(" 407 Hz"); // apelez functia ca sa execut functionalitatile
        kissFM.play(" 507 Hz"); // apelez functia ca sa execut functionalitatile

        Calculator sum = (a,b) -> a+b;
        System.out.println(sum.operation(5,4));

        Calculator calculator = new Calculator() { //se numeste clasa anonima pentru ca am facut clasa interfata si am definit aici metoda
            @Override
            public int operation(int a, int b) {
                return a+b;
            }
        };
        calculator.operation(5,4);
        printResultOfLambda(returnLength);
        printResultOfLambda(s->s.length()); // se poate renunta la variabila si sa bagam direct functia ca si parametru

        printResultOfLambda(s->{  // la aceasi functie ii putem spune sa faca altceva cu parametru de intrare, atata timp cat respectam ce iese
            int count = 0;
            for(Character c: s.toCharArray()){
                if(Character.isDigit(c)){
                    count++;
                }
            }
            return count;
        });

        //functions
        Function<String, Integer> converter = s -> Integer.parseInt(s);
        System.out.println(converter.apply("2003"));

        //operators - fac o modificare pe un obiect generic <t> il modifica intr-un fel
        UnaryOperator<Integer> multiplier = x -> x*100;
        System.out.println(multiplier.apply(2));

        // operator specific pentru integer
        IntUnaryOperator multiplier2 = x -> x*200;
        System.out.println(multiplier2.applyAsInt(2));

        // operator care primeste doua generice de acelasi fel <t> <t>(string-uri) si iasa tot acelasi lucru <t> string
        BinaryOperator<String> concatener = (s1,s2) -> s1+s2;
        System.out.println(concatener.apply("abc", "def"));

        //predicate - intra ceva generic <T> si iese Boolean
        Predicate<Character> isDigit = c -> Character.isDigit(c);
        System.out.println(isDigit.test('h'));

        // suppliers - nu intra nimic ca si parametru dar returneaza ceva
        Supplier<String> stringSupplier = () -> "hello supplier";
        System.out.println(stringSupplier.get());

        //consumers - intra ceva, consuma, dar nu da nimic inapoi
        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("hello consumer");

        BiConsumer<String, String> greeter = (s1,s2) -> System.out.println(s1+s2);
        greeter.accept("hello ","world");






    }
    private static void printResultOfLambda(Function<String,Integer> function){
        System.out.println(function.apply("happy new year 2024"));
    }

}
