package com.mycompany.hotelmanagementsystem;

import java.util.Scanner;

public class HotelManagementSystem {

    private static final String ADMIN_PASSWORD = "123"; // Simple hardcoded password
    private static HotelManager hotelManager;

    public static void main(String[] args) {
        hotelManager = new WestminsterHotelManager(100);
        runRoleSelection();
    }

    public static void runRoleSelection() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayWelcomeScreen();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Admin login
                    if (authenticateAdmin(scanner)) {
                        runAdminSystem();
                    }
                    break;
                case 2:
                    // Guest system (placeholder for future implementation)
                    runGuestSystem();
                    break;
                case 0:
                    System.out.println("Thank you for using Hotel Management System!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    private static void displayWelcomeScreen() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("    WELCOME TO HOTEL MANAGEMENT SYSTEM");
        System.out.println("=".repeat(50));
        System.out.println("Please select your role:");
        System.out.println("1. Hotel Administrator");
        System.out.println("2. Guest");
        System.out.println("0. Exit System");
        System.out.println("=".repeat(50));
    }

    private static boolean authenticateAdmin(Scanner scanner) {
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter admin password: ");
            String inputPassword = scanner.nextLine();

            if (ADMIN_PASSWORD.equals(inputPassword)) {
                System.out.println("Authentication successful! Welcome Administrator.");
                return true;
            } else {
                attempts++;
                System.out.println("Incorrect password! Attempts remaining: " + (MAX_ATTEMPTS - attempts));

                if (attempts >= MAX_ATTEMPTS) {
                    System.out.println("Maximum attempts exceeded. Returning to main menu.");
                    return false;
                }
            }
        }
        return false;
    }

    private static void runAdminSystem() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("    ADMINISTRATOR PANEL ACCESS GRANTED");
        System.out.println("=".repeat(50));

        boolean exit = false;
        while (!exit) {
            exit = hotelManager.runMenu();
        }

        System.out.println("Logging out from Administrator Panel...");
    }

    private static void runGuestSystem() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("    GUEST PORTAL");
        System.out.println("=".repeat(50));
        hotelManager.addGuest();

        // Add a small delay for better user experience
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}