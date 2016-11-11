package com.daria.practice.xml.my;


import com.daria.practice.xml.UrlNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UrlNodeTree {
    private List<UrlNodeMy> children;
    private UrlNodeMy root;
    CategoriesMap categoriesMap;
    Map<String, String> categories;

    public UrlNodeTree() {
        children = new ArrayList<UrlNodeMy>();
        setRoot();
        //categories = CategoriesMap.getMapFromFile();
    }

    private void setRoot() {
        root = new UrlNodeMy();
        root.setLocation("http://upsales.com.ua/");
        //root.setLabel("upsales");
        root.setPriority(0);
    }

    public void setRoot(UrlNodeMy root) {
        this.root = root;
    }

    public List<String> DivideUrl(String input){
        List<String> subParts = new ArrayList<String>();
        String[] parts = input.split("/|-"); //("/|-") vozmozhno kazhdii v vkruglie skobki
        for (int i = 3; i < parts.length; i++ ){
            subParts.add(parts[i]);
        }
        return subParts;
    }

    public void sortTree(UrlNodeMy node){
        if (node.getChildren().isEmpty()) {
            return;
        }

        Collections.sort(node.getChildren(), (p1, p2) -> p1.getLabel().compareTo(p2.getLabel()));
        for (int i = 0; i < node.getChildren().size(); i++) {
            sortTree(node.getChildren().get(i));
        }

    }

    public void addNode(UrlNodeMy node) {
        List<String> subParts = DivideUrl(node.getLocation());

        UrlNodeMy parent = root;
        StringBuilder sb = new StringBuilder();
        sb.append(parent.getLocation());

        for (int i = 0; i < subParts.size(); i++) {
            sb.append(subParts.get(i) + ((i == 0 || i == (subParts.size()-1) ) ? "/" : "-"));
            UrlNodeMy iterate = new UrlNodeMy(sb.toString());
            if (!parent.getChildren().contains(iterate)) {
                parent.addChildren(iterate);
                parent = iterate;
            } else {
                int index = parent.getChildren().indexOf(iterate);
                parent = parent.getChildren().get(index);
            }
        }
    }

    public UrlNodeMy getRoot(){
        return root;
    }
}
