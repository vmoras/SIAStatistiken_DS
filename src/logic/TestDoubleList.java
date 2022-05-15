package logic;

import data.Course;
import data.DoubleList;

public class TestDoubleList {
    private static DoubleList<Course> courses;

    public static void setInfo(DoubleList<Course> data){
        courses = data;
    }

    public static long getCourse(){
        /* Returns the time needed to get a course by searching all the list
         * Test for search */

        DoubleList<Course> copy = courses.copy();
        String find = String.valueOf(courses.getSize() - 1);

        long start = System.nanoTime();
        copy.containsValue(find);

        return (System.nanoTime() - start);
    }

    public static long accessCourse(){
        /* Returns the time needed to access a course using their index
         * Test for access */

        DoubleList<Course> copy = courses.copy();
        int index = copy.getSize() - 1;

        long start = System.nanoTime();
        copy.get(index);

        return (System.nanoTime() - start);
    }

    public static long removeCourse(boolean front){
        /* Returns the time needed to remove a course
        in the front part of the structure or the back
         * Test for delete */

        DoubleList<Course> deleted = courses.copy();

        long start = System.nanoTime();
        if (front){
            deleted.removeFirst();
        } else{
            deleted.removeLast();
        }

        return (System.nanoTime() - start);
    }

    public static long addCourse(boolean front){
        /* Returns the time needed to remove a course
        in the front part of the structure or the back
         * Test for add*/

        DoubleList<Course> copy = courses.copy();
        DoubleList<Course> added = new DoubleList<>();

        Course course = copy.removeFirst();
        long start = System.nanoTime();
        if (front){
            added.addFirst(course);
        } else{
            added.addLast(course);
        }

        return (System.nanoTime() - start) / added.getSize();
    }
}
