package com.mysummary.myproject.android_basis.event_dispatch.nestscrollrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.mysummary.myproject.R;

import java.util.ArrayList;

/**
 * Created by xingzhi on 2018/8/23.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<String> list ;
    Context context ;

    public RecyclerViewAdapter(ArrayList<String> list, Context context){
        this.list = list ;
        this.context = context ;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_scroll_list_view,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

   public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;

        public ViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv);
        }
    }

}
