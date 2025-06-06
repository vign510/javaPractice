import java.util.Scanner;

//Task 2 - 1.1 Create a person class with Name & Age as paramertes and default age is 18
class Person{
    String name;
    int age = 18;


    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void displayPersonInfo(){
        System.out.println("Name" + this.name);
        System.out.println("age" + this.age);
    }


}

//-------------------------------------------------------------------------------------------------------------------------------------------------------

class Product {
    private int pid;
    private double price;
    private int quantity;

    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    public int getPid() {
        return pid;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product [PID=" + pid + ", Price=" + price + ", Quantity=" + quantity + "]";
    }
}


public class ProductMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] products = new Product[5];


        System.out.println("--- Enter Information for 5 Products ---");
        for (int i = 0; i < products.length; i++) {
            System.out.println("\nEnter details for Product " + (i + 1) + ":");

            System.out.print("Enter Product ID (PID): ");
            int pid = scanner.nextInt();

            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();

            products[i] = new Product(pid, price, quantity);
        }

        //  Find Pid of the product with the highest price.
        int pidOfHighestPriceProduct = pidOfHighestPriceProduct(products);
        System.out.println("\n--- Product with Highest Price ---");
        System.out.println("PID of the product with the highest price: " + pidOfHighestPriceProduct);

        // Task c: Calculate and return the total amount spent on all products.
        double totalAmount = calculateTotalAmount(products);
        System.out.println("\n--- Total Amount Spent ---");
        System.out.println("Total amount spent on all products: Rs. " + String.format("%.2f", totalAmount)); // Format to 2 decimal places

        scanner.close(); // Close the scanner
    }

    public static double calculateTotalAmount(Product[] products) {
        double totalAmount = 0.0; // Initialize total amount

        if (products == null || products.length == 0) {
            System.out.println("No products to calculate total amount for.");
            return 0.0;
        }

        for (Product product : products) {
            // Calculate amount for a single product and add to total
            totalAmount += product.getPrice() * product.getQuantity();
        }
        return totalAmount;
    }
}


public static int pidOfHighestPriceProduct(Product[] products) {
    if (products == null || products.length == 0) {
        System.out.println("No products to evaluate for highest price.");
        return -1; // Indicate an error or no products
    }

    double highestPrice = products[0].getPrice(); // Assume first product has highest price initially
    int pidOfHighestPrice = products[0].getPid();  // Store its PID

    // Iterate through the rest of the products (starting from the second one)
    for (int i = 1; i < products.length; i++) {
        if (products[i].getPrice() > highestPrice) {
            highestPrice = products[i].getPrice(); // Update highest price
            pidOfHighestPrice = products[i].getPid(); // Update PID
        }
    }
    return pidOfHighestPrice;
}


//--------------------------------------------------------------------------------------------------------------------------------------------------



public class Account{

    private double balance;

    public Account(){
        this.balance = 0.0;
        System.out.println("Account created with initial balance: " + this.balance);
    }

    public Account(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0.0;
            System.out.println("Initial balance cannot be negative. Setting to 0.0");
        }
        System.out.println("Account created with initial balance: " + this.balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New balance: " + this.balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (this.balance >= amount) {
                this.balance -= amount;
                System.out.println("Withdrew: " + amount);
                System.out.println("New balance: " + this.balance);
            } else {
                System.out.println("Insufficient balance. Cannot withdraw " + amount);
                System.out.println("Current balance: " + this.balance);
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void displayBalance() {
        System.out.println("Current Account Balance: " + this.balance);
    }


}

//---------------------------------------------------------------------------------------------------------------------------------------------

public class Employee extends Person {
    private String employeeID;
    private double salary;

    public Employee(String name, int age, String employeeID, double salary) {
        super(name, age);
        this.employeeID = employeeID;
        this.salary = salary;
        System.out.println("Employee constructor called for: " + name + " (ID: " + employeeID + ")");
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public double getSalary() {
        return salary;
    }}