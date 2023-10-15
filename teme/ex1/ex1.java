package collections.streamsempty.teme.ex1;

import java.util.function.Function;

public class ex1 {
    public static void main(String[] args) {


        everySecondChar2(s->{
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));

                }
            }
            return returnVal.toString();

        });

        Function<String, String> function1 = s-> {  //aici definesc functia
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));

                }
            }
            return returnVal.toString();
        };
        System.out.println(function1.apply("1234567890")); //aici apelez functia

    }

    //1. Rescrie urmatoarea metoda ca o expresie lambda:
    public static String everySecondChar(String source) {
                StringBuilder returnVal = new StringBuilder();
                for (int i = 0; i < source.length(); i++) {
                    if (i % 2 == 1) {
                        returnVal.append(source.charAt(i));
                    }
                }
                return returnVal.toString();
           }

    public static void everySecondChar2(Function<String, String> function ){
        System.out.println(function.apply("1234567890"));
    }



    //Apoi rescrie functia clasica ca o functie lambda.
    //
    //Apoi executa acea functie lambda si paseaza-i ca parametru: "1234567890".
    //Apoi creeaza o noua functie clasica numita everySecondCharacter() care accepta ca si parametru o functie lambda si un alt String.
    // Executa functia lamba in cadrul metodei everySecondCharacter(),
    // si apeleaza everySecondCharacter() pasandu-i functia lambda creata ca prim parametru si string-ul "1234567890" ca al doilea parametru.

}
