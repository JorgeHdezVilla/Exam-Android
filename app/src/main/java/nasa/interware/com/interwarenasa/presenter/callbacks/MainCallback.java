package nasa.interware.com.interwarenasa.presenter.callbacks;


import nasa.interware.com.interwarenasa.background.ws.responses.NearObjectsResponse;

/**
 * Created by jorge.hernandez on 22/11/2016.
 * Nasa
 */
public interface MainCallback {

    void onErrorConnection();

    void onErrorDownload();

    void onSuccessDownloadInfo(NearObjectsResponse body);

}
