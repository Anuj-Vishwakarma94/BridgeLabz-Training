package com.interfaces.defaultmethods.dataexportfeature;

public class ExporterMain {
    public static void main(String[] args) {

        DataExporter exporter = new CSVExporter();

        exporter.exportToCSV();
        exporter.exportToJSON();
    }
}

