package data;

public class Course implements java.io.Serializable{
    private String courseCode;
    private String courseName;
    private Queue<Group> groups;

    public Course(String courseCode, String courseName){
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public Queue<Group> getGroups() {
        return groups;
    }

    public void setCourseCode(String nameCourse) {
        this.courseCode = nameCourse;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setGroups(Queue<Group> groups) {
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

    public String print() {
        Queue<Group> copy = new Queue<>(this.groups);
        String info = this.courseName + ": " + this.courseCode + "\n";
        for (int i = 0 ; i < this.getGroups().getSize(); i++){
            info += copy.dequeue().print();
        }
        return info;
    }
}
