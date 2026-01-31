package com.interfaces.defaultmethods.dataexportfeature;

public interface DataExporter {

    public void exportToCSV();

    public default void exportToJSON() {
        System.out.println("Exporting data in JSON format.");
    }
}

