package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.silva.praticando_layouts.R;

import java.util.List;

import activity.chartExamples.ChartActivity;
import model.ChartModel;

public class ChartLineAdapter extends RecyclerView.Adapter<LineHolder> {
    private final List<ChartModel> mCharts;
    private final RecyclerView mRecyclerView;
    private final Context mContext;

    public ChartLineAdapter(List<ChartModel> charts, RecyclerView recyclerView, Context contex) {
        mCharts = charts;
        mRecyclerView = recyclerView;
        mContext = contex;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_line_view, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View clickedView) {
                int position = mRecyclerView.getChildAdapterPosition(clickedView);
                ChartModel chartClicked = mCharts.get(position);

                switch (chartClicked.getChartType()) {
                    case LINE_CHART:
                        mContext.startActivity(new Intent(mContext, ChartActivity.class));
                }
            }
        });

        return new LineHolder(view);
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.title.setText(mCharts.get(position).getTitle());
        holder.subTitle.setText(mCharts.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mCharts != null ? mCharts.size() : 0;
    }
}
