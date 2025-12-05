package src.Projects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiMain extends Application {

    private manageRace seasonManager = new manageRace();

    @Override
    public void start(Stage stage) {

        Button addDriverBtn = new Button("Add Driver");
        Button addTeamBtn = new Button("Add Team");
        Button addRaceBtn = new Button("Add Race Result");
        Button showStandingsBtn = new Button("Show Standings");

        addDriverBtn.setOnAction(e -> {
            System.out.println("TODO: Open Add Driver Form");
        });

        addTeamBtn.setOnAction(e -> {
            System.out.println("TODO: Open Add Team Form");
        });

        addRaceBtn.setOnAction(e -> {
            System.out.println("TODO: Open Add Race Result Form");
        });

        showStandingsBtn.setOnAction(e -> {
            System.out.println("TODO: Display Current Standings");
        });

        // --- Layout ---
        VBox layout = new VBox(12);
        layout.getChildren().addAll(
                addDriverBtn,
                addTeamBtn,
                addRaceBtn,
                showStandingsBtn
        );

        Scene scene = new Scene(layout, 400, 300);

        stage.setTitle("F1 Season Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
