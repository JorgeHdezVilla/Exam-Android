package nasa.interware.com.interwarenasa.model.pojos;

/**
 * Created by jorge.hernandez on 22/11/2016.
 * Nasa
 */

public class EstimatedDiameters {

    private EstimatedDiameter kilometers;
    private EstimatedDiameter meters;
    private EstimatedDiameter miles;
    private EstimatedDiameter feet;

    public EstimatedDiameter getKilometers() {
        return kilometers;
    }

    public void setKilometers(EstimatedDiameter kilometers) {
        this.kilometers = kilometers;
    }

    public EstimatedDiameter getMeters() {
        return meters;
    }

    public void setMeters(EstimatedDiameter meters) {
        this.meters = meters;
    }

    public EstimatedDiameter getMiles() {
        return miles;
    }

    public void setMiles(EstimatedDiameter miles) {
        this.miles = miles;
    }

    public EstimatedDiameter getFeet() {
        return feet;
    }

    public void setFeet(EstimatedDiameter feet) {
        this.feet = feet;
    }
}
