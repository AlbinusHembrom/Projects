package com.smartcampus.service;

import com.smartcampus.model.*;
import com.smartcampus.exception.AHCampusException;

import java.io.*;
import java.util.*;

public class AHEnrollmentEngine {
    private Map<Integer, AHLearner> learners = new HashMap<>();
    // Key is String to support alphanumeric codes like "CS101"
    private Map<String, AHCourseModule> modules = new HashMap<>();
    private Map<Integer, List<AHCourseModule>> records = new HashMap<>();

    public void registerLearner(AHLearner l) {
        learners.put(l.getId(), l);
    }

    public void registerModule(AHCourseModule m) {
        modules.put(m.getCode(), m);
    }

    public void processEnrollment(int lid, String mid) throws AHCampusException {
        if (!learners.containsKey(lid)) {
            throw new AHCampusException("Invalid Learner ID: " + lid);
        }
        if (!modules.containsKey(mid)) {
            throw new AHCampusException("Invalid Module Code: " + mid);
        }

        records.putIfAbsent(lid, new ArrayList<>());
        records.get(lid).add(modules.get(mid));

        // Start Multithreading logic
        new AHSyncProcessor(learners.get(lid).getName()).start();
    }

    public void showAll() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("       CAMPUS ENROLLMENT REPORT");
        System.out.println("=".repeat(40));

        if (records.isEmpty()) {
            System.out.println("[!] No active enrollments found.");
            return;
        }

        for (Integer id : records.keySet()) {
            AHLearner student = learners.get(id);
            List<AHCourseModule> enrolled = records.get(id);

            System.out.println("\nLearner: " + student.getName() + " (ID: " + id + ")");
            System.out.println("Enrolled Modules:");

            double total = 0;
            for (AHCourseModule m : enrolled) {
                // This prints the Alphanumeric ID and the Title for each course
                System.out.println("  - [" + m.getCode() + "] " + m.getTitle() + " (₹" + m.getTuition() + ")");
                total += m.getTuition();
            }

            // Apply scholarship logic if 3+ courses
            if (enrolled.size() >= 3) {
                double discount = total * 0.12;
                total -= discount;
                System.out.println(">> SCHOLARSHIP: 12% Discount Applied (-₹" + discount + ")");
            }

            System.out.println(">> FINAL BILLING: ₹" + total);
            System.out.println("-".repeat(30));
        }
    }
    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("campus_data.ser"))) {
            oos.writeObject(learners);
            oos.writeObject(modules);
            oos.writeObject(records);
            System.out.println("✔ System state saved to disk.");
        } catch (IOException e) {
            System.out.println("Save Error: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("campus_data.ser"))) {
            learners = (Map<Integer, AHLearner>) ois.readObject();
            modules = (Map<String, AHCourseModule>) ois.readObject();
            records = (Map<Integer, List<AHCourseModule>>) ois.readObject();
            System.out.println("✔ Previous session data restored.");
        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh.");
        }
    }
}