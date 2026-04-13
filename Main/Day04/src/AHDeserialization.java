import java.io.*;

public class AHDeserialization {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("ahStudent.ser");

            ObjectInputStream ois = new ObjectInputStream(fis);

            ahStudent s1 = (ahStudent) ois.readObject();

            System.out.println("Deserialized Successfully.");

            s1.display();

            fis.close();
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class Error: " + e);
        } catch (Exception e) {
            System.out.println("Deserialization Error: " + e);
        }
    }
}