package com.example.nian.androiddemo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.nian.androiddemo.R;

/**
 * Created by nian on 22/02/16.
 */
public class TextViewHolder extends RecyclerView.ViewHolder {

    public TextView mTvActivity;

    public TextViewHolder(View itemView) {
        super(itemView);
        mTvActivity = (TextView) itemView.findViewById(R.id.text);
    }
}
