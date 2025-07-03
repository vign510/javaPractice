public class task5 {


}

public class Book {
    private String bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // A new book is always available by default
    }
    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


}

public class Library {
    private Book[] books;
    private int nextFreeIndex;
    this.nextFreeIndex = 0;

    public Library() {
        this.books = new Book[];
        System.out.println("Library initialized with capacity for " + books.length + " books.");
    }

    public void addBook(Book book) {
        books[nextFreeIndex] = book;
        nextFreeIndex++;
    }

    public void removeBook(String bookID) {
        for (int i = 0; i < nextFreeIndex; i++) {
            if (books[i].getBookID().equals(bookID)) {
                books[i] = null;
                System.out.println("Book with ID " + bookID + " removed.");
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (int i = 0; i < nextFreeIndex; i++) {
            if (books[i] != null) {
                System.out.println("ID: " + books[i].getBookID() + ", Title: " + books[i].getTitle() + ", Author: " + books[i].getAuthor() + ", Available: " + books[i].isAvailable());
            }
        }
    }

}


// Task 2
public interface Taxable {
    double salesTax = 0.07;
    double incomeTax = 0.105;
    double calcTax();
}

public class Employee implements Taxable {
    private String name;
    private String empId;
    private double salary;

    public Employee(String name, double salary, String empId) {
        this.name = name;
        this.salary = salary;
        this.empId = empId;
    }

    @Override
    public double calcTax() {
        return salary * incomeTax;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + empId + ", Name=" + name + ", Salary=" + salary + "]";
    }
}


public class Product implements Taxable {
    private String pid;
    private String name;
    private double price;
    private int quantity;

    public Product(String pid, String name, double price, int quantity) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calcTax() {
        return price * salesTax;
    }

    @Override
    public String toString() {
        return "Product [PID=" + pid + ", Name=" + name + ", Unit Price=" + price + ", Quantity=" + quantity + "]";
    }
}

public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("--- Enter Employee Information ---");
        System.out.print("Enter Employee ID: ");
        String empId = scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();
        System.out.print("Enter Yearly Salary: ");
        double empSalary = scanner.nextDouble();

        Employee employee = new Employee(empId, empName, empSalary);
        double incomeTaxAmount = employee.calcTax();
        System.out.println("Employee: " + employee.getName() + " (ID: " + employee.getEmpId() + ")");

        System.out.println("--- Enter Product Information ---");
        System.out.print("Enter Product ID: ");
        String prodId = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String prodName = scanner.nextLine();
        System.out.print("Enter Unit Price: ");
        double prodPrice = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int prodQuantity = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(prodId, prodName, prodPrice, prodQuantity);
        double salesTaxAmount = product.calcTax();
        System.out.println("\nProduct Sales Tax Details:");
        System.out.println("Product: " + product.getName() + " (ID: " + product.getPid() + ")");

        scanner.close();
    }
}