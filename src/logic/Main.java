package logic;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();

        // Get the Big O for each data structure
        //Tests.startTest();

        // Get the saved info
        FileManager.loadInfo();
        AutoSIA.setCourses(FileManager.getInfo());

        // Start threads
        ThreadCaller.initThreads();

        // Update the files with the new data
        FileManager.setInfo(AutoSIA.getCourses());
        FileManager.saveInfo();

        long result = (System.nanoTime() - start) / 1_000_000_000;
        System.out.println(result + " seg / " + result / 60.0 + " min");
    }
}