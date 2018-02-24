package model;

public class ChartModel {
    private String title;
    private String description;
    private ChartType chartType;

    public ChartModel(String title, String description, ChartType chartType) {
        this.title = title;
        this.description = description;
        this.chartType = chartType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ChartType getChartType() {
        return chartType;
    }

    public void setChartType(ChartType chartType) {
        this.chartType = chartType;
    }
}
