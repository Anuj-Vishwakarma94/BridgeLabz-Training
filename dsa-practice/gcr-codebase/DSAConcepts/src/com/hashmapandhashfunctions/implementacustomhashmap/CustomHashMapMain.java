package com.hashmapandhashfunctions.implementacustomhashmap;

public class CustomHashMapMain {
    public static void main(String[] args) {

        CustomHashMap map = new CustomHashMap();

        map.put(1, 100);
        map.put(2, 200);
        map.put(17, 1700); 

        System.out.println(map.get(1));   
        System.out.println(map.get(2));   
        System.out.println(map.get(17));  

        map.remove(2);
        System.out.println(map.get(2));   
    }
}
