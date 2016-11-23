package nasa.interware.com.interwarenasa.background.ws.responses;


import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

import nasa.interware.com.interwarenasa.model.pojos.Links;
import nasa.interware.com.interwarenasa.model.pojos.NearObject;


/**
 * Created by jorge.hernandez on 22/11/2016.
 * Nasa
 */

public class NearObjectsResponse {

    @SerializedName("links")
    private Links links;
    @SerializedName("element_count")
    private int elementCount;
    @SerializedName("near_earth_objects")
    private Map<String, List<NearObject>> nearObjects;

    public Links getLinks() {
        return links;
    }

    public int getElementCount() {
        return elementCount;
    }

    public Map<String, List<NearObject>> getNearObjects() {
        return nearObjects;
    }
}
