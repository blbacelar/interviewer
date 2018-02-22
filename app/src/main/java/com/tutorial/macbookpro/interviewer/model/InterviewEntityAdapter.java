package com.tutorial.macbookpro.interviewer.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.tutorial.macbookpro.interviewer.R;

import java.util.ArrayList;

/**
 * Created by macbookpro on 2017-10-23.
 */

public class InterviewEntityAdapter extends RecyclerView.Adapter<InterviewEntityAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<QuestionEntity> mDataSource;
    PostItemListener postItemListener;

    public interface PostItemListener {
        void onOption1(int id);
        void onOption2(int id);
        void onOption3(int id);
        void onOption4(int id);
    }

    public void setCustomButtonListner(PostItemListener listener) {
        this.postItemListener = listener;
    }

    public InterviewEntityAdapter(Context mContext, ArrayList<QuestionEntity>  mDataSource) {
        this.mContext = mContext;
        this.mDataSource = mDataSource;
    }

    // the view holder is defined as a inner class inside your class - RULE
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView questionTextView;
        public RadioButton rdbOption1, rdbOption2, rdbOption3, rdbOption4;

        public MyViewHolder(View view) {
            super(view);
//
            questionTextView = (TextView) view.findViewById(R.id.edtQuestion);
            rdbOption1 = (RadioButton) view.findViewById(R.id.rdb1);
            rdbOption2 = (RadioButton) view.findViewById(R.id.rdb2);
            rdbOption3 = (RadioButton) view.findViewById(R.id.rdb3);
            rdbOption4 = (RadioButton) view.findViewById(R.id.rdb4);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.question_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        final QuestionEntity interviewquestion = mDataSource.get(position);
//
        TextView questionTextView = holder.questionTextView;
        RadioButton rdbOption1 = holder.rdbOption1;
        RadioButton rdbOption2 = holder.rdbOption2;
        RadioButton rdbOption3 = holder.rdbOption3;
        RadioButton rdbOption4 = holder.rdbOption4;

        holder.questionTextView.setText(interviewquestion.getDescription());
        holder.rdbOption1.setText(interviewquestion.getOption().get(0));
        holder.rdbOption2.setText(interviewquestion.getOption().get(1));
        holder.rdbOption3.setText(interviewquestion.getOption().get(2));
        holder.rdbOption4.setText(interviewquestion.getOption().get(3));

        // on ckeck
        holder.rdbOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (postItemListener != null) {
                    postItemListener.onOption1(interviewquestion.questionId);
                }
            }
        });

        holder.rdbOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (postItemListener != null) {
                    postItemListener.onOption2(interviewquestion.questionId);
                }
            }
        });

        holder.rdbOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (postItemListener != null) {
                    postItemListener.onOption3(interviewquestion.questionId);
                }
            }
        });

        holder.rdbOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (postItemListener != null) {
                    postItemListener.onOption4(interviewquestion.questionId);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    public void updateQuestions(ArrayList<QuestionEntity> items) {
        mDataSource = items;
        notifyDataSetChanged();
    }

//    private QuestionEntity getItem(int adapterPosition) {
//        return mDataSource.getQuestion()[adapterPosition];
//    }

}
