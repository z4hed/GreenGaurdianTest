package Models;

import java.time.LocalDateTime;

public class timeSeriesData {
    private String time;
    private float UV, moisture;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
