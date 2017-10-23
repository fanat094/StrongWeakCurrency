package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.spreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.List;

import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.D1;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.H1;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.H4;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.M15;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.SymbolIndex;

/**
 * Created by 1 on 17.10.2017.
 */

public class SharedPreferencesSafe { //клас запису даних

    final String SAVED_M15_GRAPH = "saved_m15_graph"; //ключ запису даних діаграми M15
    final String SAVED_H1_GRAPH = "saved_h1_graph";
    final String SAVED_H4_GRAPH = "saved_h4_graph";
    final String SAVED_D1_GRAPH = "saved_d1_graph";
    final String SAVED_SYMBOLINDEX_GRAPH = "saved_symbolindex_graph";

    SharedPreferences sPref;
    SharedPreferences.Editor ed;

    public void sp_M15graph(Context context, List<M15> list){ //процедура запису даних діаграми M15

        sPref = PreferenceManager.getDefaultSharedPreferences(context);
        ed = sPref.edit();

        Gson gson = new Gson();

        String json = gson.toJson(list);

        ed.putString(SAVED_M15_GRAPH, json);
        ed.commit();
    }

    public void sp_H1graph(Context context, List<H1> list){

        sPref = PreferenceManager.getDefaultSharedPreferences(context);
        ed = sPref.edit();

        Gson gson = new Gson();

        String json = gson.toJson(list);

        ed.putString(SAVED_H1_GRAPH, json);
        ed.commit();
    }

    public void sp_H4graph(Context context, List<H4> list){

        sPref = PreferenceManager.getDefaultSharedPreferences(context);
        ed = sPref.edit();

        Gson gson = new Gson();

        String json = gson.toJson(list);

        ed.putString(SAVED_H4_GRAPH, json);
        ed.commit();
    }

    public void sp_D1graph(Context context, List<D1> list){

        sPref = PreferenceManager.getDefaultSharedPreferences(context);
        ed = sPref.edit();

        Gson gson = new Gson();

        String json = gson.toJson(list);

        ed.putString(SAVED_D1_GRAPH, json);
        ed.commit();

    }

    public void sp_SymbolIndexgraph(Context context, List<SymbolIndex> list){

        sPref = PreferenceManager.getDefaultSharedPreferences(context);
        ed = sPref.edit();

        Gson gson = new Gson();

        String json = gson.toJson(list);

        ed.putString(SAVED_SYMBOLINDEX_GRAPH, json);
        ed.commit();

    }
}
