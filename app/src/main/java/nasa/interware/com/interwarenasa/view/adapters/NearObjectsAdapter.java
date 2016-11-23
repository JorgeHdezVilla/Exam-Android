package nasa.interware.com.interwarenasa.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.dflabs.lib.adapters.RecyclerListAdapter;
import nasa.interware.com.interwarenasa.R;
import nasa.interware.com.interwarenasa.model.pojos.ApproachData;
import nasa.interware.com.interwarenasa.model.pojos.NearObject;

/**
 * Created by jorge.hernandez on 12/08/2016.
 * Nasa
 */
public class NearObjectsAdapter extends RecyclerListAdapter<NearObject, NearObjectsAdapter.ObjectViewHolder> {

    private Context context;

    public NearObjectsAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected int getItemType(int position) {
        return 0;
    }

    @Override
    protected void onBindViewHolder(ObjectViewHolder holder, int position, NearObject item) {
        holder.mNameTextView.setText(item.getName());
        holder.mReferenceTextView.setText(item.getNeoReferenceId());
        holder.mDateTextView.setText(item.getDate());

        holder.mKilometersTextView.setText(String.format(Locale.getDefault(), "Min: %.2f - Max: %.2f",
                item.getDiameters().getKilometers().getEstimatedDiameterMin(),
                item.getDiameters().getKilometers().getEstimatedDiameterMax()));

        holder.mMetersTextView.setText(String.format(Locale.getDefault(), "Min: %.2f - Max: %.2f",
                item.getDiameters().getMeters().getEstimatedDiameterMin(),
                item.getDiameters().getMeters().getEstimatedDiameterMax()));

        holder.mMilesTextView.setText(String.format(Locale.getDefault(), "Min: %.2f - Max: %.2f",
                item.getDiameters().getMiles().getEstimatedDiameterMin(),
                item.getDiameters().getMiles().getEstimatedDiameterMax()));

        holder.mfeetTextView.setText(String.format(Locale.getDefault(), "Min: %.2f - Max: %.2f",
                item.getDiameters().getFeet().getEstimatedDiameterMin(),
                item.getDiameters().getFeet().getEstimatedDiameterMax()));


        holder.mPotenciallyHazardousTextView.setText(item.getPotentiallyHazardous() ? "Sí" : "No");

        if (item.getApproachData().size() > 0){
            ApproachData data = item.getApproachData().get(0);
            DecimalFormat formatter = new DecimalFormat("#,###.00");

            holder.mKmSecondTextView.setText(
                    formatter.format(Double.parseDouble(data.getRelativeVelocity().getKilometersSecond()))
            );

            holder.mKmHourTextView.setText(
                    formatter.format(Double.parseDouble(data.getRelativeVelocity().getKilometersHour()))
            );

            holder.mMilesHourTextView.setText(
                    formatter.format(Double.parseDouble(data.getRelativeVelocity().getMilesHour()))
            );

            holder.mApproachDateTextView.setText(data.getCloseApproachDate());

            holder.mAstronomicalDistanceTextView.setText(
                    formatter.format(Double.parseDouble(data.getMissDistance().getAstronomical()))
            );
            holder.mLunarDistanceTextView.setText(
                    formatter.format(Double.parseDouble(data.getMissDistance().getLunar()))
            );
            holder.mKilometersDistanceTextView.setText(
                    formatter.format(Double.parseDouble(data.getMissDistance().getKilometers()))
            );
            holder.mMilesDistanceTextView.setText(
                    formatter.format(Double.parseDouble(data.getMissDistance().getMiles()))
            );
        }

    }

    @Override
    protected ObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType, RecyclerView recyclerView) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_near_object, parent, false);
        return new ObjectViewHolder(view);
    }

    public class ObjectViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_near_object_date)
        TextView mDateTextView;

        @BindView(R.id.item_near_object_name)
        TextView mNameTextView;
        @BindView(R.id.item_near_object_reference)
        TextView mReferenceTextView;

        @BindView(R.id.item_near_object_kilometers)
        TextView mKilometersTextView;
        @BindView(R.id.item_near_object_meters)
        TextView mMetersTextView;
        @BindView(R.id.item_near_object_miles)
        TextView mMilesTextView;
        @BindView(R.id.item_near_object_feet)
        TextView mfeetTextView;
        @BindView(R.id.item_near_object_km_second)
        TextView mKmSecondTextView;
        @BindView(R.id.item_near_object_km_hour)
        TextView mKmHourTextView;
        @BindView(R.id.item_near_object_miles_hour)
        TextView mMilesHourTextView;

        @BindView(R.id.item_near_object_potencially_hazardous)
        TextView mPotenciallyHazardousTextView;
        @BindView(R.id.item_near_object_approach_date)
        TextView mApproachDateTextView;
        @BindView(R.id.item_near_object_astronomical_distance)
        TextView mAstronomicalDistanceTextView;
        @BindView(R.id.item_near_object_lunar_distance)
        TextView mLunarDistanceTextView;
        @BindView(R.id.item_near_object_kilometers_distance)
        TextView mKilometersDistanceTextView;
        @BindView(R.id.item_near_object_miles_distance)
        TextView mMilesDistanceTextView;


        ObjectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}