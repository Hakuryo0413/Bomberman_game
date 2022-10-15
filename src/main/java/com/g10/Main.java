package com.g10;

import com.g10.general.ImageManager;
import com.g10.general.Sandbox;
import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AudioClip audioClip = new AudioClip(getClass().getResource("/com/g10/media/sound.m4a").toExternalForm());
        audioClip.play();
        stage.setTitle("Bomberman");
        stage.getIcons().add(ImageManager.getImage("asset/icon/icon.png"));
        stage.setResizable(false);
        Sandbox.init();
        stage.setScene(Sandbox.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
