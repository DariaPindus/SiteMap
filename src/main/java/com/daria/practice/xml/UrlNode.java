package com.daria.practice.xml;


import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UrlNode {
    private String location;
    private double priority;
    private String label;
    private List<UrlNode> children;
    private int nesting;
    private UrlNode root;
    private List<String> subparts;

    public UrlNode() {
        children = new ArrayList<UrlNode>();
        nesting = 0;
        root = new UrlNode();
        root.setLocation("http://upsales.com.ua/");
    }

    public UrlNode(String location, double priority) {
        children = new ArrayList<UrlNode>();
        this.location = location;
        this.priority = priority;
        this.label = location;
    }

    private UrlNode setRoot(){
        UrlNode root = new UrlNode();
        root.setLocation("http://upsales.com.ua/");
        return root;
    }

    private void initializeRoot(){
        root.setLocation("http://upsales.com.ua/");
    }

    private void setRootWithParam(UrlNode node) {
        this.root = node;
    }

    private List<String> divideLocation(){
        List<String> subParts = new ArrayList<String>();
        String[] parts = this.getLocation().split("/");
        subParts.add(parts[3]);
        String[] sub = parts[4].split("-");
        for (String s : sub)
            subParts.add(s);
        return subParts;
    }

    public void DivideLocation(){
        List<String> subParts = new ArrayList<String>();
        String[] parts = this.getLocation().split("/");
        subParts.add(parts[3]);
        String[] sub = parts[4].split("-");
        for (String s : sub)
            subParts.add(s);

        UrlNode root = setRoot();
        UrlNode currentNode = root;
        UrlNode parent = currentNode;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentNode.getLocation());

        for (int i = 0; i < subParts.size(); i++) {
            stringBuilder.append(subParts.get(i)+"/");
            currentNode.setLocation(stringBuilder.toString());
            //addChildren(currentNode, parent);
            parent = currentNode;
        }
    }

    public void doSomething(String location, double priority){
        UrlNode initial = this;     //sobstvenno, kakyu i dobavlyem
        initializeRoot();

        UrlNode current = new UrlNode(location, priority);


    }

    public void AddLocation() {
        UrlNode parent = root;

    }

/*    private void addChildren(UrlNode node, UrlNode parent) {
        UrlNode curParent = parent;
        UrlNode current = node;

        if (parent.children.contains(current)){
            return;
        } else {
            parent.children.add(current);
            return;
        }
    }*/

/*


    public void AddChildren(String location, double priority){
        UrlNode node = new UrlNode(location, priority);

        List<String> subParts = divideLocation();
        if (root == null) {
            //root = setRoot();
            root = node;
            return;
        }

        UrlNode currentNode = root;
        while (true) {
            UrlNode parent = currentNode;
        }
    }
*/


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNesting() {
        return nesting;
    }

    public void setNesting(int nesting) {
        this.nesting = nesting;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        int result = 0;
        char[] chars = location.toCharArray();
        for (char c : chars) {
            result += (int) c;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        UrlNode node = (UrlNode) o;
        return this.getLocation().equals(node.getLocation()) ? true : false;
    }
}
