package com.example.anushkaweerasekarage.project;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by anushkaweerasekarage on 2017-07-27.
 */

public class MenuIcon extends Fragment {
    @Nullable

    String name;
    String vPrice, hPrice, mPrice;
    double veg_price, h_price, meat_price;
    Object s;
    View v;
    static Cart m_cart;
    double val;
    String va;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.menuicon, container, false);


        String[] sizes =
                {"Select Size","Large", "Medium", "Small"};

        Spinner size_spinner = (Spinner) v.findViewById(R.id.size1);


        final ArrayAdapter<String> size_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, sizes);
        size_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        size_spinner.setAdapter(size_adapter);

        final TextView item_price = (TextView) v.findViewById(R.id.vegprice);

        size_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View v,
                                       int i, long id) {

                s = parent.getItemAtPosition(i);
                if(s.toString().equals("Large")) {
                    veg_price = 18.00;
                }
                else if(s.toString().equals("Medium")) {
                    veg_price = 15.00;
                }
                else if(s.toString().equals("Small")){
                    veg_price = 11.00;
                }
                else
                    veg_price = 0.0;

                vPrice = Double.toString(veg_price);
                item_price.setText(vPrice+" $");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner hawa_spinner = (Spinner) v.findViewById(R.id.hawa_spinner);


        final ArrayAdapter<String> hawa_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, sizes);
        hawa_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        hawa_spinner.setAdapter(hawa_adapter);

        final TextView hawa_price = (TextView) v.findViewById(R.id.hawaPrice);

        hawa_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View v,
                                       int i, long id) {

                s = parent.getItemAtPosition(i);
                if(s.toString().equals("Large")) {
                    h_price = 20.00;
                }
                else if(s.toString().equals("Medium")) {
                    h_price = 18.00;
                }
                else if(s.toString().equals("Small")){
                    h_price = 15.00;
                }
                else
                    h_price = 0.0;

                hPrice = Double.toString(h_price);
                hawa_price.setText(hPrice+" $");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner maga_spinner = (Spinner) v.findViewById(R.id.magSpinner);
        final TextView maga_price = (TextView) v.findViewById(R.id.magprice);

        ArrayAdapter<String> mag_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, sizes);
        mag_adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        maga_spinner.setAdapter(mag_adapter);

        maga_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View v,
                                       int i, long id) {

                s = parent.getItemAtPosition(i);
                if(s.toString().equals("Large")) {
                    meat_price = 25.00;
                }
                else if(s.toString().equals("Medium")) {
                    meat_price = 20.00;
                }
                else if(s.toString().equals("Small")){
                    meat_price = 18.00;
                }
                else
                    meat_price = 0.0;

                mPrice = Double.toString(meat_price);
                maga_price.setText(mPrice+" $");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        m_cart = new Cart();

        final Product[] product1 = {
                new Product("Vegetable", "Large", 18.0),
                new Product("Vegetable", "Medium", 15.0),
                new Product("Vegetable", "Small", 11.0),
        };

        Button vegBut = (Button) v.findViewById(R.id.vegbutton);
        vegBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < product1.length; i++) {
                    if (veg_price == product1[i].getValue()) {
                        Product p = product1[i];
                        m_cart.addToCart(p);

                    }
                    val = m_cart.getValue();
                    va = String.valueOf(val);
                    Toast.makeText(getActivity(), va, Toast.LENGTH_LONG).show();

                }
            }
        });


        final Product[] product2 = {
                new Product("Hawaiian", "Large", 20.0),
                new Product("Hawaiian", "Medium", 18.0),
                new Product("Hawaiian", "Small", 15.0),

        };
        Button hawaBut = (Button) v.findViewById(R.id.hawabutton);
        hawaBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < product2.length; i++) {
                    if(h_price == product2[i].getValue()) {
                        Product p1 = product2[i];
                        m_cart.addToCart(p1);
                        val = m_cart.getValue();
                        va = String.valueOf(val);
                        Toast.makeText(getActivity(), va, Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        final Product[] product3 = {
                new Product("Magharita", "Large", 25.0),
                new Product("Magharita", "Medium", 20.0),
                new Product("Magharita", "Small", 18.0),
        };

        Button mag_button = (Button) v.findViewById(R.id.magbutton);
        mag_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < product3.length; i++) {
                    if(meat_price == product3[i].getValue()) {
                        Product p1 = product3[i];
                        m_cart.addToCart(p1);
                        val = m_cart.getValue();
                        va = String.valueOf(val);
                        Toast.makeText(getActivity(), va, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        Button cartView = (Button) v.findViewById(R.id.viewCart);
        cartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment Frag = new ViewCart();
                getFragmentManager().beginTransaction().replace(R.id.content_main, Frag).commit();
            }
        });

        return v;
    }




    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Menu");
    }


}
