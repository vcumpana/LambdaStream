package com.endava;

import com.endava.models.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.endava.models.Gender.FEMALE;
import static com.endava.models.Gender.MALE;

public class Main {

    public static final List<User> USERS = Arrays.asList(new User("Vasea", MALE, 39),
            new User("Sveta", FEMALE, 30),
            new User("Jenea", MALE, 40),
            new User("Igor", MALE, 55),
            new User("Sveta", FEMALE, 30),
            new User("Jenea", MALE, 40));

    public static void main(String args[]) {

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
//        printDelimiterLine();
        charCounting("abcddd");
        wordCounting(" 1 2 3 4 5 1 1 3 5 ");
        System.out.println(filteredUsersByAge(USERS));
    }

    public static void charCounting(String s){
        System.out.println(s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting())));
    }

    public static void wordCounting(String s){
        System.out.println(Arrays.stream(s.trim().split(" ")).collect(Collectors.groupingBy(c -> c, Collectors.counting())));
    }

    public static List<User> filteredUsersByAge(List<User> users){
        return users.stream().filter(user -> user.getAge() > 40).collect(Collectors.toList());
    }

    public static void printDelimiterLine() {
        System.out.println("\n-------------------------------------------------------\n");
    }
}
