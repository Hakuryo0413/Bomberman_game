package com.g10.general;

import javafx.scene.image.Image;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ImageManager {
    private static final Map<String, Image> map = new HashMap<String, Image>();

    public static Image getImage(String path) {
        if (map.get(path) != null) {
            return map.get(path);
        }
        Image image = loadImage(path);
        map.put(path, image);
        return image;
    }

    private static Image loadImage(String path) {
        path = "src/main/resources/com/g10/" + path;
        File file = new File(path);
        String imagePath = file.getAbsolutePath();
        if (File.separatorChar == '\\') {
            // From Windows to Linux/Mac
            imagePath = imagePath.replace('/', File.separatorChar);
            imagePath = imagePath.replace("\\", "\\\\");
        } else {
            // From Linux/Mac to Windows
            imagePath = imagePath.replace('\\', File.separatorChar);

        }
        imagePath = "file:" + imagePath;
        return new Image(imagePath);
    }
}
