package logic;

import java.time.Duration;

public class Player {
    private Duration remainingTime;
    private final String name;

    public Player(String name, Duration remainingTime) {
        this.name = name;
        this.remainingTime = remainingTime;
    }

    public Duration getRemainingTime() {
        return remainingTime;
    }

    public void removeTime(Duration time) {
        remainingTime = remainingTime.minus(time);
    }

    public String getName() {
        return name;
    }
}
