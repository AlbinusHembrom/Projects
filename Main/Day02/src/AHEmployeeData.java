import java.util.Scanner;

class AhEmployee {
    String ahEmpName;
    int ahEmpId;
    double ahSalary;

    // Static variable for shared company name
    static String ahCompanyName = "Tech Solutions";

    // Constructor to initialize employee data
    AhEmployee(String ahName, int ahId, double ahSal) {
        this.ahEmpName = ahName;
        this.ahEmpId = ahId;
        this.ahSalary = ahSal;
    }

    // Method to display employee details
    void ahDisplayEmployeeInfo() {
        System.out.println("Company Name  : " + ahCompanyName);
        System.out.println("Employee Name : " + this.ahEmpName);
        System.out.println("Employee ID   : " + this.ahEmpId);
        System.out.println("Monthly Salary: ₹" + this.ahSalary);
    }
}

public class AHEmployeeData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Input for 1st Employee ---
        System.out.println("--- Enter 1st Employee Details ---");
        System.out.print("Name: ");
        String ahName1 = sc.nextLine();
        System.out.print("ID  : ");
        int ahId1 = sc.nextInt();
        System.out.print("Salary: ");
        double ahSal1 = sc.nextDouble();
        sc.nextLine();

        AhEmployee ahEmp1 = new AhEmployee(ahName1, ahId1, ahSal1);

        // --- Input for 2nd Employee ---
        System.out.println("\n--- Enter 2nd Employee Details ---");
        System.out.print("Name: ");
        String ahName2 = sc.nextLine();
        System.out.print("ID  : ");
        int ahId2 = sc.nextInt();
        System.out.print("Salary: ");
        double ahSal2 = sc.nextDouble();

        AhEmployee ahEmp2 = new AhEmployee(ahName2, ahId2, ahSal2);

        // --- Displaying Final Output ---
        System.out.println("\n--- Employee Details ---");
        ahEmp1.ahDisplayEmployeeInfo();
        System.out.println("------------------------");
        ahEmp2.ahDisplayEmployeeInfo();

        sc.close();
    }
}