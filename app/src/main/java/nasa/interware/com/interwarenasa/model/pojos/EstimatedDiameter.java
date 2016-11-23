package nasa.interware.com.interwarenasa.model.pojos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jorge.hernandez on 22/11/2016.
 * Nasa
 */

public class EstimatedDiameter {

    @SerializedName("estimated_diameter_min")
    private Double estimatedDiameterMin;
    @SerializedName("estimated_diameter_max")
    private Double estimatedDiameterMax;

    public Double getEstimatedDiameterMin() {
        return estimatedDiameterMin;
    }

    public void setEstimatedDiameterMin(Double estimatedDiameterMin) {
        this.estimatedDiameterMin = estimatedDiameterMin;
    }

    public Double getEstimatedDiameterMax() {
        return estimatedDiameterMax;
    }

    public void setEstimatedDiameterMax(Double estimatedDiameterMax) {
        this.estimatedDiameterMax = estimatedDiameterMax;
    }
}
