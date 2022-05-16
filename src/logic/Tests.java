package logic;

import data.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Tests {
    public static String[][] infoDoubleList = new String[6][6];
    public static String[][] infoSimpleList = new String[6][6];
    public static String[][] infoQueue = new String[4][6];
    public static String[][] infoStack = new String[4][6];

    public static void startTest() throws IOException {
        setArrays();
        int row = 1;

        System.out.println("Start test");
        for (int i = 100; i < 101; i *= 10){
            // Set size of tests and get the random info
            RandomData.setSize(i);
            RandomData.generateInfo();

            // Get each data structure
            DoubleList<Course> infoDL = RandomData.getCoursesDoubleList();
            SimpleList<Course> infoSL = RandomData.getCoursesSimpleList();
            Queue<Course> infoQ = RandomData.getCoursesQueue();
            Stack<Course> infoS = RandomData.getCoursesStack();

            // Save Double list's result
            TestDoubleList.setInfo(infoDL);
            infoDoubleList[0][row] = String.valueOf(TestDoubleList.getCourse());
            infoDoubleList[1][row] = String.valueOf(TestDoubleList.accessCourse());
            infoDoubleList[2][row] = String.valueOf(TestDoubleList.removeCourse(true));
            infoDoubleList[3][row] = String.valueOf(TestDoubleList.removeCourse(false));
            infoDoubleList[4][row] = String.valueOf(TestDoubleList.addCourse(true));
            infoDoubleList[5][row] = String.valueOf(TestDoubleList.addCourse(false));

            // Save Simple list's result
            TestSimpleList.setInfo(infoSL);
            infoSimpleList[0][row] = String.valueOf(TestSimpleList.getCourse());
            infoSimpleList[1][row] = String.valueOf(TestSimpleList.accessCourse());
            infoSimpleList[2][row] = String.valueOf(TestSimpleList.removeCourse(true));
            infoSimpleList[3][row] = String.valueOf(TestSimpleList.removeCourse(false));
            infoSimpleList[4][row] = String.valueOf(TestSimpleList.addCourse(true));
            infoSimpleList[5][row] = String.valueOf(TestSimpleList.addCourse(false));

            // Save Queue's result
            TestQueue.setInfo(infoQ);
            infoQueue[0][row] = String.valueOf(TestQueue.getCourse());
            infoQueue[1][row] = String.valueOf(TestQueue.accessCourse());
            infoQueue[2][row] = String.valueOf(TestQueue.removeCourse());
            infoQueue[3][row] = String.valueOf(TestQueue.addCourse());

            // Save Stack's result
            TestStack.setInfo(infoS);
            infoStack[0][row] = String.valueOf(TestStack.getCourse());
            infoStack[1][row] = String.valueOf(TestStack.accessCourse());
            infoStack[2][row] = String.valueOf(TestStack.removeCourse());
            infoStack[3][row] = String.valueOf(TestStack.addCourse());

            row ++;
            System.out.println("    Finished size " + i);
        }

        organizeData();
        System.out.println("Test finished");
    }

    private static void setArrays(){
        String[][][] lists = {infoDoubleList, infoSimpleList};
        for (String[][] list: lists){
            list[0][0] = "Get";
            list[1][0] = "Access";
            list[2][0] = "Remove back";
            list[3][0] = "Remove front";
            list[4][0] = "Add back";
            list[5][0] = "Add front";
        }

        String[][][] otherLists = {infoQueue, infoStack};
        for (String[][] otherList: otherLists){
            otherList[0][0] = "Get";
            otherList[1][0] = "Access";
            otherList[2][0] = "Remove";
            otherList[3][0] = "Add";
        }
    }
    private static void organizeData(){
        String empty = ",,,,,\n";
        String dL = "Double list,,,,\n";
        String sL = "Simple list,,,,\n";
        String q = "Queue,,,,\n";
        String s = "Stack,,,,\n";
        String size = ",100,1000,10000,1000000,10000000\n";

        String[][][] info = {infoDoubleList, infoSimpleList, infoQueue, infoQueue};
        String[] names = {dL, sL, q, s};

        StringBuilder data = new StringBuilder();
        data.append(size);
        for (int i = 0; i < info.length; i++){
            data.append(names[i]);
            for (String[] row: info[i]){
                String m = Arrays.toString(row);
                data.append(m.substring(1, m.length()-1) + "\n");
            }
            data.append(empty);
        }

        saveToCSV(data.toString());
    }

    private static void saveToCSV(String data){
        try (PrintWriter writer = new PrintWriter("data/compare.csv")) {
            writer.write(data);
            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }




}
