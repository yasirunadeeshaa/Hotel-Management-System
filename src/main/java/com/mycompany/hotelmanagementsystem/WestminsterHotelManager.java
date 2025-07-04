package com.mycompany.hotelmanagementsystem;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterHotelManager implements HotelManager {
    private ArrayList<HotelStaff> hotelStaffList;
    private ArrayList<Guest> hotelGuestList;
    private int staffLimit;

    public WestminsterHotelManager(int maxMembersNumber) {
        hotelStaffList = new ArrayList<>();
        hotelGuestList = new ArrayList<>();
        staffLimit = maxMembersNumber;
    }

    @Override
    public boolean runMenu() {
        boolean exit = false; // Exit flag
        displayAdminMenu();

        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();

        switch (choice) {
            case 0:
                System.out.println("Saving data and returning to main menu...");
                exit = true;
                break;
            case 1:
                this.addHotelStaff();
                break;
            case 2:
                this.printHotelStaffList();
                break;
            case 3:
                this.addGuest();
                break;
            case 4:
                this.printGuestList();
                break;
            case 5:
                this.runGUI();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                break;
        }
        return exit;
    }

    /**
     * Display the admin menu with clear formatting
     */
    private void displayAdminMenu() {
        System.out.println("\n" + "=".repeat(55));
        System.out.println("         HOTEL MANAGEMENT SYSTEM - ADMIN PANEL");
        System.out.println("=".repeat(55));
        System.out.println("│ 0. Logout & Return to Main Menu                    │");
        System.out.println("│ 1. Add New Staff Member                            │");
        System.out.println("│ 2. View All Staff Members                          │");
        System.out.println("│ 3. Add New Guest                                   │");
        System.out.println("│ 4. View All Guests                                 │");
        System.out.println("│ 5. Open Staff Management GUI                       │");
        System.out.println("=".repeat(55));
        System.out.print("Enter your choice: ");
    }

    @Override
    public void addHotelStaff() {
        Scanner s = new Scanner(System.in);
        if (hotelStaffList.size() < staffLimit) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("           ADD NEW STAFF MEMBER");
            System.out.println("=".repeat(50));
            System.out.println("│ 1. Manager                                     │");
            System.out.println("│ 2. Housekeeper                                │");
            System.out.println("│ 3. Chef                                        │");
            System.out.println("│ 4. Receptionist                               │");
            System.out.println("│ 5. Security                                    │");
            System.out.println("=".repeat(50));
            System.out.print("Select staff type: ");

            int choiceStaff = s.nextInt();
            s.nextLine();

            // Common questions
            System.out.print("Enter first name: ");
            String name = s.nextLine();

            System.out.print("Enter last name: ");
            String surname = s.nextLine();

            System.out.print("Enter staff ID: ");
            String staffID = s.nextLine();

            System.out.print("Enter date of birth (dd/MM/yyyy): ");
            LocalDate date = null;
            String dob = null;
            boolean parsingSucceeds = false;
            while (!parsingSucceeds) {
                dob = s.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
                    date = LocalDate.parse(dob, formatter);
                    parsingSucceeds = true;
                } catch (DateTimeParseException e) {
                    System.out.print("Invalid format! Please use dd/MM/yyyy: ");
                    parsingSucceeds = false;
                }
            }

            // Check staff type and get specific information
            switch (choiceStaff) {
                case 1:
                    // Manager
                    System.out.print("Enter license number: ");
                    String licenseNum = s.nextLine();

                    Manager manager = new Manager(name, surname);
                    manager.setLicenseNumber(licenseNum);
                    manager.setDateOfBirth(date);
                    manager.setStaffID(staffID);
                    this.addStaffToList(manager);
                    break;

                case 2:
                    // HouseKeeper
                    System.out.print("Enter years of experience: ");
                    int yearsOfExperience = s.nextInt();
                    s.nextLine();

                    HouseKeeper housekeeper = new HouseKeeper(name, surname);
                    housekeeper.setYearsOfExperience(yearsOfExperience);
                    housekeeper.setDateOfBirth(date);
                    housekeeper.setStaffID(staffID);
                    this.addStaffToList(housekeeper);
                    break;

                case 3:
                    // Chef
                    System.out.print("Enter speciality: ");
                    String speciality = s.nextLine();

                    System.out.print("Enter years of experience: ");
                    int YOE = s.nextInt();
                    s.nextLine();

                    Chef chef = new Chef(name, surname);
                    chef.setSpeciality(speciality);
                    chef.setYearsOfExperience(YOE);
                    chef.setStaffID(staffID);
                    chef.setDateOfBirth(date);
                    this.addStaffToList(chef);
                    break;

                case 4:
                    // Receptionist
                    System.out.print("Enter number of languages spoken: ");
                    int numLanguages = s.nextInt();
                    s.nextLine();

                    String[] languages = new String[numLanguages];
                    for (int i = 0; i < numLanguages; i++) {
                        System.out.print("Enter language " + (i + 1) + ": ");
                        languages[i] = s.nextLine();
                    }

                    System.out.print("Has customer service certification? (true/false): ");
                    boolean hasCertification = s.nextBoolean();
                    s.nextLine();

                    Receptionist receptionist = new Receptionist(name, surname);
                    receptionist.setLanguagesSpoken(languages);
                    receptionist.setHasCustomerServiceCertification(hasCertification);
                    receptionist.setDateOfBirth(date);
                    receptionist.setStaffID(staffID);
                    this.addStaffToList(receptionist);
                    break;

                case 5:
                    // Security
                    System.out.print("Enter security level (Level 1, Level 2, Level 3): ");
                    String securityLevel = s.nextLine();

                    System.out.print("Is armed? (true/false): ");
                    boolean isArmed = s.nextBoolean();
                    s.nextLine();

                    Security security = new Security(name, surname);
                    security.setSecurityLevel(securityLevel);
                    security.setIsArmed(isArmed);
                    security.setDateOfBirth(date);
                    security.setStaffID(staffID);
                    this.addStaffToList(security);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } else {
            System.out.println("Staff limit reached! Cannot add more staff members.");
        }
    }

    public void addStaffToList(HotelStaff staff) {
        if (this.hotelStaffList.size() < staffLimit) {
            hotelStaffList.add(staff);
            System.out.println("✓ Staff member added successfully!");
        } else {
            System.out.println("✗ Cannot add staff member - list is full!");
        }
    }

    @Override
    public void printHotelStaffList() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                           HOTEL STAFF LIST");
        System.out.println("=".repeat(80));

        if (!hotelStaffList.isEmpty()) {
            for (int i = 0; i < hotelStaffList.size(); i++) {
                System.out.println((i + 1) + ". " + hotelStaffList.get(i).toString());
            }
        } else {
            System.out.println("No staff members found in the system.");
        }
        System.out.println("=".repeat(80));
    }

    @Override
    public void addGuest() {
        Scanner s = new Scanner(System.in);

        System.out.println("\n" + "=".repeat(40));
        System.out.println("         ADD NEW GUEST");
        System.out.println("=".repeat(40));

        System.out.print("Enter first name: ");
        String name = s.nextLine();

        System.out.print("Enter last name: ");
        String surname = s.nextLine();

        System.out.print("Enter room number: ");
        int roomNum = s.nextInt();
        s.nextLine();

        System.out.print("Enter number of nights stayed: ");
        int nightsStayed = s.nextInt();
        s.nextLine();

        Guest guest = new Guest(name, surname, roomNum, nightsStayed);
        hotelGuestList.add(guest);
        System.out.println("✓ Guest added successfully!");
    }

    /**
     * Print all guests in the system
     */
    public void printGuestList() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                           HOTEL GUEST LIST");
        System.out.println("=".repeat(80));

        if (!hotelGuestList.isEmpty()) {
            for (int i = 0; i < hotelGuestList.size(); i++) {
                System.out.println((i + 1) + ". " + hotelGuestList.get(i).toString());
            }
        } else {
            System.out.println("No guests found in the system.");
        }
        System.out.println("=".repeat(80));
    }

    @Override
    public void runGUI() {
        System.out.println("Opening Staff Management GUI...");
        HotelTableGUI table = new HotelTableGUI(hotelStaffList);
        table.setVisible(true);
    }
}