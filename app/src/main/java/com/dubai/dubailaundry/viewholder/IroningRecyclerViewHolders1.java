package com.dubai.dubailaundry.viewholder;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dubai.dubailaundry.R;
import com.dubai.dubailaundry.activity.OrderDetailsActivity;
import com.dubai.dubailaundry.model.data1;


public class IroningRecyclerViewHolders1 extends RecyclerView.ViewHolder {

//    UserActionCountItemBinding binding;
public TextView dryitem,drycount,dryamount;
    data1.Result itm;
    public OrderDetailsActivity _activty;

    public IroningRecyclerViewHolders1(View itemView, Context context, OrderDetailsActivity activity) {
        super(itemView);
        _activty=activity;
//        binding = DataBindingUtil.bind(itemView);
        dryitem = itemView.findViewById(R.id.tv_dryitem);
        dryamount = itemView.findViewById(R.id.tv_damount);
        ImageView minus = itemView.findViewById(R.id.minus);
        ImageView plus = itemView.findViewById(R.id.plus);
        drycount = itemView.findViewById(R.id.count);

    }




    public void bind(data1.Result item) {
        itm=item;
    }


}
