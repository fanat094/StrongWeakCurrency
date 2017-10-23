package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gturedi.views.StatefulLayout;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.adapter.StrongWeakAdapter;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.SymbolIndex;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.presenter.Presenter;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.service.StrongWeakService;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.view.GraphViewStrongWeak;

public class MainActivity extends AppCompatActivity implements GraphViewStrongWeak {

    @BindView(R.id.M15graph) GraphView M15_graph; //діаграма M15
    @BindView(R.id.H1graph) GraphView H1_graph; //діаграма H1
    @BindView(R.id.H4graph) GraphView H4_graph; //діаграма H4
    @BindView(R.id.D1graph) GraphView D1_graph; //діаграма D1
    @BindView(R.id.Aggregategraph) GraphView Aggregate_graph; //графік Aggregate
    @BindView(R.id.stateful_view) StatefulLayout st; //progress view
    @BindView(R.id.sw_recycler_view) RecyclerView sw_recycler_view; //rv для таблиці Time Frame, ...

    Presenter presenter;
    private StrongWeakAdapter swAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter();
        presenter.attachView(this);

        presenter.M15_graph_content(); //зверенння до презентера за даними для діаграми M15
        presenter.H1_graph_content(); //зверенння до презентера за даними для діаграми H1
        presenter.H4_graph_content(); ////зверенння до презентера за даними для діаграми H4
        presenter.D1_graph_content(); ////зверенння до презентера за даними для діаграми D1
        presenter.Aggregate_graph_content(); ////зверенння до презентера за даними для діаграми Aggregate
        presenter.SymbolIndex_graph_content(); ////зверенння до презентера за даними для табблиці SymbolIndex

        st.showLoading();//progress view старт

       StrongWeakService.setServiceAlarm(this, true); //старт сервісу

    }

    @Override
    public void get_M15_graph_content(BarGraphSeries<DataPoint> graphlist, String[] stringArray) {

        M15_graph.addSeries(graphlist); //вісь ординат діаграми
        M15_graph.setTitle(getResources().getString(R.string.title_M15_graph));
        graphlist.setSpacing(20);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(M15_graph);
        staticLabelsFormatter.setHorizontalLabels(stringArray); //вісь абсцис діаграми
        M15_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        st.showContent();//відображженя конетенту

    }


    @Override
    public void get_H1_graph_content(BarGraphSeries<DataPoint> graphlist, String[] stringArray) {

        H1_graph.addSeries(graphlist);
        H1_graph.setTitle(getResources().getString(R.string.title_H1_graph));
        graphlist.setSpacing(20);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(H1_graph);
        staticLabelsFormatter.setHorizontalLabels(stringArray);
        H1_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        st.showContent();
    }

    @Override
    public void get_H4_graph_content(BarGraphSeries<DataPoint> graphlist, String[] stringArray) {

        H4_graph.addSeries(graphlist);
        H4_graph.setTitle(getResources().getString(R.string.title_H4_graph));
        graphlist.setSpacing(20);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(H4_graph);
        staticLabelsFormatter.setHorizontalLabels(stringArray);
        H4_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        st.showContent();
    }

    @Override
    public void get_D1_graph_content(BarGraphSeries<DataPoint> graphlist, String[] stringArray) {

        D1_graph.addSeries(graphlist);
        D1_graph.setTitle(getResources().getString(R.string.title_D1_graph));
        graphlist.setSpacing(20);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(D1_graph);
        staticLabelsFormatter.setHorizontalLabels(stringArray);
        D1_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        st.showContent();

    }


    @Override
    public void get_Aggregate_graph_content(PointsGraphSeries<DataPoint> graphlistM15, PointsGraphSeries<DataPoint> graphlistH1,
                                            PointsGraphSeries<DataPoint> graphlistH4,PointsGraphSeries<DataPoint> graphlistD1) {


        graphlistM15.setShape(PointsGraphSeries.Shape.POINT);
        Aggregate_graph.addSeries(graphlistM15);
        graphlistM15.setColor(Color.BLUE); //діаграма M15

        graphlistH1.setShape(PointsGraphSeries.Shape.POINT);
        Aggregate_graph.addSeries(graphlistH1);
        graphlistH1.setColor(Color.RED); //діаграма H1

        graphlistH4.setShape(PointsGraphSeries.Shape.POINT);
        Aggregate_graph.addSeries(graphlistH4);
        graphlistH4.setColor(Color.GREEN); //діаграма H4

        graphlistD1.setShape(PointsGraphSeries.Shape.POINT);
        Aggregate_graph.addSeries(graphlistD1);
        graphlistD1.setColor(Color.MAGENTA); //діаграма D1

        Aggregate_graph.setTitle(getResources().getString(R.string.title_Aggregate_graph));
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(Aggregate_graph);
        staticLabelsFormatter.setHorizontalLabels(getResources().getStringArray(R.array.title_val));
        Aggregate_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        st.showContent();

    }

    @Override
    public void get_SymbolIndex(List<SymbolIndex> symbolIndexarr) {

        swAdapter = new StrongWeakAdapter(symbolIndexarr);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        sw_recycler_view.setLayoutManager(mLayoutManager); //лінійне відображення списку
        sw_recycler_view.setAdapter(swAdapter);
        st.showContent();

    }

    @Override
    public void stfull() {
        st.showEmpty();//якщо запит onFailure
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
