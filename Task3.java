import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task3 {

    public static void main(String[] args) {
        // Q1: Convert list of Strings to uppercase using map()


        Stream<String> names = Stream.of("aBc", "d", "ef");
        List<String> upperCaseNames = names.map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Original names: [aBc, d, ef]");
        System.out.println("Uppercase names: " + upperCaseNames);
        System.out.println();


    }

    public void task2(){
        // Q2: Check for non-empty strings in a list
        List<String> listStrings = Arrays.asList("abc", "", "bc", "efg", "abed", "", "jkl");
        System.out.println("Original list: " + listStrings);
        System.out.print("Non-empty strings: ");
        listStrings.stream()
                .filter(s -> !s.isEmpty())
                .forEach(s -> System.out.print("\"" + s + "\" "));
        System.out.println("\n");


    }


    public void task3(){
        // Q3: Filter students whose names start with "A"
        List<String> allStudents = new ArrayList<>();
        allStudents.add("Alice");
        allStudents.add("Bob");
        allStudents.add("Anna");
        allStudents.add("Charlie");
        allStudents.add("Aaron");

        List<String> studentsForGift = allStudents.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Students whose names start with 'A' (for gifts): " + studentsForGift);
        System.out.println();


    }

    public void task4(){
        // Q4: Calculate age from birthdate

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birthdate (yyyy-mm-dd): ");
        String birthdateString = scanner.nextLine();

        try {
            LocalDate birthdate = LocalDate.parse(birthdateString);
            LocalDate currentDate = LocalDate.now();

            Period age = Period.between(birthdate, currentDate);

            System.out.println("Your age is: " + age.getYears() + " years, "
                    + age.getMonths() + " months, and "
                    + age.getDays() + " days.");
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Invalid date format. Please use yyyy-mm-dd.");
        } finally {
            scanner.close();
        }
    }
}