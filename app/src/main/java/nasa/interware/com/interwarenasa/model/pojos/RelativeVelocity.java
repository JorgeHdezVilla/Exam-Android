package nasa.interware.com.interwarenasa.model.pojos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jorge.hernandez on 22/11/2016.
 * Nasa
 */

public class RelativeVelocity {

    @SerializedName("kilometers_per_second")
    private String kilometersSecond;
    @SerializedName("kilometers_per_hour")
    private String kilometersHour;
    @SerializedName("miles_per_hour")
    private String milesHour;

    public String getKilometersSecond() {
        return kilometersSecond;
    }

    public void setKilometersSecond(String kilometersSecond) {
        this.kilometersSecond = kilometersSecond;
    }

    public String getKilometersHour() {
        return kilometersHour;
    }

    public void setKilometersHour(String kilometersHour) {
        this.kilometersHour = kilometersHour;
    }

    public String getMilesHour() {
        return milesHour;
    }

    public void setMilesHour(String milesHour) {
        this.milesHour = milesHour;
    }
}
