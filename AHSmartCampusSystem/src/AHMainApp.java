import com.smartcampus.service.AHEnrollmentEngine;
import com.smartcampus.model.*;
import com.smartcampus.exception.AHCampusException;
import java.util.Scanner;

public class AHMainApp {
    public static void main(String[] args) {
        AHEnrollmentEngine engine = new AHEnrollmentEngine();
        Scanner sc = new Scanner(System.in);

        // BONUS: Load previous data when the app starts
        engine.loadData();

        System.out.println("Welcome to the SmartCampus System!");

        while (true) {
            try {
                System.out.println("\n---- MENU ----");
                System.out.println("1. Add Student\n2. Add Course\n3. Enrollment\n4. View Records\n5. Save & Exit");
                System.out.print("Action: ");

                String input = sc.nextLine();
                if (input.isEmpty()) continue;
                int cmd = Integer.parseInt(input);

                switch (cmd) {
                    case 1:
                        System.out.print("Student ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        engine.registerLearner(new AHLearner(id, name, email));
                        break;

                    case 2:
                        System.out.print("Course Code (e.g., CS101): ");
                        String c = sc.nextLine(); // Corrected: Direct String capture
                        System.out.print("Title: ");
                        String t = sc.nextLine();
                        System.out.print("Fee: ");
                        double f = Double.parseDouble(sc.nextLine());
                        engine.registerModule(new AHCourseModule(c, t, f));
                        break;

                    case 3:
                        System.out.print("Learner ID: ");
                        int lid = Integer.parseInt(sc.nextLine());
                        System.out.print("Module Code: ");
                        String mid = sc.nextLine(); // FIXED: Removed parseInt to support alphanumeric
                        engine.processEnrollment(lid, mid);
                        break;

                    case 4:
                        engine.showAll();
                        break;

                    case 5:
                        // BONUS: Save data before the program shuts down
                        engine.saveData();
                        System.out.println("Data Secured. Exiting System...");
                        return;

                    default:
                        System.out.println("Invalid Option. Please choose 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric choice or ID.");
            } catch (AHCampusException e) {
                System.out.println("⚠ " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
    }
}