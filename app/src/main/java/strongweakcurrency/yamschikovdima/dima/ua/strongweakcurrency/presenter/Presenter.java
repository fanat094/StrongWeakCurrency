package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.presenter;


import android.util.Log;

import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.api.App;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.D1;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.GetStrongWeakCurrencyModel;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.H1;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.H4;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.M15;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.view.GraphViewStrongWeak;

public class Presenter {

    List<M15> mListt;
    List<H1> h1List;
    List<H4> h4List;
    List<D1> d1List;
    BarGraphSeries<DataPoint> series;

    private GraphViewStrongWeak view;

    public void attachView(GraphViewStrongWeak view) {
        this.view = view;
    }

    public void M15_graph_content() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                Log.d("StrongWeakLog", response.body().getM15().get(0).getValue().toString());

                if (response.body().getM15().size() > 0) {

                    mListt = new ArrayList<>();
                    mListt = response.body().getM15();
                    Log.d("NEWSrrrr", "" + mListt.get(1).getValue());
                    Log.d("NEWSrrrrSize", "" + mListt.size());

                    series = new BarGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, mListt.get(0).getValue()),
                            new DataPoint(1, mListt.get(1).getValue()),
                            new DataPoint(2, mListt.get(2).getValue()),
                            new DataPoint(3, mListt.get(3).getValue()),
                            new DataPoint(4, mListt.get(4).getValue()),
                            new DataPoint(5, mListt.get(5).getValue()),
                            new DataPoint(6, mListt.get(6).getValue()),
                            new DataPoint(7, mListt.get(7).getValue())
                    });

                    view.get_M15_graph_content(series);

                }

            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {

            }
        });
    }

    public void H1_graph_content() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getH1().size() > 0) {

                    h1List = new ArrayList<>();
                    h1List = response.body().getH1();
                    Log.d("NEWSrrrr2", "" + h1List.get(1).getValue());
                    Log.d("NEWSrrrrSize", "" + h1List.size());

                    series = new BarGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, h1List.get(0).getValue()),
                            new DataPoint(1, h1List.get(1).getValue()),
                            new DataPoint(2, h1List.get(2).getValue()),
                            new DataPoint(3, h1List.get(3).getValue()),
                            new DataPoint(4, h1List.get(4).getValue()),
                            new DataPoint(5, h1List.get(5).getValue()),
                            new DataPoint(6, h1List.get(6).getValue()),
                            new DataPoint(7, h1List.get(7).getValue())
                    });

                    view.get_H1_graph_content(series);

                }

            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {

            }
        });
    }

    public void H4_graph_content() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getH1().size() > 0) {

                    h4List = new ArrayList<>();
                    h4List = response.body().getH4();
                    Log.d("NEWSrrrr2", "" + h4List.get(1).getValue());
                    Log.d("NEWSrrrrSize", "" + h4List.size());

                    series = new BarGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, h4List.get(0).getValue()),
                            new DataPoint(1, h4List.get(1).getValue()),
                            new DataPoint(2, h4List.get(2).getValue()),
                            new DataPoint(3, h4List.get(3).getValue()),
                            new DataPoint(4, h4List.get(4).getValue()),
                            new DataPoint(5, h4List.get(5).getValue()),
                            new DataPoint(6, h4List.get(6).getValue()),
                            new DataPoint(7, h4List.get(7).getValue())
                    });

                    view.get_H4_graph_content(series);

                }

            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {

            }
        });
    }

    public void D1_graph_content() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getH1().size() > 0) {

                    d1List = new ArrayList<>();
                    d1List = response.body().getD1();
                    Log.d("NEWSrrrr2", "" + d1List.get(1).getValue());
                    Log.d("NEWSrrrrSize", "" + d1List.size());

                    series = new BarGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, d1List.get(0).getValue()),
                            new DataPoint(1, d1List.get(1).getValue()),
                            new DataPoint(2, d1List.get(2).getValue()),
                            new DataPoint(3, d1List.get(3).getValue()),
                            new DataPoint(4, d1List.get(4).getValue()),
                            new DataPoint(5, d1List.get(5).getValue()),
                            new DataPoint(6, d1List.get(6).getValue()),
                            new DataPoint(7, d1List.get(7).getValue())
                    });

                    view.get_D1_graph_content(series);

                }

            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {

            }
        });
    }
}

