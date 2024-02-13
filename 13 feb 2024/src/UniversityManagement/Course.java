package UniversityManagement;


// Course class with encapsulation
public class Course {
    private String courseCode;
    private String courseName;
    private int credits;

    //constructor to instantiate course
    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }

    
    //gets course code
    public String getCourseCode() {
        return courseCode;
    }
    //gets the course name
    public String getCourseName() {
        return courseName;
    }
    //gets credits of course
    public int getCredits() {
        return credits;
    }
}
