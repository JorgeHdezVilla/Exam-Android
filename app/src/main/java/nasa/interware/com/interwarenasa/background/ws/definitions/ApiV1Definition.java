package nasa.interware.com.interwarenasa.background.ws.definitions;

import nasa.interware.com.interwarenasa.background.ws.responses.NearObjectsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by danielgarcia on 7/23/16.
 * Senasica-Android
 */
public interface ApiV1Definition {

    @GET("/neo/rest/v1/feed?")
    Call<NearObjectsResponse> nearObjects(@Query("start_date") String startDate,
                                          @Query("end_date") String endDate,
                                          @Query("api_key") String apiKey);

}
