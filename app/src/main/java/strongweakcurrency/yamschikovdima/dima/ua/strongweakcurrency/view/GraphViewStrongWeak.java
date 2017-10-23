package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.view;

import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.List;

import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.SymbolIndex;


public interface GraphViewStrongWeak {

    void get_M15_graph_content(BarGraphSeries<DataPoint> series, String[] stringArray); // view процедура для діаграми M15 (series - значення діагарми, stringArray - найменування )
    void get_H1_graph_content(BarGraphSeries<DataPoint> series, String[] stringArray);
    void get_H4_graph_content(BarGraphSeries<DataPoint> series, String[] stringArray);
    void get_D1_graph_content(BarGraphSeries<DataPoint> series, String[] stringArray);
    void get_Aggregate_graph_content(PointsGraphSeries<DataPoint> graphlistM15, PointsGraphSeries<DataPoint> graphlistH1,
                                     PointsGraphSeries<DataPoint> graphlistH4,PointsGraphSeries<DataPoint> graphlistD1);
    void get_SymbolIndex(List<SymbolIndex> symbolIndexarr);
    void stfull();

}
