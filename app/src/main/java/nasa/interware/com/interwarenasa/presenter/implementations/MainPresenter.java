package nasa.interware.com.interwarenasa.presenter.implementations;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import io.dflabs.lib.mvp.BasePresenter;
import io.dflabs.lib.utils.ConnectionUtils;
import nasa.interware.com.interwarenasa.background.WebServices;
import nasa.interware.com.interwarenasa.background.ws.responses.NearObjectsResponse;
import nasa.interware.com.interwarenasa.library.utils.Constants;
import nasa.interware.com.interwarenasa.presenter.callbacks.MainCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by jorge.hernandez on 22/11/2016.
 * Nasa
 */

public class MainPresenter extends BasePresenter {

    private MainCallback mMainCallback;
    private NearObjectsResponse objectsResponse;
    private String dateNowString;
    private Date dateNow;

    public MainPresenter(Context context, MainCallback mMainCallback) {
        super(context);
        this.mMainCallback = mMainCallback;

        dateNow = new Date();
        dateNowString = new SimpleDateFormat("yyyy-MM-dd").format(dateNow);
    }

    public void nearObjects() {
        if (ConnectionUtils.isConnected(context)) {

            Call<NearObjectsResponse> callDSearchDatabase = WebServices.apiV1().nearObjects(dateNowString, dateNowString, Constants.API_KEY);
            callDSearchDatabase.enqueue(new Callback<NearObjectsResponse>() {
                @Override
                public void onResponse(Call<NearObjectsResponse> call, Response<NearObjectsResponse> response) {
                    if (response.isSuccessful()) {
                        objectsResponse = response.body();
                        mMainCallback.onSuccessDownloadInfo(objectsResponse);
                    } else {
                        mMainCallback.onErrorDownload();
                    }
                }

                @Override
                public void onFailure(Call<NearObjectsResponse> call, Throwable t) {
                    t.printStackTrace();
                    mMainCallback.onErrorDownload();
                }
            });
        } else {
            mMainCallback.onErrorConnection();
        }
    }

    public void addDay() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateNow);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        dateNow = cal.getTime();
        dateNowString = new SimpleDateFormat("yyyy-MM-dd").format(dateNow);
        nearObjects();
    }


}
