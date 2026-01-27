package com.csv;

import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) throws Exception {
        Map<String,String[]> map = new HashMap<>();
        BufferedReader br1 = new BufferedReader(new FileReader("src/com/csv/students1.csv"));
        br1.readLine();
        String l;
        while ((l = br1.readLine()) != null) {
            String[] d = l.split(",");
            map.put(d[0], d);
        }
        BufferedReader br2 = new BufferedReader(new FileReader("src/com/csv/students2.csv"));
        br2.readLine();
        while ((l = br2.readLine()) != null) {
            String[] d = l.split(",");
            String[] s = map.get(d[0]);
            System.out.println(s[0]+","+s[1]+","+s[2]+","+d[1]+","+d[2]);
        }
        br1.close();
        br2.close();
    }
}
