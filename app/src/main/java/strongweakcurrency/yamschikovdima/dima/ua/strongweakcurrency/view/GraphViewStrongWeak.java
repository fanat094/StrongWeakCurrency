package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.view;

import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;


public interface GraphViewStrongWeak {

    void get_M15_graph_content(BarGraphSeries<DataPoint> graphlist);
    void get_H1_graph_content(BarGraphSeries<DataPoint> graphlist);
    void get_H4_graph_content(BarGraphSeries<DataPoint> graphlist);
    void get_D1_graph_content(BarGraphSeries<DataPoint> graphlist);
    void get_Aggregate_graph_content(PointsGraphSeries<DataPoint> graphlistM15, PointsGraphSeries<DataPoint> graphlistH1,
                                     PointsGraphSeries<DataPoint> graphlistH4,PointsGraphSeries<DataPoint> graphlistD1);
}
