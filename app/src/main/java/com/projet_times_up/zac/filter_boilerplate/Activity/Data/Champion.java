package com.projet_times_up.zac.filter_boilerplate.Activity.Data;

/**
 * Created by Zaccharie.BOUVY on 30/06/2017.
 */
public class Champion {

    private String name;
    private int pricePI;

    public Champion(String name, int pricePI) {
        this.name = name;
        this.pricePI = pricePI;
    }

    public int getPricePI() {
        return pricePI;
    }

    public void setPricePI(int pricePI) {
        this.pricePI = pricePI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
