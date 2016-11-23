package nasa.interware.com.interwarenasa.model.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jorge.hernandez on 22/11/2016.
 * Nasa
 */

public class NearObject {

    @SerializedName("links")
    private Links links;
    @SerializedName("neo_reference_id")
    private String NeoReferenceId;
    @SerializedName("name")
    private String name;
    @SerializedName("nasa_jpl_url")
    private String nasaJplUrl;
    @SerializedName("absolute_magnitude_h")
    private Double absoluteMagnitudeH;
    @SerializedName("estimated_diameter")
    private EstimatedDiameters diameters;
    @SerializedName("is_potentially_hazardous_asteroid")
    private Boolean isPotentiallyHazardous;
    @SerializedName("close_approach_data")
    private List<ApproachData> approachData;

    private String date;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getNeoReferenceId() {
        return NeoReferenceId;
    }

    public void setNeoReferenceId(String neoReferenceId) {
        NeoReferenceId = neoReferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasaJplUrl() {
        return nasaJplUrl;
    }

    public void setNasaJplUrl(String nasaJplUrl) {
        this.nasaJplUrl = nasaJplUrl;
    }

    public Double getAbsoluteMagnitudeH() {
        return absoluteMagnitudeH;
    }

    public void setAbsoluteMagnitudeH(Double absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }

    public EstimatedDiameters getDiameters() {
        return diameters;
    }

    public void setDiameters(EstimatedDiameters diameters) {
        this.diameters = diameters;
    }

    public Boolean getPotentiallyHazardous() {
        return isPotentiallyHazardous;
    }

    public void setPotentiallyHazardous(Boolean potentiallyHazardous) {
        isPotentiallyHazardous = potentiallyHazardous;
    }

    public List<ApproachData> getApproachData() {
        return approachData;
    }

    public void setApproachData(List<ApproachData> approachData) {
        this.approachData = approachData;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
