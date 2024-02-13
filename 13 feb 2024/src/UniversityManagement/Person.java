package UniversityManagement;

// imports
import java.util.List;
import java.util.ArrayList;

// Abstract class Person
abstract public class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public abstract void getDetails();

    //gets id
    public int getId() {
        return id;
    }
    //gets name
    public String getName() {
        return name;
    }
    // gets age
    public int getAge() {
        return age;
    }
}

// Student class extending Person
class Student extends Person {
    private int studentId;
    private List<Course> courses;

    //constructor of student 
    public Student(int id, String name, int age, int studentId) {
        super(id, name, age);
        this.studentId = studentId;
        this.courses = new ArrayList<>();
    }

    //method to return studentId
    public int getStudentId() {
        return studentId;
    }
    //add couse to add to courses list
    public void enrollCourse(Course course) {
        courses.add(course);
    }

    //display details of student
    @Override
    public void getDetails() {
        System.out.println("Student Name: " + getName());
        System.out.println("Student ID: " + studentId);
        System.out.println("Age: " + getAge());
        System.out.println("Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
    }
}

// Faculty class extending Person
class Faculty extends Person {
    private int employeeId;
    private String department;
    private List<Course> facultyCourses = new ArrayList<>();

    //faculty class constructor
    public Faculty(int id, String name, int age, int employeeId, String department) {
        super(id, name, age);
        this.employeeId = employeeId;
        this.department = department;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    //displays name of faculty teaching the given course
    public void teachCourse(Course course) {
        System.out.println(getName() + " is teaching " + course.getCourseName());
    }

    // method to add course to faculty memeber list of courses
    public void addCourse(Course course) {
        facultyCourses.add(course);
    }


    //displays details of faculty member
    @Override
    public void getDetails() {
        System.out.println("Faculty Name: " + getName());
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Age: " + getAge());
        System.out.println("Department: " + department);
    }
    public List<Course> getFacultyCourses(){
        return facultyCourses;
    }
}

