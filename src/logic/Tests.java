package logic;

import data.*;

import java.io.IOException;

public class Tests {
    public static void startTest() throws IOException {
        // Set size of tests and get the random info
        RandomData.setSize(100);
        RandomData.generateInfo();

        // Test the speed
        DoubleList<Course> infoDL = RandomData.getCoursesDoubleList();
        SimpleList<Course> infoSL = RandomData.getCoursesSimpleList();
        Queue<Course> infoQ = RandomData.getCoursesQueue();
        Stack<Course> infoS = RandomData.getCoursesStack();
        /*for (Node<Course> head = info.getHead(); head != null; head = head.getNext()){
            System.out.println(head.getData().print());
        }*/

        /*TODO
        *  agregar write en SimpleList para poder usarlo
        *  agregar read para poder poner numeros mas grandes (copy usa eso)*/



        TestDoubleList.setInfo(infoDL);
        System.out.println("DoubleList: size (" + infoDL.getSize() + ")");
        System.out.println("    Get (specific object): " + TestDoubleList.getCourse() + " nanoseconds");
        System.out.println("    Access (using index):  " + TestDoubleList.accessCourse() + " nanoseconds");
        System.out.println("    Remove front:          " + TestDoubleList.removeCourse(true) + " nanoseconds");
        System.out.println("    Remove back:           " + TestDoubleList.removeCourse(false) + " nanoseconds");
        System.out.println("    Add front:             " + TestDoubleList.addCourse(true) + " nanoseconds");
        System.out.println("    Add back:              " + TestDoubleList.addCourse(false) + " nanoseconds");

        /*TestSimpleList.setInfo(infoSL);
        System.out.println("SimpleList: size (" + infoSL.getSize() + ")");
        System.out.println("    Get (specific object): " + TestSimpleList.getCourse() + " nanoseconds");
        System.out.println("    Access (using index):  " + TestSimpleList.accessCourse() + " nanoseconds");
        System.out.println("    Remove front:          " + TestSimpleList.removeCourse(true) + " nanoseconds");
        System.out.println("    Remove back:           " + TestSimpleList.removeCourse(false) + " nanoseconds");
        System.out.println("    Add front:             " + TestSimpleList.addCourse(true) + " nanoseconds");
        System.out.println("    Add back:              " + TestSimpleList.addCourse(false) + " nanoseconds");*/

        TestQueue.setInfo(infoQ);
        System.out.println("Queue: size (" + infoQ.getSize() + ")");
        System.out.println("    Get (specific object): " + TestQueue.getCourse() + " nanoseconds");
        System.out.println("    Access (using index):  " + TestQueue.accessCourse() + " nanoseconds");
        System.out.println("    Remove:                " + TestQueue.removeCourse() + " nanoseconds");
        System.out.println("    Add:                   " + TestQueue.addCourse() + " nanoseconds");

        TestStack.setInfo(infoS);
        System.out.println("Stack: size (" + infoS.getSize() + ")");
        System.out.println("    Get (specific object): " + TestStack.getCourse() + " nanoseconds");
        System.out.println("    Access (using index):  " + TestStack.accessCourse() + " nanoseconds");
        System.out.println("    Remove:                " + TestStack.removeCourse() + " nanoseconds");
        System.out.println("    Add:                   " + TestStack.addCourse() + " nanoseconds");
    }
}
