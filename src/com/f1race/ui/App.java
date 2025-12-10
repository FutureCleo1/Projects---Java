package com.f1race.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.f1race.core.Driver;
import com.f1race.core.Team;
import com.f1race.race.manageRace;

public class App extends Application {

    private manageRace seasonManager = new manageRace();

    @Override
    public void start(Stage stage) {
        seasonManager.loadDefaultTracks();

        Button loadDriversBtn = new Button("Load Drivers CSV");
        Button addRaceBtn = new Button("Add Race Result");
        Button standingsBtn = new Button("Show Standings");
        Button routeBtn = new Button("Track Routing (Shortest Path)");

        loadDriversBtn.setOnAction(e -> handleLoadDrivers());
        addRaceBtn.setOnAction(e -> handleAddRace());
        standingsBtn.setOnAction(e -> handleShowStandings());
        routeBtn.setOnAction(e -> handleTrackRouting());

        VBox layout = new VBox(12, loadDriversBtn, addRaceBtn, standingsBtn, routeBtn);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 420, 240);
        stage.setScene(scene);
        stage.setTitle("F1 Season Manager");
        stage.show();
    }

    private void handleLoadDrivers() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Driver CSV File");
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );
        
        // Set initial directory to src folder if it exists
        File initialDir = new File("src");
        if (initialDir.exists()) {
            fileChooser.setInitialDirectory(initialDir);
        }
        
        File selectedFile = fileChooser.showOpenDialog(null);
        
        if (selectedFile != null) {
            try {
                seasonManager.importDrivers(selectedFile.getAbsolutePath());
                showInfo("Success", "Drivers loaded from:\n" + selectedFile.getName());
            } catch (IOException ex) {
                showError("Error loading CSV", ex.getMessage());
            } catch (Exception ex) {
                showError("Unexpected error", ex.toString());
            }
        }
    }

    private void handleAddRace() {
        TextInputDialog raceDialog = new TextInputDialog("Bahrain Grand Prix");
        raceDialog.setTitle("Add Race Result");
        raceDialog.setHeaderText("Enter race name:");
        raceDialog.setContentText("Race:");

        String raceName = raceDialog.showAndWait().orElse(null);
        if (raceName == null || raceName.isEmpty()) return;

        TextInputDialog locDialog = new TextInputDialog("Bahrain");
        locDialog.setTitle("Location");
        locDialog.setHeaderText("Enter race location:");
        locDialog.setContentText("Location:");
        String location = locDialog.showAndWait().orElse("Unknown");

        TextInputDialog dateDialog = new TextInputDialog("03/02/2025");
        dateDialog.setTitle("Date");
        dateDialog.setHeaderText("Enter race date:");
        dateDialog.setContentText("Date:");
        String date = dateDialog.showAndWait().orElse("Unknown");

        TextInputDialog driverDialog = new TextInputDialog("Max Verstappen");
        driverDialog.setTitle("Driver");
        driverDialog.setHeaderText("Enter driver name (must exist in drivers list):");
        driverDialog.setContentText("Driver:");
        String driverName = driverDialog.showAndWait().orElse(null);
        if (driverName == null || driverName.isEmpty()) return;

        TextInputDialog posDialog = new TextInputDialog("1");
        posDialog.setTitle("Position");
        posDialog.setHeaderText("Enter finishing position:");
        posDialog.setContentText("Position:");
        int position = Integer.parseInt(posDialog.showAndWait().orElse("1"));

        TextInputDialog ptsDialog = new TextInputDialog("25");
        ptsDialog.setTitle("Points");
        ptsDialog.setHeaderText("Enter points earned:");
        ptsDialog.setContentText("Points:");
        int points = Integer.parseInt(ptsDialog.showAndWait().orElse("0"));

        seasonManager.addRaceResult(raceName, location, date, driverName, position, points);
        showInfo("Race Added", "Race result added and standings updated.");
    }

    private void handleShowStandings() {
        List<Driver> driverList = seasonManager.getDriverStandings();
        List<Team> teamList = seasonManager.getTeamStandings();

        StringBuilder sb = new StringBuilder();
        sb.append("=== DRIVER STANDINGS ===\n");
        for (Driver d : driverList) {
            sb.append(d).append("\n");
        }

        sb.append("\n=== TEAM STANDINGS ===\n");
        for (Team t : teamList) {
            sb.append(t).append("\n");
        }

        showInfo("Standings", sb.toString());
    }

    private void handleTrackRouting() {
        TextInputDialog fromDialog = new TextInputDialog("Bahrain");
        fromDialog.setTitle("Track Routing");
        fromDialog.setHeaderText("Enter starting track:");
        fromDialog.setContentText("From:");
        String from = fromDialog.showAndWait().orElse(null);
        if (from == null || from.isEmpty()) return;

        TextInputDialog toDialog = new TextInputDialog("Miami");
        toDialog.setTitle("Track Routing");
        toDialog.setHeaderText("Enter destination track:");
        toDialog.setContentText("To:");
        String to = toDialog.showAndWait().orElse(null);
        if (to == null || to.isEmpty()) return;

        List<String> path = seasonManager.getShortestPath(from, to);
        int distance = seasonManager.getShortestDistance(from, to);

        StringBuilder sb = new StringBuilder();
        sb.append("Shortest path from ").append(from).append(" to ").append(to).append(":\n");
        sb.append(path).append("\n");
        sb.append("Total distance: ").append(distance).append(" km");

        showInfo("Shortest Path", sb.toString());
    }

    private void showInfo(String title, String message) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(message);
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        a.showAndWait();
    }

    private void showError(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setHeaderText(title);
        a.setContentText(message);
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        a.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
