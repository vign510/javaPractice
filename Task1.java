import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task1 {

    //Task 1.1 - Print numbers form 10 - 50 using for loop
    public void Task1_1(String[] args) {
        for (int i = 10; i <= 50; i++) {
            System.out.println(i);
        }
    }


    //Task 1.2 - Print numbers from 10 - 50 using while loop

    public void task1_2() {
        i = 10;

        while (i <= 50) {
            System.out.println(i);
            i = i++;
        }

    }


    // Task 2 - write a program that finds if a given number is negative or positive

    public void get_negative_or_positive() {
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();

        if (number > 0) {
            System.out.println(number + " is positive.");
        } else if (number < 0) {
            System.out.println(number + " is negative.");
        } else {
            System.out.println(number + " is zero.");
        }

        scanner.close();
    }


    // Task 3 - write a programe that reverses the number using lops
    public void reverse_number() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer to reverse: ");
        StringBuilder reverse_string = new StringBuilder();
        int number = scanner.nextInt();

        if (number < 0) {
            String number_to_string = String.valueOf(number);
            // Split the string into numbers
            String[] parts = number_to_string.split("");

            // converting to arraylist to reverse the list
            List<String> partsList = Arrays.asList(parts);
            Collections.reverse(partsList);

            for (String part : partsList) {
                reverse_string.append(part).append(" ");
            }

        }
    }

    // task 4 - Find the smallest number among the numbers using loops

    public static void get_smallest_number(){
        List<Integer> myNumbers = new ArrayList<>(Arrays.asList(10, 25, 7, 100, 3, 50, 1)); // Example list

        int lowestNumber =0;

        for (int i = 1; i < myNumbers.size(); i++) {
            if(i==1) {
                lowestNumber = myNumbers.get(i);
            }
            else {
                int currentNum = myNumbers.get(i); // Get the element at current index
                if (currentNum < lowestNumber) {
                    lowestNumber = currentNum; // Update if a smaller number is found
                }
            }
        }


    }

    //Task 5 - find the final purchase price
    /*
    <500 - No discuount
    500 - 1000 - 10% discuont
    >1000 - 20% discount
     */

    public double find_final_price(){
        Scanner scanner = new Scanner(System.in);
        double invoiceValue = scanner.nextDouble();
        double finalValue = 0;

        if(invoiceValue < 500){
            finalValue = invoiceValue;
            return finalValue ;
        }

        if (invoiceValue >1000){
            finalValue = invoiceValue*.8;
            return finalValue ;
        }

        return invoiceValue*.9;

    }


    // Task 6 - Program to print a pattern
    public static void pattern(){
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++) {
                if (j <= (rows - i) + 1) {
                    System.out.print(rows - j + 1);
                }else {
                    System.out.print(rows - ((rows - i) + 1) + 1);
                }
            }
        }
        }
        }