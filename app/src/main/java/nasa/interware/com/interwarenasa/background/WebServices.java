package nasa.interware.com.interwarenasa.background;

import java.util.concurrent.TimeUnit;

import nasa.interware.com.interwarenasa.background.ws.Urls;
import nasa.interware.com.interwarenasa.background.ws.definitions.ApiV1Definition;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by danielgarcia on 7/23/16.
 * Senasica-Android
 */
public class WebServices {

    static ApiV1Definition apiV1Definition;

    static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .writeTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build();

    public static ApiV1Definition apiV1() {
        if (apiV1Definition == null) {
            setupApiV1();
        }
        return apiV1Definition;
    }

    public static void setApiV1Definition(ApiV1Definition apiV1Definition) {
        WebServices.apiV1Definition = apiV1Definition;
    }

    private static void setupApiV1() {
        if (!Urls.API.isEmpty()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Urls.API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiV1Definition = retrofit.create(ApiV1Definition.class);
        }
    }

}
