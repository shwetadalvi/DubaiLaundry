package com.dubai.dubailaundry.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.dubai.dubailaundry.R;
import com.dubai.dubailaundry.activity.OrderConfirmationActivity;
import com.dubai.dubailaundry.model.data;
import com.dubai.dubailaundry.viewholder.IroningRecyclerViewHolders;

import java.util.ArrayList;

public class IroningRecyclerViewAdapter extends RecyclerView.Adapter<IroningRecyclerViewHolders> {

    //    private List<UserLogCountResponse.DetailsBean> itemList;
    private Context context;
    private ArrayList<data.Detail.Item> items;
    OrderConfirmationActivity _activity;


    public IroningRecyclerViewAdapter(Context context,ArrayList<data.Detail.Item> data, OrderConfirmationActivity activity) {
//        this.itemList = itemList;
        this.context = context;
        this.items=data;
        _activity=activity;
    }

    @Override
    public IroningRecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dry_clean_item, null);
        IroningRecyclerViewHolders rcv = new IroningRecyclerViewHolders(layoutView, context,_activity);
        return rcv;
    }

    @Override
    public void onBindViewHolder(IroningRecyclerViewHolders holder, int position) {
//        UserLogCountResponse.DetailsBean status = itemList.get(position);
//        holder.bind(status);

        data.Detail.Item item=items.get(position);
        holder.bind(item);

        holder.dryitem.setText(items.get(position).getItemName());
        holder.drycount.setText(String.valueOf(items.get(position).getItemcount()));
        holder.dryamount.setText(String.valueOf(items.get(position).getTotal()));
    }


    @Override
    public int getItemCount() {
//        if (null == itemList)
//            return 0;
//        else
//            return this.itemList.size();
        return items.size();
    }
}
