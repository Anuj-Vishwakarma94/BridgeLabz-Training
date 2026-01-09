package com.runtimeanalysis.fileread;

public class FileReadComparison {

	public static void main(String[] args) {

		String filePath = "src/com/runtimeanalysis/fileread/largeText.txt";

		try {
			long startFileReader = System.nanoTime();
			int count1 = FileReaderProcessor.countCharacters(filePath);
			long endFileReader = System.nanoTime();

			long startISR = System.nanoTime();
			int count2 = InputStreamReaderProcessor.countCharacters(filePath);
			long endISR = System.nanoTime();

			System.out.println("FileReader Characters        : " + count1);
			System.out.println("FileReader Time (ns)         : " + (endFileReader - startFileReader));
			System.out.println();
			System.out.println("InputStreamReader Characters : " + count2);
			System.out.println("InputStreamReader Time (ns)  : " + (endISR - startISR));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
