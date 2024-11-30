import java.util.*;

public class Customer {
    private int id;
    private double balance;
    private String firstName;
    private String lastName;

    // Constructor
    public Customer(int id, double balance, String firstName, String lastName) {
        this.id = id;
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Override toString for displaying customer details
    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + id +
                ", Balance=" + balance +
                ", First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                '}';
    }

    // Main Application
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        // Add sample customers
        customers.add(new Customer(101, 5000.75, "John", "Doe"));
        customers.add(new Customer(102, 3000.50, "Alice", "Smith"));
        customers.add(new Customer(103, 7000.20, "John", "Adams"));
        customers.add(new Customer(104, 4500.30, "Alice", "Johnson"));

        System.out.println("Before Sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Sort using lambda for the custom sorting criteria
        customers.sort((c1, c2) -> {
            int firstNameCompare = c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
            if (firstNameCompare != 0) return firstNameCompare;

            int lastNameCompare = c1.getLastName().compareToIgnoreCase(c2.getLastName());
            if (lastNameCompare != 0) return lastNameCompare;

            int idCompare = Integer.compare(c1.getId(), c2.getId());
            if (idCompare != 0) return idCompare;

            return Double.compare(c1.getBalance(), c2.getBalance());
        });

        System.out.println("\nAfter Sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
