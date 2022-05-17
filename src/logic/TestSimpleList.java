package logic;

import data.Course;
import data.SimpleList;

public class TestSimpleList {
    private static SimpleList<Course> courses;

    public static void setInfo(SimpleList<Course> data){
        courses = data;
    }

    public static long getCourse(){
        /* Returns the time needed to get a course by searching all the list
         * Test for search */

        SimpleList<Course> copy = new SimpleList<>(courses);
        String find = String.valueOf(courses.getSize() - 1);

        long start = System.nanoTime();
        copy.containsValue(find);

        return (System.nanoTime() - start);
    }

    public static long accessCourse(){
        /* Returns the time needed to access a course using their index
         * Test for access */

        SimpleList<Course> copy = new SimpleList<>(courses);
        int index = copy.getSize() - 1;

        long start = System.nanoTime();
        copy.get(index);

        return (System.nanoTime() - start);
    }

    public static long removeCourse(boolean front){
        /* Returns the time needed to remove a course
        in the front part of the structure or the back
         * Test for delete */

        SimpleList<Course> deleted = new SimpleList<>(courses);

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

        SimpleList<Course> copy = new SimpleList<>(courses);

        Course course = copy.removeFirst();
        long start = System.nanoTime();
        if (front){
            copy.addFirst(course);
        } else{
            copy.addLast(course);
        }

        return (System.nanoTime() - start) ;
    }
}
