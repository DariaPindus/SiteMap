package com.daria.practice.xml.my;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class CitiesMap {
    private static Map<String, String> map = getCitiesMap();

    private static Map<String, String> getCitiesMap(){
        /*result.put("odesa", "Одесса");
        result.put("belaya_cerkov", "Белая церковь");
        result.put("chernovcy", "Черновцы");
        result.put("dnepr_dnepropetrovsk", "Днепропетровск");
        result.put("harkov", "Харьков");
        result.put("kiev", "Киев");
        result.put("krivoi_rog", "Кривой Рог");
        result.put("lugansk", "Луганск");
        result.put("nikolaev", "Николаев");
        result.put("vinica", "Винница");
        result.put("zaporozhe", "Запорожье");*/
        Map<String, String> resultMap = new HashMap<>();
        try {
            String link = "http://upsales.com.ua/locality/loadCities.ajax?region=";
            for (int i = 1; i <= 25; i++ ) {
                URL categoriesUrl = new URL(link+i);
                BufferedReader in = new BufferedReader(new InputStreamReader(categoriesUrl.openStream()));
                JSONParser parser = new JSONParser();

                Object obj = parser.parse(in);

                JSONArray jsonArray = (JSONArray) obj;
                Iterator it = jsonArray.iterator();

                while (it.hasNext()) {
                    JSONObject slide = (JSONObject) it.next();
                    String name = (String) slide.get("name");
                    String transliterated = (String) slide.get("transliterated_name");
                    //System.out.println(transliterated + " - " + name);
                    resultMap.put(transliterated, name);
                }
            }
        } catch (IOException |ParseException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    public static String getName(String transliterated) {
        return map.get(transliterated);
    }
}
