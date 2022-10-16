package com.g10.general;

import com.g10.Main;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {
    private boolean muteSound = false;
    private boolean muteMusic = false;
    private Media currentMusic = new Media(Main.class.getResource("/com/g10/media/music.wav").toExternalForm());
    private MediaPlayer mediaPlayer;

    public void playMusic() {
        if (!muteMusic) {
            mediaPlayer = new MediaPlayer(currentMusic);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setCycleCount(Integer.MAX_VALUE);
        }
    }

    public void playSound(String path) {
        if (!muteSound) {
            AudioClip audioClip = new AudioClip(Main.class.getResource("/com/g10/media/" + path).toExternalForm());
            audioClip.play();
        }
    }

    public boolean isMuteSound() {
        return muteSound;
    }

    public void setMuteSound(boolean muteSound) {
        this.muteSound = muteSound;
    }

    public boolean isMuteMusic() {
        return muteMusic;
    }

    public void setMuteMusic(boolean muteMusic) {
        this.muteMusic = muteMusic;
    }

    public void switchMuteSound() {
        muteSound = !muteSound;
    }

    public void switchMuteMusic() {
        muteMusic = !muteMusic;
    }

    public void switchCurrentMusic(String path) {
        mediaPlayer.pause();
        currentMusic = new Media(Main.class.getResource("/com/g10/media/" + path).toExternalForm());
        playMusic();
    }
}
