package com.f1race.ui;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

import com.f1race.core.Driver;
import com.f1race.core.Team;
import com.f1race.race.manageRace;

public class Main {
    public static void main(String[] args) {
        manageRace seasonResults = new manageRace();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the Formu1a Season Manager!");
        
        // File chooser to select CSV file
        String driversFilePath = selectCSVFile();
        if (driversFilePath == null) {
            System.out.println("No file selected. Exiting.");
            keyboard.close();
            return;
        }
        
        try {
            System.out.println("Loading drivers from: " + driversFilePath);
            seasonResults.importDrivers(driversFilePath);
            System.out.println("Drivers loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading drivers: " + e.getMessage());
            keyboard.close();
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
                    for (Driver d : seasonResults.getDriverStandings()) {
                        System.out.println(d);
                    }
                    break;
                case 2:
                    System.out.println("\nTeams Information:");
                    for (Team t : seasonResults.getTeamStandings()) {
                        System.out.println(t);
                    }
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

                    seasonResults.addRaceResult(raceName, location, date, driverName, position, points);

                    System.out.println("Race result added!");
                    break;

                case 4:
                    System.out.println("\nDriver Standings:");
                    seasonResults.printStandingsToConsole();
                    break;
                case 5:
                    System.out.println("\nSeason Summary:");
                    seasonResults.printStandingsToConsole();
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
    /*
    Name: selectCSVFile
    Parameters: none
    Purpose: Opens a file chooser dialog to select a CSV file and returns its path
     */
    private static String selectCSVFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a CSV file for drivers");
        
        // Filter to show only CSV files
        FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("CSV files (*.csv)", "csv");
        fileChooser.setFileFilter(csvFilter);
        
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        
        return null;
    }
}
