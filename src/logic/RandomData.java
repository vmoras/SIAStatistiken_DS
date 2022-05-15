package logic;

import data.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

public class RandomData {
    private static int size;
    private static DoubleList<Course> coursesDoubleList = new DoubleList<>();
    private static SimpleList<Course> coursesSimpleList = new SimpleList<>();
    private static Queue<Course> coursesQueue = new Queue<>();
    private static Stack<Course> coursesStack = new Stack<>();
    private static Course [] coursesArray;
    private static int counter = 0;

    public static void setSize(int n){
        size = n;
        coursesArray = new Course[n];
    }

    // TODO: DELETE THIS ONCE THE LOAD FROM FILE MANAGER METHOD IS READY
    public static DoubleList<Course> getCoursesDoubleList(){
        return coursesDoubleList;
    }
    public static SimpleList<Course> getCoursesSimpleList(){
        return coursesSimpleList;
    }
    public static Queue<Course> getCoursesQueue(){
        return coursesQueue;
    }
    public static Stack<Course> getCoursesStack(){
        return coursesStack;
    }
    public static Course[] getCoursesArray(){
        return coursesArray;
    }

    public static void generateInfo() throws IOException {
        for (int i = 0; i < size; i++){
            Course newCourse = new Course(generateCode(), generateName());
            newCourse.setGroups(generateGroups());

            coursesDoubleList.add(newCourse);
            coursesSimpleList.add(newCourse);
            coursesQueue.enqueue(newCourse);
            coursesStack.push(newCourse);
            coursesArray[i] = newCourse;
        }

        // Save the generated info
        String name = "test_" + size + ".obj";
        FileManager.setInfo(coursesDoubleList);
        coursesDoubleList.writeObject(FileManager.saveInfo(name));
    }

    private static String generateCode (){
        // Using the UUID random, generate a code for each course
        return String.valueOf(counter);
    }

    private static String generateName (){
        // Generates a random number for a math class
        String name = "Matematicas" + counter;
        counter += 1;
        return name;
    }

    private static Queue<Group> generateGroups (){
        Random random = new Random();
        int upperBound = 1;
        int lowerBound = 0;
        int number = random.nextInt(upperBound - lowerBound) + lowerBound;

        Queue<Group> groups = new Queue<>();
        for (int i = 0; i < number; i++){
            Group group = new Group(String.valueOf(i), generateTeachersName());
            group.setDate(generateDay());
            groups.enqueue(group);
        }

        return groups;
    }

    private static String generateTeachersName(){
        return "Professor" + counter;
    }

    private static Calendar generateDay(){
        return Calendar.getInstance();
    }
}
