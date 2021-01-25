package edu.isu.cs.cs2263.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonActions extends Application {


    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Button Experiment");

        Label label = new Label("Not Clicked!");
        Button button = new Button("Click");

        button.setOnAction(value -> {
            label.setText("Clicked!");
        });

        VBox vbox = new VBox(button, label);

        Scene scene = new Scene(vbox, 100, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String args[]) {
        Application.launch(args);
    }
}
