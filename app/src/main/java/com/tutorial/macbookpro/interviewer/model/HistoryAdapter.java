package com.tutorial.macbookpro.interviewer.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tutorial.macbookpro.interviewer.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by macbookpro on 2017-11-02.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder>{

    private Context mContext;
    private ArrayList<HistoryEntity> mDataSource;


    public HistoryAdapter(Context mContext, ArrayList<HistoryEntity>  mDataSource) {
        this.mContext = mContext;
        this.mDataSource = mDataSource;
    }

    // the view holder is defined as a inner class inside your class - RULE
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTopic,txtDate,txtScore;

        public MyViewHolder(View view) {
            super(view);
//
            txtTopic = (TextView) view.findViewById(R.id.txtTopic);
            txtDate = (TextView) view.findViewById(R.id.txtDate);
            txtScore = (TextView) view.findViewById(R.id.txtScore);
        }
    }

    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_layout, parent, false);

        return new HistoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.MyViewHolder holder, final int position) {

        final HistoryEntity historyEntity = mDataSource.get(position);
        String score;
//
        TextView txtTopic = holder.txtTopic;
        TextView txtDate = holder.txtDate;
        TextView txtScore = holder.txtScore;

        txtTopic.setText("Topic: " + historyEntity.getTopic());


        String startDateString = historyEntity.getDate();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date startDate = null;
        try {
            startDate = df.parse(startDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        txtDate.setText("Date: " + formattedDate);

        score = historyEntity.getCorrect().toString();
        score = score + "/" + historyEntity.getTotal().toString();

        txtScore.setText("Score: " + score);
        
    }


    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    public void updateHistory(ArrayList<HistoryEntity> items) {
        mDataSource = items;
        notifyDataSetChanged();
    }

}
