package com.mysummary.myproject.android_basis.databinding.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mysummary.myproject.android_basis.databinding.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingzhi on 2018/8/14.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    public static final int ITEM_VIEW_TYPE_ON = 1;
    public static final int ITEM_VIEW_TYPE_OFF = 2;

    private LayoutInflater inflater ;
    private OnItemClickListener listener ;

    private List<Employee> list ;

    public interface OnItemClickListener{
        void onEmployeeClick(Employee employee);
    }

    public EmployeeAdapter(Context context) {
       super();
       inflater = LayoutInflater.from(context);
       list = new ArrayList<>();
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 0;
    }
}
