package logic;

import data.Course;
import data.DoubleList;

import java.io.*;

public class FileManager {
    private static DoubleList<Course> courses = new DoubleList<>();

    public static void loadInfo(){
        loadInfo(null);
    }

    public static void loadInfo(String name){
        try {
            if (name == null){
                name = "courses.obj";
            }
            // Get the file
            FileInputStream fileStream = new FileInputStream("data/" +name);

            // Load the double list
            ObjectInputStream os = new ObjectInputStream(fileStream);

            // Get the info
            courses = (DoubleList<Course>) os.readObject();

            // Close both stream
            fileStream.close();
            os.close();

        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void saveInfo() throws IOException {
        saveInfo(null);
    }

    public static ObjectOutputStream saveInfo(String name) throws IOException{
        try {
            if (name == null){
                name = "courses.obj";
            }
            // Get or create the file
            FileOutputStream fileStream = new FileOutputStream("data/" +name);

            // Load the list
            ObjectOutputStream os = new ObjectOutputStream(fileStream);

            return os;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static DoubleList<Course> getInfo(){
        return courses;
    }

    public static void setInfo(DoubleList<Course> info){
        courses = info;
    }
}
