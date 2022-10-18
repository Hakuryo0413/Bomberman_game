package com.g10.general;

import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class TimelineManager {

    private static List<Pair<Timeline, Duration>> playingTimelines = new ArrayList<>();

    public static void addPlayingTimeline(Timeline timeline) {
        playingTimelines.add(new Pair<>(timeline, Duration.ZERO));
    }

    public static void removeTimeline(Timeline timeline) {
        for (int i = 0; i < playingTimelines.size(); i++) {
            Pair<Timeline, Duration> timelineDurationPair = playingTimelines.get(i);
            if (timelineDurationPair.getKey().equals(timeline)) {
                playingTimelines.remove(i);
            }
        }
    }

    public static void pauseAllPlayingTimeline() {
        List<Pair<Timeline, Duration>> newplayingTimelines = new ArrayList<>();
        for (Pair<Timeline, Duration> timelineDurationPair : playingTimelines) {
            System.out.println(timelineDurationPair.getKey().getCurrentTime().toString());
            newplayingTimelines.add(new Pair<>(timelineDurationPair.getKey(), timelineDurationPair.getKey().getCurrentTime()));
            timelineDurationPair.getKey().pause();
        }
        playingTimelines = newplayingTimelines;
    }

    public static void resumeAllPlayingTimeline() {
        for (Pair<Timeline, Duration> timelineDurationPair : playingTimelines) {
            System.out.println(timelineDurationPair.getValue().toString());
            timelineDurationPair.getKey().playFrom(timelineDurationPair.getValue());
        }
    }
}
