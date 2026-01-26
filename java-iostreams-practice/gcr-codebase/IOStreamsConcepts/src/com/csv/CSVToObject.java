package com.csv;

import java.io.*;
import java.util.*;

class Student {
    int id, age, marks;
    String name;
    Student(int i,String n,int a,int m){id=i;name=n;age=a;marks=m;}
    public String toString(){return id+" "+name+" "+age+" "+marks;}
}

public class CSVToObject {
    public static void main(String[] args) throws Exception {
        List<Student> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            list.add(new Student(
                Integer.parseInt(d[0]), d[1],
                Integer.parseInt(d[2]), Integer.parseInt(d[3])
            ));
        }
        list.forEach(System.out::println);
        br.close();
    }
}
