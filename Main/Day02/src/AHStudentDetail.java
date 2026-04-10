import java.util.Scanner;

class Student {
    String ahName;
    int ahRollNumber;
    double ahMarks;
    Student(String name, int rollNumber, double inputMarks) {
        this.ahName = name;
        this.ahRollNumber = rollNumber;
        this.ahMarks = inputMarks;
    }

    void displayInfo() {
        System.out.println("Student Name: " + this.ahName);
        System.out.println("Roll Number: " + this.ahRollNumber);
        System.out.println("Student's Marks: " +this.ahMarks);
    }
}

public class AHStudentDetail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String ahName = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int ahRoll = sc.nextInt();

        System.out.print("Enter the Marks: ");
        double ahMarks = sc.nextDouble();

        // Creating an object of Student using the constructor
        Student ahS1 = new Student(ahName, ahRoll, ahMarks);
        System.out.println("\n--- Student Details ---");
        ahS1.displayInfo();
        sc.close();
    }
}