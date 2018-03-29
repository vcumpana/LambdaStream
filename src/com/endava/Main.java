package com.endava;

import com.endava.models.Major;
import com.endava.models.Student;
import com.endava.models.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.endava.models.Gender.FEMALE;
import static com.endava.models.Gender.MALE;

public class Main {

    public static final List<User> USERS = Arrays.asList(new User("Vasea", MALE, 39),
            new User("Aliona", FEMALE, 30),
            new User("Jenea", MALE, 40),
            new User("Igor", MALE, 55),
            new User("Sveta", FEMALE, 30),
            new User("Jenea", MALE, 40));

    public static final List<Student> STUDENTS = Arrays.asList(
            new Student("Vasea", MALE, 39,new Major("Math", 45.00),  new Major("History", 65.00)),
            new Student("Aliona", FEMALE, 30, new Major("Math", 85.00),  new Major("History", 56.00)),
            new Student("Valera", MALE, 40,new Major("Math", 24.00),  new Major("History", 75.00)),
            new Student("Igor", MALE, 55,new Major("Math", 65.00),  new Major("History", 86.00)),
            new Student("Sveta", FEMALE, 30,new Major("Math", 68.00),  new Major("History", 24.00)),
            new Student("Valera", MALE, 40,new Major("Math", 12.00),  new Major("History", 98.00)));
    public static void searchBestValeraFromAllMajors(){
        System.out.println(STUDENTS.stream().filter(s -> s.getName().equals("Valera"))
                .collect(Collectors.groupingBy(s -> Arrays.stream(s.getMajors()).collect(Collectors.toMap(m->m.getName(), m->m.getScore())))));
    }
    public static void main(String args[]) {

        searchBestValeraFromAllMajors();
//        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8)
//                .stream()
//                .filter(num -> num % 2 == 0)
//                .forEach(System.out::println);
//
//        printDelimiterLine();
//
//        USERS.stream()
//                .parallel()
//                .map(User::getName)
//                .filter(string -> string.startsWith("A"))
//                .forEach(System.out::println);
//
//        printDelimiterLine();
//
//        System.out.println(USERS
//                .stream()
//                .collect(Collectors.groupingBy(User::getGender)));
//        printDelimiterLine();
//
//        System.out.println(Stream.of(new User("Vasea", MALE, 39),
//                new User("Sveta", FEMALE, 30),
//                new User("Jenea", MALE, 40))
//                .map(User::getName)
//                .collect(Collectors.joining(" *** ")));
//
//        printDelimiterLine();
//
//        System.out.println(Stream.of(new User("Vasea", MALE, 39),
//                new User("Sveta", FEMALE, 30),
//                new User("Jenea", MALE, 40))
//                .collect(Collectors.groupingBy(User::getGender, Collectors.counting())));
//
//        printDelimiterLine();
//
//        System.out.println(
//                USERS.stream()
//                        .filter(user -> user.getGender() == MALE)
//                        .sorted(Comparator.comparing(User::getAge))
//                        .collect(Collectors.toSet()));
//
        printDelimiterLine();
        charCounting("abcddd");
        printDelimiterLine();
        wordCounting(" 1 23 4 5 1 1 3 5 ");
        printDelimiterLine();
        System.out.println(filteredUsersByAge(USERS));
        printDelimiterLine();
        System.out.println(getYoungestUser(USERS));
        printDelimiterLine();
        List<String> list = Arrays.asList("bb","bb","ss","cc","aa");
        System.out.println(sortCollectionAndRemoveDuplicates(list));
        printDelimiterLine();
    }

    public static void charCounting(String s){
        System.out.println(s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting())));
    }

    public static void wordCounting(String s){
        System.out.println(Arrays.stream(s.trim().split("[\\s]")).collect(Collectors.groupingBy(c -> c, Collectors.counting())));
    }

    public static List<User> filteredUsersByAge(List<User> users){
        return users.stream().filter(user -> user.getAge() > 40).collect(Collectors.toList());
    }

    public static User getYoungestUser(List<User> users){
        return users.stream().min(Comparator.comparingInt(User::getAge)).get();
    }

    public static Collection<String> sortCollectionAndRemoveDuplicates(Collection<String> collection){
        return collection.stream().distinct().sorted().collect(Collectors.toCollection(ArrayList::new));
    }

    public static void printDelimiterLine() {
        System.out.println("-------------------------------------------------------");
    }
}
