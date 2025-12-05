package src.Projects;

import java.io.IOException;
import java.util.Scanner;
import src.Projects.manageRace;

public class Main {
    public static void main(String[] args) {
        manageRace seasonResults = new manageRace();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the Formu1a Season Manager!");
        try {
            System.out.print("Please enter th drivers csv file path: ");
            String driversFilePath = keyboard.nextLine();
            seasonResults.importDrivers(driversFilePath);
            System.out.print("Drivers loaded successfully.\n");
        } catch (IOException e) {
            System.out.println("Error loading drivers: " + e.getMessage());
            return;
        }
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. List Drivers Information");
            System.out.println("2. List Teams Information");
            System.out.println("3. Add Race Results");
            System.out.println("4. View Current Standing");
            System.out.println("5. View Season Summary");
            System.out.println("6. Exit");
            System.out.print("Please select an option from 1-6: ");
            int choice = keyboard.nextInt();
            keyboard.nextLine(); 
            switch (choice) {
                case 1:// List Drivers Information
                    System.out.println("\nDrivers Information:");
                    for (Driver d : seasonResults.getAllDrivers(10)) {
                        System.out.println(d);
                    }
                    break;
                case 2:
                    System.out.println("\nTeams Information:");
                    seasonResults.getSortedTeams();
                    break;
                case 3:
                    System.out.print("Race Name: ");
                    String raceName = keyboard.nextLine();

                    System.out.print("Location: ");
                    String location = keyboard.nextLine();

                    System.out.print("Date (MM/DD/YYYY): ");
                    String date = keyboard.nextLine();

                    System.out.print("Driver Name: ");
                    String driverName = keyboard.nextLine();

                    System.out.print("Position (1–20): ");
                    int position = keyboard.nextInt();

                    System.out.print("Points Earned: ");
                    int points = keyboard.nextInt();
                    keyboard.nextLine(); // clear input

                    Driver d = seasonResults.getDriver(driverName);
                    Team t = seasonResults.getTeam(d.getTeam());
                    seasonResults.recordedRace(raceName, location, date, d, t, position, points);

                    System.out.println("Race result added!");
                    break;

                case 4:
                    System.out.println("\nDriver Standings:");
                    for (Driver driver : seasonResults.getAllDrivers(10)) {
                        System.out.println(driver);
                    }
                    break;
                case 5:
                    seasonResults.seasonSummary();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        keyboard.close();
    }
}