package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import butterknife.BindView;
import butterknife.ButterKnife;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.presenter.Presenter;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.view.GraphViewStrongWeak;

public class MainActivity extends AppCompatActivity implements GraphViewStrongWeak {

   @BindView(R.id.M15graph) GraphView M15_graph;
    @BindView(R.id.H1graph) GraphView H1_graph;
    @BindView(R.id.H4graph) GraphView H4_graph;
    @BindView(R.id.D1graph) GraphView D1_graph;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter();
        presenter.attachView(this);

        presenter.M15_graph_content();
        presenter.H1_graph_content();
        presenter.H4_graph_content();
        presenter.D1_graph_content();

       // StrongWeakService.setServiceAlarm(this, true);

    }

    @Override
    public void get_M15_graph_content(BarGraphSeries<DataPoint> graphlist) {

        M15_graph.addSeries(graphlist);
        M15_graph.setTitle(getResources().getString(R.string.title_M15_graph));
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(M15_graph);
        staticLabelsFormatter.setHorizontalLabels(getResources().getStringArray(R.array.title_val));
        M15_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

    }

    @Override
    public void get_H1_graph_content(BarGraphSeries<DataPoint> graphlist) {
        H1_graph.addSeries(graphlist);
        H1_graph.setTitle(getResources().getString(R.string.title_H1_graph));
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(H1_graph);
        staticLabelsFormatter.setHorizontalLabels(getResources().getStringArray(R.array.title_val));
        H1_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
    }

    @Override
    public void get_H4_graph_content(BarGraphSeries<DataPoint> graphlist) {
        H4_graph.addSeries(graphlist);
        H4_graph.setTitle(getResources().getString(R.string.title_H4_graph));
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(H4_graph);
        staticLabelsFormatter.setHorizontalLabels(getResources().getStringArray(R.array.title_val));
        H4_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
    }

    @Override
    public void get_D1_graph_content(BarGraphSeries<DataPoint> graphlist) {
        D1_graph.addSeries(graphlist);
        D1_graph.setTitle(getResources().getString(R.string.title_D1_graph));
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(D1_graph);
        staticLabelsFormatter.setHorizontalLabels(getResources().getStringArray(R.array.title_val));
        D1_graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
    }
}
