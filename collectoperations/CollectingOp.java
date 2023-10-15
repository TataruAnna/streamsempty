package collections.streamsempty.collectoperations;


import collections.streamsempty.helperclasses.Account;
import collections.streamsempty.helperclasses.Employee;
import collections.streamsempty.helperclasses.Status;

import java.util.*;
import java.util.stream.Collectors;

public class CollectingOp {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex" , 23, 23000, "USA"));
        employeeList.add(new Employee("Ben" , 63, 25000, "India"));
        employeeList.add(new Employee("Dave" , 34, 56000, "Bhutan"));
        employeeList.add(new Employee("Jodi" , 43, 67000, "China"));
        employeeList.add(new Employee("Ryan" , 53, 54000, "Libya"));

        //1. returneaza o lista cu numele tututor angajatilor din lista de angajati

        List<String> employeesNames = employeeList.stream()
                .map(employee -> employee.getName())
                .collect(Collectors.toList());
        System.out.println(employeesNames);

        //2. returneaza un set cu tarile tututor angajatilor din lista de angajati

        Set<String> employeesCountries = employeeList.stream()
                .map(employee -> employee.getCountry())
                .collect(Collectors.toSet());
        System.out.println(employeesCountries);

        //3. returneaza o mapa in care cheia este fiecare nume de angajat din lista, iar valoarea este tara angajatului

        Map<String, String> employeesAndCountries = employeeList.stream()
                .collect(Collectors.toMap(employee -> employee.getName(), employee -> employee.getCountry()));
        System.out.println(employeesAndCountries);


        //4. returneaza o lista cu numerele de cont ale tuturor conturilor din lista de conturi

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(3000, "3451231231", Status.ACTIVE));
        accounts.add(new Account(4000, "1233451233", Status.ACTIVE));
        accounts.add(new Account(5000, "1287429134", Status.ACTIVE));
        accounts.add(new Account(6000, "4567831246", Status.ACTIVE));
        accounts.add(new Account(7000, "3467851293", Status.ACTIVE));

        List<String> accountNumbers = accounts.stream()
                .map(account -> account.getNumber())
                .collect(Collectors.toList());

        //5. returneaza suma soldurilor tuturor conturilor din lista de conturi

        Optional<Integer> sumOptional = accounts.stream()
                .map(account -> account.getBalance())
                .reduce((sum,balance)-> sum+balance);
        System.out.println(sumOptional.get());

        //sau
        accounts.stream()
                .collect(Collectors.summingInt(account -> account.getBalance()));  //se face si .map si . sum in acelasi timp

        //6. returneaza o lista cu soldurile conturilor din lista de conturi



    }

    public static Map<String, String> getEmployeesAndCountries(List<Employee> employeeList){
        Map<String, String> employeesAndCountries = new HashMap<>();
        for(Employee employee: employeeList){
            employeesAndCountries.put(employee.getName(), employee.getCountry());
        }
        return employeesAndCountries;
    }

}

