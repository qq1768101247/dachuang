package com.management.pp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.management.pp.R;
import com.management.pp.bean.ArableLandBean;
import com.management.pp.bean.CommentsBean;

import java.util.ArrayList;
import java.util.List;


public class ComAdapter extends BaseAdapter {
     //数据源
    private List<CommentsBean> mList = new ArrayList<>();
    private Context mContext;
    public ComAdapter(Context context, List<CommentsBean> mList) {
        super();
        this.mContext = context;
        this.mList = mList;
    }



    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CommentsBean getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder  holder = new  ViewHolder( );
        CommentsBean mCommentsBean=mList.get(position);
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_com, parent, false);
        holder.comTxt = (TextView) convertView.findViewById(R.id.comTxt);
        holder.timeTxt = (TextView) convertView.findViewById(R.id.timeTxt);
        holder.nameTxt = (TextView) convertView.findViewById(R.id.nameTxt);
        holder.nameTxt.setText(mCommentsBean.getUserName());
        holder.comTxt.setText(mCommentsBean.getCon());
        holder.timeTxt.setText(mCommentsBean.getTimeSting());
        return convertView;
    }

    class ViewHolder {
        TextView comTxt,timeTxt,nameTxt;

    }

}
