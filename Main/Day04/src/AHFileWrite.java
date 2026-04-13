import java.io.FileWriter;
import java.io.IOException;

class Student
{
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class AHFileWrite {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Mohit Kumar");

        try {
            FileWriter fw = new FileWriter("student.txt");

            fw.write("ID: " + s1.id + "\n");
            fw.write("Name: " + s1.name);

            fw.close();

            System.out.println("Data Written Successfully.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}