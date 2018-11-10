package com.mysummary.myproject.android_basis.recyclerview.swiperefresh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.recyclerview.GpBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingzhi on 2018/7/11.
 */

public class RecyclerAdapterOne extends RecyclerView.Adapter<RecyclerAdapterOne.ViewHolder> {

    private Context context ;
    private  List<GpBean.IndustryCountListBean>  list ;

    public RecyclerAdapterOne(List<GpBean.IndustryCountListBean> myProjectList, Context context) {
        this.context = context;
        this.list = myProjectList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyler_view,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getIndustryName());
    }

    @Override
    public int getItemCount() {

        return list==null?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv ;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_projectName);

        }
    }

    public void setData(List<GpBean.IndustryCountListBean> datas) {
        this.list = null == datas ? new ArrayList<GpBean.IndustryCountListBean>() : datas;
        this.notifyDataSetChanged();
    }
}
