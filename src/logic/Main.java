package logic;

import data.Course;
import data.DoubleList;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();

        RandomData.setSize(100000);
        RandomData.generateInfo();

        // Test the speed
        FileManager.loadInfo("test_100000.obj");
        DoubleList<Course> info = FileManager.getInfo();
        //System.out.println(info.print());


        int[] nValues = {10, 50, 100, 500, 1000, 5000};
        for (int size: nValues){



            //System.out.println(TestQueue.getCourses());
            //System.out.println(TestQueue.getOrganizedGroups());
            //System.out.println(TestQueue.removeGroups());
            //System.out.println(TestQueue.addCourse());
        }

        // Get the saved info
//        FileManager.loadInfo();
//        AutoSIA.setCourses(FileManager.getInfo());
//
//        // Start threads
//        ThreadCaller.initThreads();
//
//        // Update the files with the new data
//        FileManager.setInfo(AutoSIA.getCourses());
//        FileManager.saveInfo();
//
//        long result = (System.nanoTime() - start)/1_000_000_000;
//        System.out.println(result + " seg / " + result/60.0 + " min");
    }
}