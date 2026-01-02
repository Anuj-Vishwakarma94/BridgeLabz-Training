package com.encapsulation.hotelmanagementsystem;

import java.util.List;

public interface MedicalRecord {

    void addRecord(String record);

    List<String> viewRecords();
}
