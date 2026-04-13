import java.io.*;

// ahStudent class must implement Serializable
class ahStudent implements Serializable {
    int id;
    String name;

    ahStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

public class AHSerialization {
    public static void main(String[] args) {
        try {
            ahStudent s1 = new ahStudent(101, "Mohit");

            FileOutputStream fos = new FileOutputStream("ahStudent.ser");

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(s1);

            oos.close();
            fos.close();

            System.out.println("Object Serialized Successfully.");
        } catch (Exception e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }
    }
}