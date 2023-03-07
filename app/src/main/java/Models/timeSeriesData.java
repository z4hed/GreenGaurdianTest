package Models;

import java.time.LocalDateTime;

public class timeSeriesData {
    private LocalDateTime time;
    private float UV, moisture;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public float getUV() {
        return UV;
    }

    public void setUV(float UV) {
        this.UV = UV;
    }

    public float getMoisture() {
        return moisture;
    }

    public void setMoisture(float moisture) {
        this.moisture = moisture;
    }
}
