package com.daria.practice.xml.my;

import java.util.HashMap;
import java.util.Map;


public class CitiesMap {
    private static Map<String, String> map = getCitiesMap();

    private static Map<String, String> getCitiesMap(){
        Map<String, String> result = new HashMap<>();
        result.put("odesa", "Одесса");
        result.put("belaya_cerkov", "Белая церковь");
        result.put("chernovcy", "Черновцы");
        result.put("dnepr_dnepropetrovsk", "Днепропетровск");
        result.put("harkov", "Харьков");
        result.put("kiev", "Киев");
        result.put("krivoi_rog", "Кривой Рог");
        result.put("lugansk", "Луганск");
        result.put("nikolaev", "Николаев");
        result.put("vinica", "Винница");
        result.put("zaporozhe", "Запорожье");
        return result;
    }

    public static String getName(String transliterated) {
        return map.get(transliterated);
    }
}
