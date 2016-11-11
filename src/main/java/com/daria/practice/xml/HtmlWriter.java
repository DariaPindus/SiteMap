package com.daria.practice.xml;


import java.io.*;

public class HtmlWriter {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/daria_p/MyDocs/Practice/seoMap_cut.html");
        if(!file.exists())
                file.createNewFile();

        FileWriter out = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bufferedWriter = new BufferedWriter(out);


    }
}
