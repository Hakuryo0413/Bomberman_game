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

    private static String currentMusic = "";
    private static MediaPlayer mediaPlayer;

    public static void playSound(String path) {
        if (soundMap.get(path) == null) {
            AudioClip audioClip = new AudioClip(Main.class.getResource("/com/g10/media/" + path).toExternalForm());
            soundMap.put(path, audioClip);
        }
        if (!muteSound) {
            soundMap.get(path).play();
        }
    }

    public static void setMusic(String path) {
        if(!currentMusic.equals(path)) {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            if (musicMap.get(path) == null) {
                Media media = new Media(Main.class.getResource("/com/g10/media/music/" + path).toExternalForm());
                musicMap.put(path, media);
            }
            Media media = musicMap.get(path);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setVolume(0.4);
            mediaPlayer.setMute(muteMusic);
            mediaPlayer.play();
            currentMusic = path;
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

    public static void setSoundInfinitive(String path){
        if (soundMap.get(path) == null) {
            AudioClip audioClip = new AudioClip(Main.class.getResource("/com/g10/media/" + path).toExternalForm());
            soundMap.put(path, audioClip);
        }
        soundMap.get(path).setCycleCount(AudioClip.INDEFINITE);
    }

    public static boolean isSoundPlaying(String path) {
        if (soundMap.get(path) == null) {
            return false;
        }
        return soundMap.get(path).isPlaying();
    }

    public static void pauseSound(String path) {
        if (soundMap.get(path) != null) {
            soundMap.get(path).stop();
        }
    }
}
