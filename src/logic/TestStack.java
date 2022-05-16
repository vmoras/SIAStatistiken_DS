package logic;

import data.Course;
import data.Stack;

public class TestStack {
    private static Stack<Course> courses;

    public static void setInfo(Stack<Course> data){
        courses = data;
    }

    public static long getCourse(){
        /* Returns the time needed to get a course by searching all the list
         * Test for search */

        Stack<Course> copy = new Stack<>(courses);
        String find = String.valueOf(courses.getSize() - 1);

        long start = System.nanoTime();
        copy.containsValue(find);

        return (System.nanoTime() - start);
    }

    public static long accessCourse(){
        /* Returns the time needed to access a course using their index
         * Test for access */

        Stack<Course> copy = new Stack<>(courses);
        int index = copy.getSize() - 1;

        long start = System.nanoTime();
        copy.get(index);

        return (System.nanoTime() - start);
    }

    public static long removeCourse(){
        /* Returns the time needed to remove a course
         * Test for delete */

        Stack<Course> deleted = new Stack<>(courses);

        long start = System.nanoTime();
        deleted.pop();

        return (System.nanoTime() - start);
    }

    public static long addCourse(){
        /* Returns the time needed to remove a course
        in the front part of the structure or the back
         * Test for add*/

        Stack<Course> copy = new Stack<>(courses);
        Stack<Course> added = new Stack<>();

        Course course = copy.pop();
        long start = System.nanoTime();
        added.push(course);

        return (System.nanoTime() - start) / added.getSize();
    }
}
