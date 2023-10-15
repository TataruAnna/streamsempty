package collections.streamsempty.functionalprogramming;

public class WellWisher {
    public static void wish(Greeting greeting){
        greeting.sayHello();
    }

    public static void main(String[] args) {
        Greeting indianGreeting = new IndianGreeting();
        wish(indianGreeting);

        Greeting englishGreeting = new EnglishGreeting();
        wish(englishGreeting);

        wish(new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("ceau");
            }
        });

        wish(() -> System.out.println("hello2"));
    }

}
