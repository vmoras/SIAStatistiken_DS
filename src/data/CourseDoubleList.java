package data;

public class CourseDoubleList implements java.io.Serializable{
    private String courseCode;
    private String courseName;
    private DoubleList<Group> groups;

    public CourseDoubleList(String courseCode, String courseName){
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public DoubleList<Group> getGroups() {
        return groups;
    }

    public void setCourseCode(String nameCourse) {
        this.courseCode = nameCourse;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setGroups(DoubleList<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }

        if (obj instanceof String){
            return obj.equals(this.getCourseCode());
        }

        if (!(obj instanceof Course)){
            return false;
        }

        Course compare = (Course) obj;
        return compare.getCourseCode().equals(this.getCourseCode());
    }

    public String print(){
        return this.courseName + ": " + this.courseCode;
    }
}
