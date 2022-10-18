package com.g10.general;

import com.g10.game.Animation;
import javafx.util.Duration;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class AnimationManager {
    private static List<Pair<Animation, Duration>> playingAnimations = new ArrayList<>();

    public static void addPlayingAnimation(Animation animation) {
        playingAnimations.add(new Pair<>(animation, Duration.ZERO));
    }

    public static void removeAnimation(Animation animation) {
        for (int i = 0; i < playingAnimations.size(); i++) {
            Pair<Animation, Duration> timelineDurationPair = playingAnimations.get(i);
            if (timelineDurationPair.getKey().equals(animation)) {
                playingAnimations.remove(i);
            }
        }
    }

    public static void pauseAllPlayingAnimation() {
        List<Pair<Animation, Duration>> newplayingAnimations = new ArrayList<>();
        for (Pair<Animation, Duration> animationDurationPair : playingAnimations) {
            System.out.println(animationDurationPair.getKey().getCurrentTime().toString());
            newplayingAnimations.add(new Pair<>(animationDurationPair.getKey(), animationDurationPair.getKey().getCurrentTime()));
            animationDurationPair.getKey().pause();
        }
        playingAnimations = newplayingAnimations;
    }

    public static void resumeAllPlayingAnimation() {
        for (Pair<Animation, Duration> animationDurationPair : playingAnimations) {
            System.out.println(animationDurationPair.getValue().toString());
            animationDurationPair.getKey().playFrom(animationDurationPair.getValue());
        }
    }
}
