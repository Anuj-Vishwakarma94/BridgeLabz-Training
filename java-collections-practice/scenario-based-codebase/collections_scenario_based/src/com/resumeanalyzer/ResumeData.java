package com.resumeanalyzer;
import java.util.List;

public class ResumeData {

    private String email;
    private String phone;
    private List<String> matchedKeywords;

    public ResumeData(String email, String phone, List<String> matchedKeywords) {
        this.email = email;
        this.phone = phone;
        this.matchedKeywords = matchedKeywords;
    }

    public String getEmail() {
        return email;
    }

    public int getKeywordCount() {
        return matchedKeywords.size();
    }

    public void display() {
        System.out.println("Email   : " + email);
        System.out.println("Phone   : " + phone);
        System.out.println("Keywords: " + matchedKeywords);
        System.out.println("Matches : " + matchedKeywords.size());
        System.out.println("--------------------------------");
    }
}
