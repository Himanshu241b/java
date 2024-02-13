package UniversityManagement;

// import statements
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        // Create University object
        University university = new University();

        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            // Display menu options
            System.out.println("\nUniversity Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Faculty");
            System.out.println("3. Add Course");
            System.out.println("4. Display University Details");
            System.out.println("5. Enroll in a course");
            System.out.println("6. Assign course to a teacher");
            System.out.println("7. To remove a student from university");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    addStudent(university, scanner);
                    break;
                case '2':
                    addFaculty(university, scanner);
                    break;
                case '3':
                    addCourse(university, scanner);
                    break;
                case '4':
                    university.displayUniversityDetails();
                    break;
                case '5':
                    try{
                    enrollCourse(university, scanner);
                    }catch(IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case '6':
                    System.out.println("Enter employee id of teacher:");
                    Faculty employee = null;
                    int employeeId = scanner.nextInt();
                    for(Faculty faculty : university.getFacultyList())
                        if(faculty.getEmployeeId() == employeeId)
                            employee = faculty;
                    if(employee == null)
                        System.out.println("Faculty not found");
                    System.out.println("Enter course code to assign a course:");
                    Course courseToAssign = null;   
                    String courseCode = scanner.nextLine();
                    for(Course course : university.getCourseList())
                        if(course.getCourseCode() == courseCode)
                            courseToAssign = course;
                    if(courseToAssign == null)
                        System.out.println("Course not found");
                    try{
                    addCourseToFaculty(employee, courseToAssign);
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case '7':
                    try{
                        removeStudent(university,scanner);
                    }
                    catch(IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case '0':
                    System.out.println("Terminating...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != '0');

        scanner.close();
    }

    //method to remove a student from university
    public static void removeStudent(University university,Scanner sc){
        System.out.println("Enter student id");
        Student studentToRemove = null;
        int studentId = sc.nextInt();
        for(Student student : university.getStudentList())
            if(student.getStudentId() == studentId)
                studentToRemove = student;
        if(studentToRemove == null){
            System.out.println("Student not registered.");
            throw new IllegalStateException("Cant remove student");
        }
        university.getStudentList().remove(studentToRemove);
    }

    //method to add a course to a teacher
    public static void addCourseToFaculty(Faculty faculty, Course courseToAssign){
        if (faculty == null) {
            throw new IllegalArgumentException("Faculty cannot be null.");
        }
        if (courseToAssign == null) {
            throw new IllegalArgumentException("Course to assign cannot be null.");
        }
        faculty.addCourse(courseToAssign);
    }

    //Method to enroll in a course
    public static void enrollCourse(University university, Scanner scanner ){
        System.out.println("Enter your studentId:");
        int studentId = scanner.nextInt();

        //search student in students list
        Student enrollingStudent= null;
        for(Student student : university.getStudentList())
            if(student.getStudentId()== studentId)
                enrollingStudent = student;
        if(enrollingStudent == null){
            System.out.println("Student not found.");
            throw new IllegalStateException("Student not found");
        }
        scanner.nextLine(); // consumes nextline character
        System.out.println("Enter course name you want to join:");
        String courseName = scanner.nextLine();

        //search the course in courses list
        Course enrollingCourse = null;
        for(Course course: university.getCourseList())
            if(course.getCourseName().equals(courseName))
                enrollingCourse = course;
        if(enrollingCourse == null){
            System.out.println("Course not found.");
            throw new IllegalStateException("Course not found");
        }
        //enrolls the student to the course
        enrollingStudent.enrollCourse(enrollingCourse);
        System.out.println("Student enrolled successfully");
    }
    // Method to add a student
public static void addStudent(University university, Scanner scanner) {
    System.out.println("Enter student details:");

    try {
        System.out.print("ID: ");
        int id = scanner.nextInt();

        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        System.out.print("Student ID: ");
        int studentId = scanner.nextInt();

        // Create the student object
        Student student = new Student(id, name, age, studentId);

        // Add the student to the university
        university.addStudent(student);

        System.out.println("Student added successfully!");
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter valid integer values.");
        scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
    }
}


    // Method to add a faculty
public static void addFaculty(University university, Scanner scanner) {
    System.out.println("Enter faculty details:");
    try {
        System.out.print("ID: ");
        int id = scanner.nextInt();

        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        System.out.print("Employee ID: ");
        int employeeId = scanner.nextInt();

        System.out.print("Department: ");
        String department = scanner.next();

        Faculty faculty = new Faculty(id, name, age, employeeId, department);
        university.addFaculty(faculty);
        System.out.println("Faculty added successfully!");
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter valid integer values.");
        scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
    }
}

// Method to add a course
public static void addCourse(University university, Scanner scanner) {
    System.out.println("Enter course details:");
    try {
        System.out.print("Course Code: ");
        String courseCode = scanner.next();

        System.out.print("Course Name: ");
        String courseName = scanner.next();

        System.out.print("Credits: ");
        int credits = scanner.nextInt();

        Course course = new Course(courseCode, courseName, credits);
        university.addCourse(course);
        System.out.println("Course added successfully!");
    } catch (InputMismatchException e) {
        
        System.out.println("Invalid input. Please enter valid integer values.");
        scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
    }
}

}

