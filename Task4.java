import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Task4 {
    public static void main(){

        Scanner scanner = new Scanner(System.in);

        try {
            Student s1 = new Student(101, "Alice Smith", 18, "Computer Science");
            System.out.println("Created: " + s1);
        } catch (AgeNotWithinRangeException | NameNotValidException e) {
            System.err.println("Error creating student: " + e.getMessage());
        }

        scanner.close();
    }
}

public class Student {
    private int rollNo;
    private String name;
    private int age;
    private String course;

    public Student(int rollNo, String name, int age, String course)
            throws AgeNotWithinRangeException, NameNotValidException {

        if (age < 15 || age > 21) {
            throw new AgeNotWithinRangeException("Age must be between 15 and 21. Provided age: " + age);
        }
        this.age = age;

        Pattern p = Pattern.compile("^[a-zA-Z\\s]+$");
        Matcher m = p.matcher(name);
        if (!m.matches()) {
            throw new NameNotValidException("Name can only contain letters and spaces. Provided name: '" + name + "'");
        }
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;

        System.out.println("Student object created successfully for: " + this.name);
    }

    // --- Getter Methods ---
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student [Roll No: " + rollNo + ", Name: " + name + ", Age: " + age + ", Course: " + course + "]";
    }
}

public class AgeNotWithinRangeException extends Exception {
    public AgeNotWithinRangeException(String message) {
        super(message);
    }
}

public class NameNotValidException extends Exception {
    public NameNotValidException(String message) {
        super(message);
    }
}

/// Task 2

public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Voter {
    private String voterId;
    private String name;
    private int age;

    public Voter(String voterId, String name, int age) throws InvalidAgeException {
        if (age < 18) {

            throw new InvalidAgeException("Invalid age for voter");
        }

        this.voterId = voterId;
        this.name = name;
        this.age = age;
        System.out.println("Voter created successfully: " + name + " (Age: " + age + ")");
    }

    public String getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Voter [Voter ID=" + voterId + ", Name=" + name + ", Age=" + age + "]";
    }
}

public class VoterAppChecked {
    public static void main(String[] args) {
        try {
            Voter voter1 = new Voter("V001", "Alice", 25);
            System.out.println(voter1);
        } catch (InvalidAgeException e) {
            System.err.println("Error creating voter: " + e.getMessage());
        }
    }}

// Task 3

public staic void Task3() {
    String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    Scanner scanner = new Scanner(System.in);
    int dayIndex = -1;

    try {
        System.out.print("Enter a day position (0-6): ");
        dayIndex = scanner.nextInt();

        if (dayIndex >= 0 && dayIndex < weekdays.length) {
            System.out.println("The day name is: " + weekdays[dayIndex]);
        } else {
            System.out.println("Error: Day position must be between 0 and 6 (inclusive).");
        }

    } catch (InputMismatchException e) {
        System.err.println("Error: Invalid input. Please enter a whole number for the day position.");
    } catch (Exception e) {
        System.err.println("An unexpected error occurred: " + e.getMessage());
    } finally {
        scanner.close();
        System.out.println("Program finished.");
    }
}
}

// task 4
import java.util.HashMap;
import java.util.Map;

public void StudentGrades(){
    private Map<String, Integer> studentGrades;

    public StudentGrades() {
        this.studentGrades = new HashMap<>();
        System.out.println("Student grade system initialized.");
    }

    public void addStudent(String name, int grade) {
        if (studentGrades.containsKey(name)) {
            System.out.println("Updating grade for " + name + ": " + studentGrades.get(name) + " -> " + grade);
        } else {
            System.out.println("Adding new student: " + name);
        }
        studentGrades.put(name, grade);
    }
}

// task 5

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack{
    private deque<Integer> stack;

    public MyIntegerStack() {
        this.stack = new ArrayDeque<>();
        System.out.println("MyIntegerStack initialized.");
    }

    public void push(Integer element) {
        stack.push(element);
        System.out.println("Pushed: " + element + " | Current stack: " + stack);
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop element.");
        }
        Integer poppedElement = stack.pop();
        System.out.println("Popped: " + poppedElement + " | Current stack: " + stack);
        return poppedElement;
    }

    public Integer peek() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty. No element to peek.");
        }
        return stack.peek(); // Retrieves, but does not remove, the head of this deque (top of stack)
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}