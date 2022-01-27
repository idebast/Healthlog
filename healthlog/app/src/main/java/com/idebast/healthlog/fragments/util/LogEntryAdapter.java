package com.idebast.healthlog.fragments.util;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.idebast.healthlog.R;
import com.idebast.healthlog.model.LogEntry;



public class LogEntryAdapter extends RecyclerView.Adapter<LogEntryAdapter.LogEntryViewHolder> {


    class LogEntryViewHolder extends RecyclerView.ViewHolder{

        //final TextView setupTV;
        final TextView tv_Datum2;
        final TextView tv_Time2;
        final TextView tv_Gewicht;
        final TextView tv_Boven;
        final TextView tv_Onder;
        final TextView tv_Pols;
        final TextView tv_Opmerking;
        final TextView tv_mmhg;
        final TextView tv_fwds;
        final TextView tv_kg;
        final TextView tv_bpm;

        public LogEntryViewHolder(@NonNull View itemView) {
            super(itemView);
            //setupTV = itemView.findViewById(R.id.tv_row_log);
            tv_Datum2 = itemView.findViewById(R.id.tv_Datum2);
            tv_Time2 = itemView.findViewById(R.id.tv_Time2);
            tv_Gewicht = itemView.findViewById(R.id.tv_Gewicht);
            tv_Boven = itemView.findViewById(R.id.tv_Boven);
            tv_Onder = itemView.findViewById(R.id.tv_Onder);
            tv_Pols = itemView.findViewById(R.id.tv_pols);
            tv_Opmerking = itemView.findViewById(R.id.tv_Opmerking);
            tv_fwds = itemView.findViewById(R.id.tv_fwds);
            tv_mmhg = itemView.findViewById(R.id.tv_mmhg);
            tv_kg = itemView.findViewById(R.id.tv_kg);
            tv_bpm = itemView.findViewById(R.id.tv_bpm);
        }
    }

    private ArrayList<LogEntry> items;

    public LogEntryAdapter(ArrayList<LogEntry> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public LogEntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.log_row, parent, false);

        return new LogEntryViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull LogEntryViewHolder holder, int position) {
        LogEntry currentLog = items.get(position);

        holder.tv_Datum2.setText(currentLog.getDatum());
        holder.tv_Time2.setText(currentLog.getTime());
        if (currentLog.getGewicht() == 0.0f) {
            holder.tv_Gewicht.setVisibility(View.GONE);
            holder.tv_kg.setVisibility(View.GONE);
        } else {
            holder.tv_Gewicht.setVisibility(View.VISIBLE);
            holder.tv_kg.setVisibility(View.VISIBLE);
            holder.tv_Gewicht.setText(String.valueOf(currentLog.getGewicht()).toString());
        }
        if ( (currentLog.getBovendruk() == 0) || (currentLog.getOnderdruk() == 0) ){
            holder.tv_Boven.setVisibility(View.GONE);
            holder.tv_Onder.setVisibility(View.GONE);
            holder.tv_mmhg.setVisibility(View.GONE);
        } else {
            holder.tv_Boven.setVisibility(View.VISIBLE);
            holder.tv_Onder.setVisibility(View.VISIBLE);
            holder.tv_mmhg.setVisibility(View.VISIBLE);
            holder.tv_Boven.setText(String.valueOf(currentLog.getBovendruk()).toString());
            holder.tv_Onder.setText(String.valueOf(currentLog.getOnderdruk()).toString());
        }

        if (currentLog.getPols() == 0) {
            holder.tv_Pols.setVisibility(View.GONE);
            holder.tv_bpm.setVisibility(View.GONE);
        } else {
            holder.tv_Pols.setVisibility(View.VISIBLE);
            holder.tv_bpm.setVisibility(View.VISIBLE);
            holder.tv_Pols.setText(String.valueOf(currentLog.getPols()).toString());
        }

        holder.tv_Opmerking.setText(currentLog.getComment());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
