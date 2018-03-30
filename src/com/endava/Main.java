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
            new Student("Valera", MALE, 39,new Major("History", 45)),
            new Student("Valera", MALE, 30, new Major("Math", 85)),
            new Student("Valera", MALE, 40,new Major("History", 24)),
            new Student("Igor", MALE, 55,new Major("Math", 65)),
            new Student("Sveta", FEMALE, 30,new Major("Math", 68)),
            new Student("Valera", MALE, 40,new Major("Math", 12)));

    public static void main(String args[]) {

        printDelimiterLine();
        System.out.println("Count how many occurrences of each character are in the string");
        charCounting("abcddd"); //Count how many occurrences of each character are in the string

        printDelimiterLine();
        System.out.println("Count how many occurrences of each word are in the string");
        wordCounting(" 1 ;23,. 4 5 1 :1 3 5, "); //1) Count how many occurrences of each word are in the string

        printDelimiterLine() ;
        System.out.println("Users that are > 40 years");
        System.out.println(filteredUsersByAge(USERS)); //2) Write a method that will filter collection of users that are > 40 years

        printDelimiterLine();
        System.out.println("Student Valera with highest score from each Major!");
        System.out.println(searchBestValeraFromAllMajors(STUDENTS)); //3) Write a method that will detect Student Valera with highest score from each Major! (Create class Student and Major for these purposes)

        printDelimiterLine();
        System.out.println("The youngest user");
        System.out.println(getYoungestUser(USERS)); //4) Write a method to extract the youngest user

        printDelimiterLine();
        System.out.println("Sort collection of strings and remove duplicates");
        List<String> list = Arrays.asList("bb","bb","ss","cc","aa");
        System.out.println(sortCollectionAndRemoveDuplicates(list)); //5) Sort collection of strings and remove duplicates
        printDelimiterLine();
    }

    public static void charCounting(String s){
        System.out.println(s.chars()
                            .mapToObj(c -> (char) c)
                            .collect(Collectors.groupingBy(c -> c, Collectors.counting())));
    }

    public static void wordCounting(String s){
        System.out.println(Arrays.stream(s.trim().split("[\\s.,;:]+"))
                                          .collect(Collectors.groupingBy(c -> c, Collectors.counting())));
    }

    public static List<User> filteredUsersByAge(List<User> users){
        return users.stream()
                    .filter(user -> user.getAge() > 40)
                    .collect(Collectors.toList());
    }

    public static Map<String, Optional<Student>> searchBestValeraFromAllMajors(List<Student> students){

      return students.stream()
                .filter(s -> s.getName().equals("Valera"))
                .collect(Collectors.groupingBy(s -> s.getMajor().getName(),Collectors.maxBy(Comparator.comparing(s->s.getMajor().getScore()))));
    }

    public static User getYoungestUser(List<User> users){
        return users.stream()
                    .min(Comparator.comparingInt(User::getAge))
                    .get();
    }

    public static Collection<String> sortCollectionAndRemoveDuplicates(Collection<String> collection){
        return collection.stream()
                         .distinct()
                         .sorted()
                         .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void printDelimiterLine() {
        System.out.println("-------------------------------------------------------");
    }
}
