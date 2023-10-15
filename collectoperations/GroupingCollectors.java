package collections.streamsempty.collectoperations;


import collections.streamsempty.helperclasses.Account;
import collections.streamsempty.helperclasses.Employee;
import collections.streamsempty.helperclasses.Item;
import collections.streamsempty.helperclasses.Status;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingCollectors {
    public static void main(String[] args) {

        List<Account> accounts = List.of(
                new Account(3333, "530012", Status.REMOVED),
                new Account(15000, "771843", Status.ACTIVE),
                new Account(0, "681891", Status.BLOCKED),
                new Account(2000, "681891", Status.ACTIVE)
        );

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000, "USA"));
        employeeList.add(new Employee("Ben", 63, 25000, "China"));
        employeeList.add(new Employee("Dave", 34, 56000, "India"));
        employeeList.add(new Employee("Jodi", 43, 67000, "USA"));
        employeeList.add(new Employee("Ryan", 53, 54000, "China"));

        List<Item> items = Arrays.asList(
                new Item("apple", 10, 9.99),
                new Item("banana", 20, 19.99),
                new Item("orange", 10, 29.99),
                new Item("watermelon", 10, 29.99),
                new Item("papaya", 20, 9.99),
                new Item("apple", 10, 9.99),
                new Item("banana", 10, 19.99),
                new Item("apple", 20, 9.99));

        //1. grupeaza conturile din lista dupa status (adica genereaza o mapa in care cheia este statusul, iar valoarea o lista cu toate conturile care au acel status)

        Map<Status, List<Account>> accountsByStatus = accounts.stream()
                .collect(Collectors.groupingBy(account -> account.getStatus()));

        System.out.println(accountsByStatus);

        //2. grupeaza angajatii din lista dupa tara (adica genereaza o mapa in care cheia este tara, iar valoarea o lista cu toti angajatii din acea tara

        Map<String, List<Employee>> employeesByCountry = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCountry()));

        //3. genereaza o mapa in care cheia este tara, iar valoarea este suma salariilor angajatilor din acea tara)

        Map<String, Integer> sumOfSalariesByCountry = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCountry(), Collectors.summingInt(employee -> employee.getSalary()))); // mai intai colecteaza din lista pentru crearea cheilor si apoi colecteaza pt valoare
        System.out.println(sumOfSalariesByCountry);

        //4. genereaza o mapa in care cheia este tara, iar valoarea este numarul de angajati din acea tara)

        Map<String, Long> numberOfEmployeesByCountry = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getCountry(), Collectors.counting()));
        System.out.println(numberOfEmployeesByCountry);

        //5. genereaza o mapa in care cheia este numele produsului, iar valoarea este numarul de produse cu acel nume care se afla in lista

            Map<String, Long> numberOfProductsByName = items.stream()
                .collect(Collectors.groupingBy(item ->item.getName(), Collectors.counting()));
        System.out.println(numberOfProductsByName);

        //6. genereaza o mapa in care cheia este numele produsului, iar valoarea cantitatea totala a produselor cu acel nume)
        Map<String, Integer> quantityOfProductsByName = items.stream()
                .collect(Collectors.groupingBy(item -> item.getName(), Collectors.summingInt(item -> item.getQty())));
        System.out.println(quantityOfProductsByName);

        //7. genereaza o mapa in care cheia este pretul produsului, iar valoarea este lista de produse cu acel pret
        //adica grupeaza produsele dupa pret

        Map<Double, List<Item>> productsByPrice = items.stream()
                .collect(Collectors.groupingBy(item ->item.getPrice()));
        System.out.println(productsByPrice);
        System.out.println("Products by price: ");
        System.out.println(getProductsByPrice(items));
        System.out.println("Qty of products by name: ");
        System.out.println(getQtyOfProductsByName(items));

        System.out.println("Number of products by name: ");
        System.out.println(getNumberOfProductsByName(items));

        System.out.println("Salaries by country");
        System.out.println(getSalariesByCountry(employeeList));

        System.out.println("employees by country");
        System.out.println(getEmployeesByCountry(employeeList));


    }
    //6. genereaza o mapa in care cheia este numele produsului, iar valoarea cantitatea totala a produselor cu acel nume)
    public static Map<String, Integer> getQtyOfProductsByName(List<Item> items){
        Map<String,Integer> qtyOfProductsByName = new HashMap<>();
        for(Item item: items){
            if(!qtyOfProductsByName.containsKey(item.getName())){
                qtyOfProductsByName.put(item.getName(),item.getQty());
            }
            else{
                qtyOfProductsByName.put(item.getName(), item.getQty()+ qtyOfProductsByName.get(item.getName()));
            }

        }
        return qtyOfProductsByName;
    }

    //5. genereaza o mapa in care cheia este numele produsului, iar valoarea este numarul de produse cu acel nume care se afla in lista

    public static Map<String, Integer> getNumberOfProductsByName (List<Item> items){
        Map<String, Integer> numberOfProductsByName = new HashMap<>();
        for(Item item: items){
            if(!numberOfProductsByName.containsKey(item.getName())){
                numberOfProductsByName.put(item.getName(),1);
            }
            else{
                numberOfProductsByName.put(item.getName(), 1+ numberOfProductsByName.get(item.getName()));
            }
        }
        return numberOfProductsByName;
    }

    public static Map<Double, List<Item>> getProductsByPrice(List<Item> items){
        Map<Double, List<Item>> productsByPrice =new HashMap<>();
        for(Item item: items){
            if(!productsByPrice.containsKey(item.getPrice())){
                List<Item> valueItem = new ArrayList<>();
                valueItem.add(item);
                productsByPrice.put(item.getPrice(), valueItem);
            }
            else{
                productsByPrice.get(item.getPrice()).add(item);
            }
        }
        return productsByPrice;

    }

    //3. genereaza o mapa in care cheia este tara, iar valoarea este suma salariilor angajatilor din acea tara)

    public static Map<String, Integer> getSalariesByCountry(List<Employee> employeeList){
        Map<String, Integer> salariesByCountry = new HashMap<>();

        for(Employee employee: employeeList){
            if(!salariesByCountry.containsKey(employee.getCountry())){
                salariesByCountry.put(employee.getCountry(), employee.getSalary());
            }
            else{
                salariesByCountry.put(employee.getCountry(), employee.getSalary()+ salariesByCountry.get(employee.getCountry()));
            }
        }

        return salariesByCountry;
    }

    //2. grupeaza angajatii din lista dupa tara (adica genereaza o mapa in care cheia este tara, iar valoarea o lista cu toti angajatii din acea tara

    public static Map<String, List<Employee>> getEmployeesByCountry (List<Employee> employeeList){
        Map<String,List<Employee>> employeesByCountry = new HashMap<>();
        for(Employee employee: employeeList){
            if(!employeesByCountry.containsKey(employee.getCountry())){
                List<Employee> listOfEmployees = new ArrayList<>();
                listOfEmployees.add(employee);
                employeesByCountry.put(employee.getCountry(), listOfEmployees);
            }
            else{
                employeesByCountry.get(employee.getCountry()).add(employee); // la tara din mapa mea, pe care o ai deja existenta, adauga angajatul
            }
        }


        return employeesByCountry;
    }


}

