package activity.chartExamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.silva.praticando_layouts.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.ChartLineAdapter;
import model.ChartModel;
import model.ChartType;

public class ListChartsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_charts);

        mRecyclerView = findViewById(R.id.recycler_view_charts);

        setupRecycle();
    }

    private void setupRecycle() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        ChartLineAdapter mAdapter = new ChartLineAdapter(getChartModels(), mRecyclerView, this);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private List<ChartModel> getChartModels() {
        List<ChartModel> charts = new ArrayList<>();

        charts.add(new ChartModel("Chart line", "simple line chart example", ChartType.LINE_CHART));

        return charts;
    }
}