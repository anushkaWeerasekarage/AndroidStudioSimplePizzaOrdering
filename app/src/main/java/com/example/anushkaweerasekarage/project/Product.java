package com.example.anushkaweerasekarage.project;

/**
 * Created by anushkaweerasekarage on 2017-07-29.
 */

public class Product {
    private String p_name;
    private double p_value;
    private String p_size;


    public Product(String name, String size, double value) {
        p_name = name;
        p_size = size;
        p_value = value;

    }

    String getName() {
        return p_name;
    }

    double getValue() {
        return p_value;
    }

    String getSize() {
        return  p_size;
    }
}
