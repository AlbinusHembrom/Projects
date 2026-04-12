import java.util.Scanner;

public class AHMain {
    public static void main(String[] args) {
        // Creating scanner object named 'sc'
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Student Product Billing & Management System ===");

        // --- 1. Student & String Formatting (US-01, US-02, US-03) ---
        System.out.println("\n[Student Entry]");
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        int[] marks = new int[5];
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        AHStudent s1 = new AHStudent(roll, name, marks);
        s1.displayStudentInfo();
        s1.displayMarks();
        System.out.println("Average Score: " + s1.calculateAverage());

        // --- 2. Inheritance (US-08) ---
        System.out.println("\n[College Student Entry]");
        sc.nextLine(); // clear buffer
        System.out.print("Enter College Name: ");
        String clg = sc.nextLine();

        // Reusing marks for simplicity
        AHCollegeStudent cs1 = new AHCollegeStudent(roll + 1, name + " (Junior)", marks, clg);
        cs1.displayStudentInfo();

        // --- 3. Employee & Static (US-05, US-06) ---
        System.out.println("\n[Employee Entry]");
        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String empName = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        AHEmployee e1 = new AHEmployee(empId, empName, salary);
        e1.displayEmployee();

        // --- 4. Product & Billing with 3 Products (US-04, US-07) ---
        System.out.println("\n[Product Billing - 3 Items]");
        sc.nextLine();

        // Product 1
        System.out.print("Enter Product 1 Name: ");
        String p1Name = sc.nextLine();
        System.out.print("Price: ");
        double p1Price = sc.nextDouble();
        sc.nextLine();

        // Product 2
        System.out.print("Enter Product 2 Name: ");
        String p2Name = sc.nextLine();
        System.out.print("Price: ");
        double p2Price = sc.nextDouble();
        sc.nextLine();

        // Product 3
        System.out.print("Enter Product 3 Name: ");
        String p3Name = sc.nextLine();
        System.out.print("Price: ");
        double p3Price = sc.nextDouble();

        // Creating objects using encapsulated class
        AHProduct prod1 = new AHProduct(1, p1Name, p1Price);
        AHProduct prod2 = new AHProduct(2, p2Name, p2Price);
        AHProduct prod3 = new AHProduct(3, p3Name, p3Price);

        // Using Method Overloading for billing
        AHProductBilling billing = new AHProductBilling();
        double total = billing.calculateBill(prod1.getPrice(), prod2.getPrice(), prod3.getPrice());

        System.out.println("\n--- Final Invoice ---");
        System.out.println("Total Amount for 3 items: " + total);

        // Applying the student discount method
        double discountedPrice = billing.calculateBill(total, 10);
        System.out.println("After 10% Student Discount: " + discountedPrice);

        // Static count verification
        System.out.println("\nTotal Student objects in memory: " + AHStudent.ahStudentCount);

        sc.close();
    }
}