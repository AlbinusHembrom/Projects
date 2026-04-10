import java.util.Scanner;

class Employee {
    String ahEmpName;
    int ahEmpId;
    double ahSalary;

    // Constructor to initialize employee data
    Employee(String name, int id, double salary) {
        this.ahEmpName = name;
        this.ahEmpId = id;
        this.ahSalary = salary;
    }

    // Method to display employee details
    void displayEmployeeInfo() {
        System.out.println("Employee Name: " + this.ahEmpName);
        System.out.println("Employee ID  : " + this.ahEmpId);
        System.out.println("Monthly Salary: ₹" + this.ahSalary);
    }
}

public class AHEmployeeDetail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter Employee Name: ");
        String ahName = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int ahId = sc.nextInt();

        System.out.print("Enter Salary: ");
        double ahSalary = sc.nextDouble();

        // Creating an object of Employee using the constructor
        Employee ahEmp1 = new Employee(ahName, ahId, ahSalary);

        // Displaying the initialized data
        System.out.println("\n--- Employee Details ---");
        ahEmp1.displayEmployeeInfo();

        sc.close();
    }
}