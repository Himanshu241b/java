package UniversityManagement;

//import statements
import java.util.*;

// University class 
class University {
    private List<Student> students;
    private List<Faculty> faculties;
    private List<Course> courses;

    //University constructor
    public University() {
        this.students = new ArrayList<>();
        this.faculties = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    //method to add student to students list
    public void addStudent(Student student) {
        students.add(student);
    }
    //method to add faculty to faculty list
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
    // methodt to add courses to courses list
    public void addCourse(Course course) {
        courses.add(course);
    }
    //method to return students list
    public List<Student> getStudentList() {
        return students;
    }
    //method to return courses list
    public List<Course> getCourseList() {
        return courses;
    }
    //method to return faculty list
    public List<Faculty> getFacultyList() {
        return faculties;
    }
    
    // method to display all students, faculty and courses in university
    public void displayUniversityDetails() {
        System.out.println("Students:");
        for (Student student : students) {
            student.getDetails();
        }
        System.out.println("\nFaculty:");
        for (Faculty faculty : faculties) {
            faculty.getDetails();
        }
        System.out.println("\nCourses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode() + ", Course Name: " + course.getCourseName() + ", Credits: " + course.getCredits());
        }
    }
}

