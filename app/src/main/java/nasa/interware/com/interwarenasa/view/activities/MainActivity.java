package nasa.interware.com.interwarenasa.view.activities;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.dflabs.lib.interfaces.OnLoadMoreItems;
import io.dflabs.lib.interfaces.OnRefreshItems;
import io.dflabs.lib.mvp.BaseActivity;
import io.dflabs.lib.mvp.BasePresenter;
import io.dflabs.lib.ui.SuperRecyclerView2;
import nasa.interware.com.interwarenasa.R;
import nasa.interware.com.interwarenasa.background.ws.responses.NearObjectsResponse;
import nasa.interware.com.interwarenasa.model.pojos.NearObject;
import nasa.interware.com.interwarenasa.presenter.callbacks.MainCallback;
import nasa.interware.com.interwarenasa.presenter.implementations.MainPresenter;
import nasa.interware.com.interwarenasa.view.adapters.NearObjectsAdapter;

public class MainActivity extends BaseActivity implements MainCallback, OnLoadMoreItems, OnRefreshItems {

    private MainPresenter mMainPresenter;

    @BindView(R.id.act_main_near_objects_recycler_view)
    ViewGroup mObjectsRecyclerView;

    private SuperRecyclerView2 mRecyclerViewObjects;
    private NearObjectsAdapter mNearObjectsAdapter;

    private boolean loadMoreItems = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null){
            ab.setTitle("");
            ab.setDisplayHomeAsUpEnabled(false);
            ab.setHomeButtonEnabled(false);
        }


        mNearObjectsAdapter = new NearObjectsAdapter(this);

        mRecyclerViewObjects = new SuperRecyclerView2.Builder(this)
                .adapter(mNearObjectsAdapter)
                .animator(new DefaultItemAnimator())
                .layoutManager(new LinearLayoutManager(this))
                .endlessScroll(true, this)
                .pullToRefresh(true, this)
                .inflateIn(mObjectsRecyclerView);

        mRecyclerViewObjects.startRefreshing();

    }

    @Override
    protected BasePresenter getPresenter() {
        return mMainPresenter = new MainPresenter(this, this);
    }


    @Override
    public void onErrorConnection() {
        Toast.makeText(this, R.string.dialog_error_connection, Toast.LENGTH_SHORT).show();
        mRecyclerViewObjects.endRefreshing();
    }

    @Override
    public void onErrorDownload() {
        Toast.makeText(this, R.string.dialog_error_download, Toast.LENGTH_SHORT).show();
        mRecyclerViewObjects.endRefreshing();
    }

    @Override
    public void onSuccessDownloadInfo(NearObjectsResponse body) {
        List<NearObject> values = new ArrayList<>();

        for (List<NearObject> item : body.getNearObjects().values()) {
            String date = (String) getKeyFromValue(body.getNearObjects(), item);
            for ( NearObject object : item){
                object.setDate(date);
                values.add(object);
            }
        }
        mNearObjectsAdapter.update(values, loadMoreItems);
        mRecyclerViewObjects.endRefreshing();
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void onLoadMoreItems(int currentPage) {
        loadMoreItems = true;
        mMainPresenter.addDay();
    }

    @Override
    public void onRefresh() {
        loadMoreItems = false;
        mMainPresenter.nearObjects();
    }
}
