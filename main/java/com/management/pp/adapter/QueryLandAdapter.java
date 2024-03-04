package com.management.pp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.management.pp.R;
import com.management.pp.bean.ArableLandBean;
import com.management.pp.bean.PlanBean;

import java.util.ArrayList;
import java.util.List;


public class QueryLandAdapter extends BaseAdapter {
     //数据源
    private List<PlanBean> mList = new ArrayList<>();
    private Context mContext;
    public QueryLandAdapter(Context context, List<PlanBean> mList) {
        super();
        this.mContext = context;
        this.mList = mList;
    }



    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public PlanBean getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder  holder = new  ViewHolder( );
        PlanBean mPlanBean=mList.get(position);
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_query_land, parent, false);
        holder.numberTxt = (TextView) convertView.findViewById(R.id.numberTxt);
        holder.conTxt = (TextView) convertView.findViewById(R.id.conTxt);
        holder.timeTxt = (TextView) convertView.findViewById(R.id.timeTxt);
        holder.numberTxt.setText(mPlanBean.getName());
        holder.conTxt.setText(mPlanBean.getCon());
        holder.timeTxt.setText(mPlanBean.getTimeString());
        return convertView;
    }

    class ViewHolder {
        TextView numberTxt,conTxt,timeTxt;

    }

}
