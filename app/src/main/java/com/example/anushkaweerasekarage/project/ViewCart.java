package com.example.anushkaweerasekarage.project;

import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by anushkaweerasekarage on 2017-07-29.
 */

public class ViewCart extends Fragment{

    View v;
    int i= 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.viewcart, container, false);

        Cart cart = MenuIcon.m_cart;
        LinearLayout cartLayout = (LinearLayout) v.findViewById(R.id.cart);

        //set of products
        Set<Product> prodcts = cart.getProducts();

        //iterate through products
        Iterator iterator = prodcts.iterator();
        while(iterator.hasNext()) {

            Product prod = (Product) iterator.next();

            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView name = new TextView(getActivity());
            TextView quantity = new TextView(getActivity());

            name.setText(prod.getName());
            quantity.setText(Integer.toString(i+cart.getQuantity(prod)));

            linearLayout.addView(name);
            linearLayout.addView(quantity);

            name.setTextSize(20);
            quantity.setTextSize(20);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    200, Gravity.CENTER);
            layoutParams.setMargins(20, 30, 20, 30);
            linearLayout.setLayoutParams(layoutParams);

            name.setLayoutParams(new TableLayout.LayoutParams(0,
                    ActionBar.LayoutParams.WRAP_CONTENT, 1));

            quantity.setLayoutParams(new TableLayout.LayoutParams(0,
                    ActionBar.LayoutParams.WRAP_CONTENT, 1));


            name.setGravity(Gravity.CENTER);
            quantity.setGravity(Gravity.CENTER);
            //price.setGravity(Gravity.CENTER);

            cartLayout.addView(linearLayout);


        }
        LinearLayout l = new LinearLayout(getActivity());
        l.setOrientation(LinearLayout.HORIZONTAL);
        TextView sub = new TextView(getActivity());
        TextView price = new TextView(getActivity());

        sub.setText("TOTAL");
        price.setText(Double.toString(cart.getValue()));
        l.addView(sub);
        l.addView(price);
        sub.setTextSize(20);
        price.setTextSize(20);
        LinearLayout.LayoutParams layoutPara = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                200, Gravity.CENTER);
        layoutPara.setMargins(20, 300, 20, 20);
        l.setLayoutParams(layoutPara);
        sub.setLayoutParams(new TableLayout.LayoutParams(0,
                ActionBar.LayoutParams.WRAP_CONTENT, 1));
        price.setLayoutParams(new TableLayout.LayoutParams(0,
                ActionBar.LayoutParams.WRAP_CONTENT, 1));
        sub.setGravity(Gravity.CENTER);
        price.setGravity(Gravity.CENTER);
        cartLayout.addView(l);

        /*
        LinearLayout l2 = new LinearLayout(getActivity());
        l2.setOrientation(LinearLayout.HORIZONTAL);
        Button checkout = new Button(getActivity());
        //Drawable d = v.getResources().getDrawable(R.drawable.but);
        //checkout.setBackgroundDrawable(d);
        checkout.setText("Go To Checkout");
        checkout.setTextSize(20);
        LinearLayout.LayoutParams layoutP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                200, Gravity.CENTER);
        layoutP.setMargins(10, 450, 10, 10);
        l2.setLayoutParams(layoutP);
        checkout.setLayoutParams(new TableLayout.LayoutParams(0,
                ActionBar.LayoutParams.WRAP_CONTENT, 1));
        checkout.setGravity(Gravity.CENTER);
        cartLayout.addView(l2);

        */
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("My Order");
    }
}
