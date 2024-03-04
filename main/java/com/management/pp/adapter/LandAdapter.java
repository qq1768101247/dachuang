package com.management.pp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.management.pp.R;
import com.management.pp.bean.ArableLandBean;

import java.util.ArrayList;
import java.util.List;


public class LandAdapter extends BaseAdapter {
     //数据源
    private List<ArableLandBean> mList = new ArrayList<>();
    private Context mContext;
    public LandAdapter(Context context, List<ArableLandBean> mList) {
        super();
        this.mContext = context;
        this.mList = mList;
    }



    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public ArableLandBean getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder  holder = new  ViewHolder( );
        ArableLandBean mArableLandBean=mList.get(position);
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_land, parent, false);
        holder.numberTxt = (TextView) convertView.findViewById(R.id.numberTxt);
        holder.conTxt = (TextView) convertView.findViewById(R.id.conTxt);
        holder.numberTxt.setText(mArableLandBean.getUnmber());
        holder.conTxt.setText(mArableLandBean.getCon());
        return convertView;
    }

    class ViewHolder {
        TextView numberTxt,conTxt;

    }

}
