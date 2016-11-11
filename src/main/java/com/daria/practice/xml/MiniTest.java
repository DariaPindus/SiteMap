package com.daria.practice.xml;


import com.daria.practice.xml.my.CategoriesMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MiniTest {

    public static void main(String[] args) {
        //CategoriesMap map = new CategoriesMap();
        //map.getMapFromFile();
        String location = "http://upsales.com.ua/zaporozhe/torgovoe_oborudovanie-metallicheskie_shkafy/";
        String[] subParts = location.split("/");
        for (String s : subParts) {
            System.out.println(s);
        }
    }

}
