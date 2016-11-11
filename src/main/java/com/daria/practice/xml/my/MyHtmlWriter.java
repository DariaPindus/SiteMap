package com.daria.practice.xml.my;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyHtmlWriter {
    UrlNodeTree tree;
    StringBuilder sb;
    boolean isEnded;

    public MyHtmlWriter(UrlNodeTree tree) {
        this.tree = tree;
        sb = new StringBuilder();
        isEnded = false;
    }

    public void WriteHtml() throws IOException {
        File file = new File("/home/daria_p/MyDocs/Practice/seoMap_cut.html");
        if(!file.exists())
            file.createNewFile();

        FileWriter out = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bf = new BufferedWriter(out);

        bf.write("<htlm>\n" +
                "\t<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>");
        UrlNodeMy rootNode = tree.getRoot();
        tree.sortTree(rootNode);
        processTree(rootNode);
        bf.write(sb.toString());
/* as alternative
        for (int i = 0; i < rootNode.getChildren().size(); i++) {
            processTree(rootNode.getChildren().get(i));
            bf.write(sb.toString());
            sb.setLength(0);
        }
*/

        bf.write("</body>\n" +
                "</html>");
        bf.close();
    }

    public void WriteJson() throws IOException {
        File file = new File("/home/daria_p/MyDocs/Practice/categories_cut.json");
        if(!file.exists())
            file.createNewFile();

        FileWriter out = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bf = new BufferedWriter(out);

    }

    public void processTree(UrlNodeMy node) throws IOException {
        if (node.getChildren().isEmpty()) {
            sb.append("\n <li> <a href = " + node.getLink()+ ">");
            sb.append(node.getLabel() + "</a></li>");
            return;
        }
//        sb.append("\n<ul>");
        sb.append("\n<li><a href = " + node.getLink() + " >");      //ispolzovat' jsoup
        sb.append(node.getLabel());
        sb.append("</a>");
        for (int i = 0; i < node.getChildren().size(); i++) {
            sb.append("\n<ul>");
            processTree(node.getChildren().get(i));
            sb.append("\n</ul>");
        }
        sb.append("\n</li>");
    }
}
