package logic;

import data.Course;
import data.DoubleList;
import data.Group;
import data.Queue;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

public class RandomData {
    private static int size;
    private static DoubleList<Course> courses = new DoubleList<>();
    private static int counter = 0;

    public static void setSize(int n){
        size = n;
    }

    public static void generateInfo() throws IOException {
        for (int i = 0; i < size/5; i++){
            Course newCourse = new Course(generateCode(), generateName());
            newCourse.setGroups(generateGroups());
            courses.add(newCourse);
        }

        // Save the generated info
        String name = "test_" + String.valueOf(size) + ".obj";
        FileManager.setInfo(courses);
        courses.writeObject(FileManager.saveInfo(name));
    }

    private static String generateCode (){
        // Using the UUID random, generate a code for each course
        return UUID.randomUUID().toString().substring(0, (int)Math.log10((double)size));
    }

    private static String generateName (){
        // Generates a random number for a math class
        String name = "Matematicas" + counter;
        counter += 1;
        return name;
    }

    private static Queue<Group> generateGroups (){
        Random random = new Random();
        int upperBound = 10;
        int lowerBound = 5;
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
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphaNumeric = upperAlphabet + lowerAlphabet;

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 10;

        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    private static Calendar generateDay(){
        Random random = new Random();
        int minDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate day = LocalDate.ofEpochDay(randomDay);

        Calendar calendar = Calendar.getInstance();
        calendar.set(day.getYear(), day.getMonthValue()-1, day.getDayOfMonth());

        return calendar;
    }
}
