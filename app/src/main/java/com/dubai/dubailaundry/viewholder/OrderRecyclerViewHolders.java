package com.dubai.dubailaundry.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.dubai.dubailaundry.Almosky;
import com.dubai.dubailaundry.R;
import com.dubai.dubailaundry.TabHostActivity;
import com.dubai.dubailaundry.activity.OrderDetailsActivity;
import com.dubai.dubailaundry.model.OrderListdto;
import com.kofigyan.stateprogressbar.StateProgressBar;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class OrderRecyclerViewHolders extends RecyclerView.ViewHolder {

    private TextView textTitle;
    //    UserActionCountItemBinding binding;
    public TextView orderdate,orderno,status;
    public ConstraintLayout lyt;

    public final Context ctx;

    StateProgressBar stateProgressBar;
    OrderListdto.Result _data;

    TabHostActivity _activty;


    public OrderRecyclerViewHolders(View itemView, TabHostActivity context) {
        super(itemView);
        ctx = context;
        //  _activty=activity;
        _activty=context;


        orderdate = itemView.findViewById(R.id.textOrderDate);
        orderno = itemView.findViewById(R.id.textOrderNo);
        status=itemView.findViewById(R.id.textStatus);
         stateProgressBar=itemView.findViewById(R.id.stateProgressBar);


        lyt=itemView.findViewById(R.id.lytorder);

        lyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Almosky.getInst().setSelectedOrder(_data);
                Intent go=new Intent(_activty, OrderDetailsActivity.class);
                _activty.startActivity(go);
            }
        });

//        binding = DataBindingUtil.bind(itemView);
    }


    public void bind(OrderListdto.Result item) {

        _data=item;

        orderdate.setText(item.getPickupTime());
        orderno.setText(item.getOrderNo());



        if(item.getOrderStatus().equals(0)){
            status.setText("Not Accepted Yet");
           // stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
        }
        if(item.getOrderStatus().equals(1)){
            status.setText("Accepted");
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);

        }
        if(item.getOrderStatus().equals(2)){
            status.setText("Confirm");
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);

        }if(item.getOrderStatus().equals(3)){
            status.setText("In Progress");
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);

        }if(item.getOrderStatus().equals(4)){
            status.setText("Completed");
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);

        }if(item.getOrderStatus().equals(5)){
            status.setText("Out For Delivery");
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FIVE);

        }
        if(item.getOrderStatus().equals(6)){
            status.setText("Delivered");
            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FIVE);

        }








      /*  String address = "";

        if (null != item.getArea())
            if (!item.getArea().equalsIgnoreCase(""))
                if (address.length() > 0)
                    address = address + ", " + item.getArea();
                else
                    address = item.getArea();

        if (null != item.getStreet())
            if (!item.getStreet().equalsIgnoreCase(""))
                if (address.length() > 0)
                    address = address + ", " + item.getStreet();
                else
                    address = item.getStreet();
        if (null != item.getBlock())
            if (!item.getBlock().equalsIgnoreCase(""))
                if (address.length() > 0)
                    address = address + ", " + item.getBlock();
                else
                    address = item.getBlock();


        if (null != item.getHouse())
            if (!item.getHouse().equalsIgnoreCase(""))
                if (address.length() > 0)
                    address = address + ", " + item.getHouse();
                else
                    address = item.getHouse();

        if (null != item.getApartment())
            if (!item.getApartment().equalsIgnoreCase(""))
                if (address.length() > 0)
                    address = address + ", " + item.getApartment();
                else
                    address = item.getApartment();
        if (null != item.getFloor())
            if (!item.getFloor().equalsIgnoreCase(""))
                if (address.length() > 0)
                    address = address + ", " + item.getFloor();
                else
                    address = item.getFloor();

        addressText.setText(address);
        textTitle.setText(item.getAddressName()); */
        //   itm=item;
    }


}
