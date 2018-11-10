package com.mysummary.myproject.android_basis.recyclerview.swiperefresh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mysummary.myproject.R;
import com.mysummary.myproject.android_basis.recyclerview.GpBean;
import com.mysummary.myproject.android_basis.recyclerview.swiperefresh.SwipeRefreshActivity;

import java.util.List;

/**
 * Created by xingzhi on 2018/7/18.
 */

public class ListViewAdapter extends BaseAdapter {


    private Context context;
    private List<GpBean.IndustryCountListBean> list;

    public ListViewAdapter(List<GpBean.IndustryCountListBean> myProjectList, Context context) {
        this.list = myProjectList;
        this.context = context;

    }

    @Override
    public int getCount() {

        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_recyler_view,parent,false);
            holder.tv = convertView.findViewById(R.id.tv);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tv.setText(list.get(position).getIndustryName());

        return convertView;
    }

    public void setData(List<GpBean.IndustryCountListBean> data) {
        this.list = data;
        notifyDataSetChanged();
    }

    class ViewHolder{
        TextView tv ;
    }
}
