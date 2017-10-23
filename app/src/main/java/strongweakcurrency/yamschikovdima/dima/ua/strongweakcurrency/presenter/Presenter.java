package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.presenter;


import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

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
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.SymbolIndex;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.spreference.SharedPreferencesSafe;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.view.GraphViewStrongWeak;

public class Presenter {

    List<M15> m15mList;
    List<H1> h1List;
    List<H4> h4List;
    List<D1> d1List;
    List<SymbolIndex> si1List;
    BarGraphSeries<DataPoint> series;

    PointsGraphSeries<DataPoint> seriesM15;
    PointsGraphSeries<DataPoint> seriesH1;
    PointsGraphSeries<DataPoint> seriesH4;
    PointsGraphSeries<DataPoint> seriesD1;

    private GraphViewStrongWeak view;

    public void attachView(GraphViewStrongWeak view) {
        this.view = view;
    }

    public void M15_graph_content() { //запит даних для діаграми M15

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getM15().size() > 0) {

                    m15mList = new ArrayList<>();
                    m15mList = response.body().getM15();

                    series = new BarGraphSeries<>(new DataPoint[]{ //заповнення вісі ординат значеннями
                            new DataPoint(0, m15mList.get(0).getValue()),
                            new DataPoint(1, m15mList.get(1).getValue()),
                            new DataPoint(2, m15mList.get(2).getValue()),
                            new DataPoint(3, m15mList.get(3).getValue()),
                            new DataPoint(4, m15mList.get(4).getValue()),
                            new DataPoint(5, m15mList.get(5).getValue()),
                            new DataPoint(6, m15mList.get(6).getValue()),
                            new DataPoint(7, m15mList.get(7).getValue())
                    });


                    view.get_M15_graph_content(series, M15convertoStringArr(m15mList));

                }
            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {
                view.stfull();
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


                    view.get_H1_graph_content(series, H1convertoStringArr(h1List));

                }
            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {
                view.stfull();
            }
        });
    }

    public void H4_graph_content() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getH4().size() > 0) {

                    h4List = new ArrayList<>();
                    h4List = response.body().getH4();


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


                    view.get_H4_graph_content(series, H4convertoStringArr(h4List));

                }
            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {
                view.stfull();
            }
        });
    }

    public void D1_graph_content() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getD1().size() > 0) {

                    d1List = new ArrayList<>();
                    d1List = response.body().getD1();


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


                    view.get_D1_graph_content(series, convertoStringArr(d1List));

                }
            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {
                view.stfull();
            }
        });
    }

    public void Aggregate_graph_content() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getM15().size() > 0) {

                    m15mList = new ArrayList<>();
                    m15mList = response.body().getM15();

                    seriesM15 = new PointsGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, m15mList.get(0).getValue()),
                            new DataPoint(1, m15mList.get(1).getValue()),
                            new DataPoint(2, m15mList.get(2).getValue()),
                            new DataPoint(3, m15mList.get(3).getValue()),
                            new DataPoint(4, m15mList.get(4).getValue()),
                            new DataPoint(5, m15mList.get(5).getValue()),
                            new DataPoint(6, m15mList.get(6).getValue()),
                            new DataPoint(7, m15mList.get(7).getValue())
                    });

                }

                if (response.body().getH1().size() > 0) {

                    h1List = new ArrayList<>();
                    h1List = response.body().getH1();

                    seriesH1 = new PointsGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, h1List.get(0).getValue()),
                            new DataPoint(1, h1List.get(1).getValue()),
                            new DataPoint(2, h1List.get(2).getValue()),
                            new DataPoint(3, h1List.get(3).getValue()),
                            new DataPoint(4, h1List.get(4).getValue()),
                            new DataPoint(5, h1List.get(5).getValue()),
                            new DataPoint(6, h1List.get(6).getValue()),
                            new DataPoint(7, h1List.get(7).getValue())
                    });

                }

                if (response.body().getH4().size() > 0) {

                    h4List = new ArrayList<>();
                    h4List = response.body().getH4();

                    seriesH4 = new PointsGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, h4List.get(0).getValue()),
                            new DataPoint(1, h4List.get(1).getValue()),
                            new DataPoint(2, h4List.get(2).getValue()),
                            new DataPoint(3, h4List.get(3).getValue()),
                            new DataPoint(4, h4List.get(4).getValue()),
                            new DataPoint(5, h4List.get(5).getValue()),
                            new DataPoint(6, h4List.get(6).getValue()),
                            new DataPoint(7, h4List.get(7).getValue())
                    });

                }

                if (response.body().getD1().size() > 0) {

                    d1List = new ArrayList<>();
                    d1List = response.body().getD1();

                    seriesD1 = new PointsGraphSeries<>(new DataPoint[]{
                            new DataPoint(0, d1List.get(0).getValue()),
                            new DataPoint(1, d1List.get(1).getValue()),
                            new DataPoint(2, d1List.get(2).getValue()),
                            new DataPoint(3, d1List.get(3).getValue()),
                            new DataPoint(4, d1List.get(4).getValue()),
                            new DataPoint(5, d1List.get(5).getValue()),
                            new DataPoint(6, d1List.get(6).getValue()),
                            new DataPoint(7, d1List.get(7).getValue())
                    });

                }
                view.get_Aggregate_graph_content(seriesM15, seriesH1, seriesH4, seriesD1);

            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {
                view.stfull();
            }
        });
    }

    public void SymbolIndex_graph_content() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getSymbolIndices().size() > 0) {

                    si1List = new ArrayList<>();
                    si1List = response.body().getSymbolIndices();

                    view.get_SymbolIndex(si1List);

                }
            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {
                view.stfull();
            }
        });
    }

    //Service

    public void M15_graph_service() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getM15().size() > 0) {

                    m15mList = new ArrayList<>();
                    m15mList = response.body().getM15();
                }

                new SharedPreferencesSafe().sp_M15graph(App.getContext(), m15mList);
            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {


            }
        });
    }

    public void H1_graph_service() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getH1().size() > 0) {

                    h1List = new ArrayList<>();
                    h1List = response.body().getH1();
                }

                new SharedPreferencesSafe().sp_H1graph(App.getContext(), h1List);
            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {


            }
        });
    }

    public void H4_graph_service() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getH4().size() > 0) {

                    h4List = new ArrayList<>();
                    h4List = response.body().getH4();
                }

                new SharedPreferencesSafe().sp_H4graph(App.getContext(), h4List);
            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {


            }
        });
    }

    public void D1_graph_service() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getD1().size() > 0) {

                    d1List = new ArrayList<>();
                    d1List = response.body().getD1();
                }

                    new SharedPreferencesSafe().sp_D1graph(App.getContext(), d1List);
            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {


            }
        });
    }

    public void SymbolIndex_graph_service() {

        App.getApi().getStrongWeakCurrencyModel().enqueue(new Callback<GetStrongWeakCurrencyModel>() {
            @Override
            public void onResponse(Call<GetStrongWeakCurrencyModel> call, Response<GetStrongWeakCurrencyModel> response) {

                if (response.body().getSymbolIndices().size() > 0) {

                    si1List = new ArrayList<>();
                    si1List = response.body().getSymbolIndices();

                    new SharedPreferencesSafe().sp_SymbolIndexgraph(App.getContext(), si1List);

                }
            }

            @Override
            public void onFailure(Call<GetStrongWeakCurrencyModel> call, Throwable t) {
                view.stfull();
            }
        });
    }


    public String [] M15convertoStringArr (List<M15> list){ //конвертація List<Object> в String[] масив для діаграми  Ь15
        //для вісі ординат

        List<String> arrvalue = new ArrayList<>(list.size());
        for (int i=0; i<list.size(); i++) {

            arrvalue.add(list.get(i).getKey());
        }
        String[] stringArray = arrvalue.toArray(new String[0]);

        return stringArray;
    }

    public String [] H1convertoStringArr (List<H1> list){

        List<String> arrvalue = new ArrayList<>(list.size());
        for (int i=0; i<list.size(); i++) {

            arrvalue.add(list.get(i).getKey());
        }
        String[] stringArray = arrvalue.toArray(new String[0]);

        return stringArray;
    }

    public String [] H4convertoStringArr (List<H4> list){

        List<String> arrvalue = new ArrayList<>(list.size());
        for (int i=0; i<list.size(); i++) {

            arrvalue.add(list.get(i).getKey());
        }
        String[] stringArray = arrvalue.toArray(new String[0]);

        return stringArray;
    }

    public String [] convertoStringArr (List<D1> list){

        List<String> arrvalue = new ArrayList<>(list.size());
        for (int i=0; i<list.size(); i++) {

            arrvalue.add(list.get(i).getKey());
        }
        String[] stringArray = arrvalue.toArray(new String[0]);

        return stringArray;
    }


}

