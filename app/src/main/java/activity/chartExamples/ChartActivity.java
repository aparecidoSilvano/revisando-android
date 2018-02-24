package activity.chartExamples;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.silva.praticando_layouts.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        // in this example, a LineChart is initialized from xml
        LineChart chart = findViewById(R.id.chart);

        List<Entry> entries = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(i, 11);
            entries.add(new Entry(i, randomNum));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Values"); // add entries to dataset
        dataSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);

        dataSet.setColor(R.color.colorPrimary);
        dataSet.setValueTextColor(R.color.colorAccent);

        LimitLine ll = new LimitLine(11, "Critical Blood Pressure");
        ll.setLineColor(Color.RED);
        ll.setLineWidth(4f);
        ll.setTextColor(Color.BLACK);
        ll.setTextSize(12f);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);

        YAxis aYRight = chart.getAxisRight();
        aYRight.setDrawGridLines(false);

        YAxis aYLeft = chart.getAxisLeft();
        aYLeft.setDrawLabels(false);
        aYLeft.addLimitLine(ll);

        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(false);

        chart.setScaleEnabled(false);

        chart.invalidate(); // refresh
    }
}
