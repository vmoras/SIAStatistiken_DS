package logic;

import data.Course;
import data.Queue;

public class TestQueue {
    private static Queue<Course> courses;

    public static void setInfo(Queue<Course> data){
        courses = data;
    }

    public static long getCourse(){
        /* Returns the time needed to get a course by searching all the list
         * Test for search */

        Queue<Course> copy = new Queue<>(courses);
        String find = String.valueOf(courses.getSize() / 2);

        long start = System.nanoTime();
        copy.containsValue(find);

        return (System.nanoTime() - start);
    }

    public static long accessCourse(){
        /* Returns the time needed to access a course using their index
         * Test for access */

        Queue<Course> copy = new Queue<>(courses);
        int index = copy.getSize() - 1;

        long start = System.nanoTime();
        copy.get(index);

        return (System.nanoTime() - start);
    }

    public static long removeCourse(){
        /* Returns the time needed to remove a course
         * Test for delete */

        Queue<Course> deleted = new Queue<>(courses);

        long start = System.nanoTime();
        deleted.dequeue();

        return (System.nanoTime() - start);
    }

    public static long addCourse(){
        /* Returns the time needed to remove a course
         * Test for add*/

        Queue<Course> copy = new Queue<>(courses);

        Course course = copy.dequeue();
        long start = System.nanoTime();
        copy.enqueue(course);

        return (System.nanoTime() - start);
    }
}
