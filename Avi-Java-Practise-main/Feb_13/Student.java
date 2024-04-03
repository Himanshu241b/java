package Feb_13;
import java.util.*;

public class Student extends Person{
    private static int studentId = 0;
    private List<Course> courses;
    public Student(String name, int age)
    {
        super(name, age);
        Student.studentId += 1;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course)
    {
        if(!courses.contains(course)){
            courses.add(course);
        }
        else System.out.println("Student is already enrolled");
    }

    @Override
    public void getDetails()
    {
        System.out.println("Student Name: " + getName());
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Enrolled Courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName());
        }
    }

}
