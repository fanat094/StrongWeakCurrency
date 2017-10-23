package strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.R;
import strongweakcurrency.yamschikovdima.dima.ua.strongweakcurrency.model.SymbolIndex;


/**
 * Created by user on 07.04.2017.
 */

public class StrongWeakAdapter extends RecyclerView.Adapter<StrongWeakAdapter.MyViewHolder> {

    List<SymbolIndex> symbolIndiceslist;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.timeframe) TextView timeframe; //1-ша колонка таблиці
        @BindView(R.id.strongest) TextView strongest;//2-ша колонка таблиці
        @BindView(R.id.weakest) TextView weakest;//3-ша колонка таблиці
        @BindView(R.id.strongweakpair) TextView strongweakpair;//4-ша колонка таблиці

        public MyViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
        }
    }


    public StrongWeakAdapter(List<SymbolIndex> newsList) {
        this.symbolIndiceslist = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sw_pair_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        SymbolIndex symbolIndex = symbolIndiceslist.get(position);
        holder.timeframe.setText(symbolIndex.getTimeFrame());
        holder.strongest.setText(symbolIndex.getStrongest());
        holder.weakest.setText(symbolIndex.getWeakest());
        holder.strongweakpair.setText(symbolIndex.getStrongWeakPair());
    }

    @Override
    public int getItemCount() {
        return symbolIndiceslist.size();
    }
}