package com.example.anushkaweerasekarage.project;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by anushkaweerasekarage on 2017-07-29.
 */

public class Cart {
    Map<Product, Integer> m_cart;
    double p_value = 0;


    Cart() {

        m_cart = new LinkedHashMap<>();
    }

    void addToCart(Product product) {

        if(m_cart.containsKey(product))
            m_cart.put(product, m_cart.get(product) + 1);
        else
            m_cart.put(product, 1);

        p_value += product.getValue();
    }

    int getQuantity(Product product) {

        return m_cart.get(product);
    }

    Set getProducts() {

        return m_cart.keySet();
    }

    void empty() {
        m_cart.clear();
        p_value = 0;
    }

    double getValue() {
        return p_value;
    }

    int getCartSize() {
        return m_cart.size();
    }
}
