package com.csv;

import java.io.*;
import java.util.Base64;

public class EncryptCSV {
    public static void main(String[] args) throws Exception {
        String data = "anuj@gmail.com";
        String enc = Base64.getEncoder().encodeToString(data.getBytes());
        String dec = new String(Base64.getDecoder().decode(enc));
        System.out.println(enc);
        System.out.println(dec);
    }
}
