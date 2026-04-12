public class AHEmployee {
    int empId;
    String empName;
    double salary;
    // Shared company name
    static String companyName = "Tech Academy";

    // Initialization using constructor
    public AHEmployee(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("----- Employee Details -----");
        System.out.println("ID: " + empId + " | Name: " + empName +
                " | Salary: " + salary + " | Company: " + companyName);
    }
}