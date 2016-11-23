package nasa.interware.com.interwarenasa.model.pojos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jorge.hernandez on 22/11/2016.
 * Nasa
 */

public class ApproachData {

    @SerializedName("close_approach_date")
    private String closeApproachDate;
    @SerializedName("epoch_date_close_approach")
    private Double epochDateCloseApproach;
    @SerializedName("relative_velocity")
    private RelativeVelocity relativeVelocity;
    @SerializedName("miss_distance")
    private MissDistance missDistance;
    @SerializedName("orbiting_body")
    private String orbitingBody;

    public String getCloseApproachDate() {
        return closeApproachDate;
    }

    public void setCloseApproachDate(String closeApproachDate) {
        this.closeApproachDate = closeApproachDate;
    }

    public Double getEpochDateCloseApproach() {
        return epochDateCloseApproach;
    }

    public void setEpochDateCloseApproach(Double epochDateCloseApproach) {
        this.epochDateCloseApproach = epochDateCloseApproach;
    }

    public RelativeVelocity getRelativeVelocity() {
        return relativeVelocity;
    }

    public void setRelativeVelocity(RelativeVelocity relativeVelocity) {
        this.relativeVelocity = relativeVelocity;
    }

    public MissDistance getMissDistance() {
        return missDistance;
    }

    public void setMissDistance(MissDistance missDistance) {
        this.missDistance = missDistance;
    }

    public String getOrbitingBody() {
        return orbitingBody;
    }

    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }
}
