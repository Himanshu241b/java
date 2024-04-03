package Feb_13;
import java.util.*;

public class University {

    private List<Student> students;
    private List<Faculty> faculties;
    private List<Course> courses;

    University()
    {
        this.courses = new ArrayList<>();
        this.faculties = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    //method to add or remove student
    public void addStudent(Student student)
    {
        students.add(student);
        System.out.println(student.getName() + " added successfully");
    }
    public void removeStudent(int studentId)
    {
        boolean flag = false;
        String name;
        for(Student s: students)
        {
            if(s.getId() == studentId){
                name = s.getName();
                students.remove(s);
                flag = true;
                System.out.println(name + " removed successfully");
            }
        }
        if(!flag) System.out.println("Can't find ID!");
    }

    //add or remove faculty
    public void addFaculty(Faculty faculty)
    {
        faculties.add(faculty);
        System.out.println(faculty.getName() + " added successfully");
    }
    public void removeFaculty(int employeeId)
    {
        boolean flag = false;
        String name;
        for(Faculty s: faculties)
        {
            if(s.getId() == employeeId){
                name = s.getName();
                faculties.remove(s);
                flag = true;
                System.out.println(name + " removed successfully");
            }
        }
        if(!flag) System.out.println("Can't find ID!");
    }

    //add or remove courses
    public void addCourse(Course course)
    {
        courses.add(course);
        System.out.println(course.getCourseName() + " added successfully");
    }
    public void removeCourse(int courseId)
    {
        boolean flag = false;
        String name;
        for(Course s: courses)
        {
            if(s.getCourseCode() == courseId){
                name = s.getCourseName();
                courses.remove(s);
                flag = true;
                System.out.println(name + " course is removed successfully");
            }
        }
        if(!flag) System.out.println("Can't find course code!");
    }

    //all details
    public void allDetails()
    {
        System.out.println("Students:\n");

        for(Student student: students)
        {
            student.getDetails();
            System.out.println("----------------");
        }

        System.out.println("Courses:\n");

        for(Course course: courses)
        {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Credits: " + course.getCredits());
            System.out.println("------------");
        }
    }

}
