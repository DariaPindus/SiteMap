package com.daria.practice.xml.my;


import java.util.ArrayList;
import java.util.List;

public class UrlNodeMy {
    private String location;
    private String label;
    private String link;
    private double priority;
    private List<UrlNodeMy> children;

    public UrlNodeMy(){
        children = new ArrayList<UrlNodeMy>();
    }

    public UrlNodeMy(String location) {
        this.location = location;
        children = new ArrayList<UrlNodeMy>();
        setLabel();
        link = location.substring(0, location.length()-1) + "/";
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLabel() {
        return label;
    }

    public String setLabelDefault() {
        String[] strs1 = location.split("/");
        if (strs1.length > 4) {
            strs1 = strs1[4].split("-");
        }
        label = strs1[strs1.length - 1];
        System.out.println("Set label: " + label);
        return label;
    }

    public void setLabel(){
        //ETO KAKAYA-TO DI4', ISPAV' ETO
        if (this.location.equals("http://upsales.com.ua/")) {
            label = "Upsite";
            return;
        }

        String[] subParts = location.split("/");
        if (subParts.length == 4) {
            String name = CitiesMap.getName(subParts[3]);
            label = (name == null) ? setLabelDefault() : name;
        } else {
            String find = (subParts[4].charAt(subParts[4].length()-1) == '-') ? subParts[4].substring(0, subParts[4].length()-1) : subParts[4];
            String name = CategoriesMap.getName(find);
            label = (name == null) ? setLabelDefault() : name;
        }
    }

    public double getPriority() {
        return priority;
    }

    public void addChildren(UrlNodeMy node){
        this.children.add(node);
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public List<UrlNodeMy> getChildren() {
        return children;
    }

    public void setChildren(List<UrlNodeMy> children) {
        this.children = children;
    }

    public String getLink(){
        return link;
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        UrlNodeMy node = (UrlNodeMy) o;
        return this.getLocation().equals(node.getLocation());
    }
}
