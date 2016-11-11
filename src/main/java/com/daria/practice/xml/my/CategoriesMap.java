package com.daria.practice.xml.my;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CategoriesMap implements JsonMap{

    private URL url;
    private static Map<String, String> map = getMapFromFile();

    @Override
    public Map<String, String> getMap(String url) {
        Map<String, String> resultMap = new HashMap<>();
        try {

            URL categoriesUrl = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(categoriesUrl.openStream()));
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(in);

            JSONArray jsonArray = (JSONArray) obj;
            Iterator i = jsonArray.iterator();

            while (i.hasNext()) {
                JSONObject slide = (JSONObject) i.next();
                String name = (String) slide.get("name");
                String transliterated = (String) slide.get("transliterated_name");
                System.out.println(transliterated + " - " + name);
                resultMap.put(transliterated, name);
            }


        } catch (IOException|ParseException  e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    public static Map<String, String> getMapFromFile() {
        Map<String, String> resultMap = new HashMap<>();
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("/home/daria_p/MyDocs/Practice/categories-cut.json"));
            JSONArray jsonArray = (JSONArray) obj;
            Iterator i = jsonArray.iterator();

            while (i.hasNext()) {
                JSONObject slide = (JSONObject) i.next();
                String name = (String) slide.get("name");
                String transliterated = (String) slide.get("transliterated_name");
                //System.out.println(transliterated + " - " + name);
                resultMap.put(transliterated, name);
            }
        } catch (IOException|ParseException  e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    public static String getName(String transliterated) {
        return map.get(transliterated);
    }
}
