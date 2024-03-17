package classroom;

//imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main{


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int taskIdCount = 0;
        final String studentLoginFilePath = "/home/himanshu/Desktop/Avisoft/java/Weekly-Assignment6/src/database/studentLoginFile.csv";
        final String adminLoginFilePath = "/home/himanshu/Desktop/Avisoft/java/Weekly-Assignment6/src/database/adminLoginFile.csv";
        List<User> studentList = new ArrayList<User>();
        List<Course> coursesList = new ArrayList<Course>();
        User student = null;
        User admin = null;
        do{
            System.out.println("Press 1: To continue as a student.");
            System.out.println("Press 2: To continue as an admin");
            System.out.println("Press 0: To exit...");

            char choice = scanner.next().charAt(0);

            switch(choice){
                case '1':
                    do {
                        System.out.println("Press 1: To login.");
                        System.out.println("Press 2: To join a course.");
                        System.out.println("Press 3: To display all tasks.");
                        System.out.println("Press 4: To submit a task.");
                        System.out.println("Press 0: To logout.");

                        char studentChoice = scanner.next().charAt(0);
                        switch(studentChoice){
                            case '1':
                                if(student == null) {
                                    String studentEmail;
                                    System.out.println("Enter your email: ");
                                    while (true) {
                                        studentEmail = scanner.next();
                                        if (InputValidator.validateEmail(studentEmail)) {
                                            break;
                                        }
                                        System.out.println("Enter valid email:");
                                    }
                                    System.out.println("Enter your password");
                                    String password = scanner.next();
                                    student = LoginManager.login(studentEmail, password, studentLoginFilePath);
                                }else
                                    System.out.println("Already logged in. Logout First.");
                                break;
                            case '2':
                                if(student == null){
                                System.out.println("Login first.");
                                break;
                                }
                                System.out.println("Select a course:");
                                System.out.println("1. Java Course");
                                System.out.println("2. Python Course");
                                System.out.println("3. Mern Course");
                                int courseChoice = scanner.nextInt();
                                Course courseToJoin = null;
                                switch(courseChoice){
                                    case 1:
                                        courseToJoin = new JavaCourse("javaCourse");
                                        break;
                                    case 2:
                                        courseToJoin = new PythonCourse("pythonCourse");
                                        break;
                                    case 3:
                                        courseToJoin = new MernCourse("mernCourse");
                                        break;

                                    default:
                                        System.out.println("Enter valid input");
                                }
                                CourseManager.joinCourse(coursesList , student, studentList, courseToJoin);
                                break;
                            case '3':
                                if(student == null){
                                    System.out.println("Login first.");
                                    break;
                                }
                                TaskManager.displayAllTasksOfStudent(student, studentList);
                                break;
                            case '4':
                                if(student == null){
                                    System.out.println("Login first.");
                                    break;
                                }
                                if(TaskManager.displayAllTasksOfStudent(student,studentList)) {
                                    System.out.println("Enter the id of task to submit:");
                                    int submitTaskId = scanner.nextInt();
                                    TaskManager.submitTask(student, submitTaskId, studentList);
                                }
                                break;
                            case '0':
                                student = null;
                                break;
                            default:
                                System.out.println("Enter valid input");
                        }
                    }
                    while(student != null);
                    break;
                case '2':
                    do{
                        System.out.println("Press 1: To login.");
                        System.out.println("Press 2: To make a course.");
                        System.out.println("Press 3: To add a Task.");
                        System.out.println("Press 0: To log out.");

                        char adminChoice = scanner.next().charAt(0);

                        switch (adminChoice){
                            case '1':
                                if(admin == null){
                                    String studentEmail;
                                    System.out.println("Enter your email: ");
                                    while (true) {
                                        studentEmail = scanner.next();
                                        if (InputValidator.validateEmail(studentEmail)) {
                                            break;
                                        }
                                        System.out.println("Enter valid email:");
                                    }
                                    System.out.println("Enter your password");
                                    String password = scanner.next();
                                    admin = LoginManager.login(studentEmail, password, adminLoginFilePath);
                                }else
                                    System.out.println("Already logged in. Logout First.");
                                break;
                            case '2':
                                if(admin == null){
                                    System.out.println("Login first.");
                                    break;
                                }
                                System.out.println("Select from below courses:");
                                System.out.println("Press 1 : For Java course.");
                                System.out.println("Press 2 : For Python course.");
                                System.out.println("Press 3 : For Mern course");

                                char courseChoice = scanner.next().charAt(0);

                                switch(courseChoice){
                                    case '1':
                                        CourseManager.createCourse(coursesList, new JavaCourse("javaCourse"));;
                                        break;
                                    case '2':
                                        CourseManager.createCourse(coursesList, new PythonCourse("pythonCourse"));;
                                        break;
                                    case '3':
                                        CourseManager.createCourse(coursesList, new MernCourse("mernCourse"));;
                                        break;
                                    default:
                                        System.out.println("Wrong choice selected");
                                }
                                break;
                            case '3':
                                if(admin == null){
                                    System.out.println("Login first.");
                                    break;
                                }
                                Task newTask = TaskManager.createTask(++taskIdCount);
                                TaskManager.addTask(newTask, studentList, coursesList);
                                break;
                            case '0':
                                admin = null;
                                break;
                            default:
                                System.out.println("Enter valid choice");
                        }

                    }while(admin != null);
                    break;
                case '0':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid choice.");
            }

        }while(true);
    }
}