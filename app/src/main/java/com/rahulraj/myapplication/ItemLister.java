package com.rahulraj.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 6/8/2017.
 */

public class ItemLister {

    public List<String> listItems(String str){
        List<String> list = new ArrayList<>();
        if(str.equalsIgnoreCase("vegetables")){
            list.add("ladies finger");
            list.add("tomato");
            list.add("carrot");
            list.add("onion");
        }
        if(str.equalsIgnoreCase("non-veg")){
            list.add("fish");
            list.add("chicken");
            list.add("beef");
            list.add("mutton");
        }
        if(str.equalsIgnoreCase("fruits")){
            list.add("apple");
            list.add("orange");
            list.add("mango");
            list.add("jackfruit");
        }

        return list;
    }
}
