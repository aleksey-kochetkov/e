package e.pattern.dispatch;

import java.time.LocalTime;

public class Timer {
    private long millis;

    public void start() {
        this.millis = System.currentTimeMillis();
    }

    public LocalTime stop() {
        long endMillis = System.currentTimeMillis();
        LocalTime result =
               LocalTime.ofNanoOfDay((endMillis - this.millis) * 1000);
        this.millis = System.currentTimeMillis();
        return result;
    }
}
