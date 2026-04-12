public class AHStudent {
    int ahRollNo;
    String ahName;
    int[] ahMarks;
    static int ahStudentCount = 0;

    public AHStudent(int rollNo, String name, int[] marks) {
        this.ahRollNo = rollNo;
        this.ahName = name;
        this.ahMarks = marks;
        ahStudentCount++;
    }

    // Display and String formatting
    public void displayStudentInfo() {
        System.out.println("----- Student Details -----");
        System.out.println("Roll No: " + ahRollNo);
        System.out.println("Original Name: " + ahName);
        System.out.println("Uppercase: " + ahName.toUpperCase());
        System.out.println("Lowercase: " + ahName.toLowerCase());
        System.out.println("Name Length: " + ahName.length());
    }

    // Printing marks using loop
    public void displayMarks() {
        System.out.print("Marks: ");
        for (int mark : ahMarks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    // Calculating average
    public double calculateAverage() {
        int sum = 0;
        for (int mark : ahMarks) {
            sum += mark;
        }
        return (double) sum / ahMarks.length;
    }
}