package com.g10.general;

import com.g10.Main;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.HashMap;
import java.util.Map;

public class AudioManager {
    private static final Map<String, AudioClip> soundMap = new HashMap<String, AudioClip>();
    private static final Map<String, Media> musicMap = new HashMap<String, Media>();
    private static boolean muteSound = false;
    private static boolean muteMusic = false;
    private static MediaPlayer mediaPlayer = new MediaPlayer(new Media(Main.class.getResource("/com/g10/media/music.wav").toExternalForm()));

    public static void playMusic(String path) {
        if (musicMap.get(path) == null) {
            Media media = new Media(Main.class.getResource("/com/g10/media/" + path).toExternalForm());
            musicMap.put(path, media);
        }
        if (!muteMusic) {
            mediaPlayer.stop();
            mediaPlayer = new MediaPlayer(musicMap.get(path));
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        }
    }

    public static void playSound(String path) {
        if (soundMap.get(path) == null) {
            AudioClip audioClip = new AudioClip(Main.class.getResource("/com/g10/media/" + path).toExternalForm());
            soundMap.put(path, audioClip);
        }
        if (!muteSound) {
            soundMap.get(path).play();
        }
    }

    public static boolean isMuteSound() {
        return muteSound;
    }

    public static boolean isMuteMusic() {
        return muteMusic;
    }

    public static void switchMuteSound() {
        muteSound = !muteSound;
    }

    public static void switchMuteMusic() {
        muteMusic = !muteMusic;
        mediaPlayer.setMute(muteMusic);
    }
}
