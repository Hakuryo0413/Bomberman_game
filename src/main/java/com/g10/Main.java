package com.g10;

import com.g10.general.Sandbox;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Bomberman");
        stage.setResizable(false);
        Sandbox.init();
        stage.setScene(Sandbox.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
