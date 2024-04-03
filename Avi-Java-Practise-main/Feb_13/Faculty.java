package Feb_13;

public class Faculty extends Person{
    private static int employeeId = 0;
    private String department;

    public Faculty(String name, int age, String department)
    {
        super(name, age);
        Faculty.employeeId += 1;
        this.department = department;
    }
    //getters
    public int getEmployeeId()
    {
        return employeeId;
    }
    public String getDepartment()
    {
        return department;
    }

    public void teachCourse(Course course)
    {
        System.out.println(getName() + " is teaching " + course.getCourseName() + ".");
    }

    //overrides
    @Override
    public void getDetails() {
        System.out.println("Faculty Employee ID: " + employeeId);
        System.out.println("Faculty Name: " + getName());
        System.out.println("Faculty Department: " + getDepartment());
        System.out.println("Faculty Age: " + getAge());
    }
}
