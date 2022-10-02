package com.g10.general;

import javafx.scene.Scene;

import java.util.ArrayList;

public class Input {
    private static final ArrayList<String> input = new ArrayList<>();

    public static ArrayList<String> getInput() {
        return input;
    }

    public static void attachEventHandle(Scene scene) {
        scene.setOnKeyPressed(
                keyEvent -> {
                    String code = keyEvent.getCode().toString();
                    if (!input.contains(code)) {
                        input.add(code);
                    }
                }
        );
        scene.setOnKeyReleased(
                keyEvent -> {
                    String code = keyEvent.getCode().toString();
                    input.remove(code);
                }
        );
    }
}
