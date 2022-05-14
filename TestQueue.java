package logic;

import data.Course;
import data.Group;
import data.Queue;

public class TestQueue {
    private static Queue<Course> courses;
    private static Queue<Course> saved = new Queue<>();
    private static Queue<Course> deleted = new Queue<>();

    public static void setInfo(Queue<Course> data){
        courses = data;
        deleted = data;
    }

    public static long getCourses(){
        /*Returns the courses that have a specific teacher.
        Well in this case since the data was made with random data
        It will use the number of the group*/
        long start = System.nanoTime();
        Course find = courses.dequeue();
        courses.containsValue(find);
        long result = (System.nanoTime() - start)/1_000_000_000;
        return result;
    }

    public static long getOrganizedGroups(){
        /*Gets an organized queue of the groups of each course, based
        on their date */
        Queue<Course> copy = courses.copy();
        long start = System.nanoTime();
        while(!copy.isEmpty()){
            Course course = copy.dequeue();
            Queue<Group> groups = course.getGroups();
        }
        long result = (System.nanoTime() - start)/1_000_000_000;
        return result;
    }

    public static long removeGroups(){
        /*Delete groups with odd number*/
        Queue<Course> copy = courses.copy();
        System.out.println("Queue: contains / size (" + courses.getSize() + ")");

        long start = System.nanoTime();
        while(!copy.isEmpty()){
            Course course = copy.dequeue();
            String name = course.getCourseName();
            if (Integer.parseInt(name.substring(name.length()-1)) % 2 == 0){
                deleted.remove(course);
            }
        }
        long result = (System.nanoTime() - start)/1_000_000_000;
        return result;
    }

    public static long addCourse(){
        /*Add courses which name ends with an odd number */
        Queue<Course> copy = courses.copy();
        System.out.println("Queue: contains / size (" + courses.getSize() + ")");

        long start = System.nanoTime();
        while(copy.getSize() > 0){
            Course course = copy.dequeue();
            String name = course.getCourseName();
            if (Integer.parseInt(name.substring(name.length()-1)) % 2 == 0){
                saved.enqueue(course);
            }
        }
        long result = (System.nanoTime() - start)/1_000_000_000;
        return result;
    }
}
