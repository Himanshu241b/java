package classroom;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * TaskManager class to manage the task related tasks
 */
public class TaskManager {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Method to create a new task by admin
     * @param taskId id of new task
     * @return the new generated task
     */
    public static Task createTask(int taskId){

        System.out.println("Enter task title:");
        String taskTitle = scanner.next();
        System.out.println("Enter task description:");
        String taskDescription = scanner.next();

        System.out.println("Enter task priority:");
        System.out.println("1. Low priority");
        System.out.println("2. Moderate priority");
        System.out.println("3. High priority");
        int priority = scanner.nextInt();
        Priority taskPriority = Priority.Low;
        switch(priority){
            case 1:
                taskPriority = Priority.Low;
                break;
            case 2:
                taskPriority = Priority.Moderate;
                break;
            case 3:
                taskPriority = Priority.High;
                break;
            default:
                System.out.println("Enter valid priority");
        }
        System.out.print("Enter datetime in the format yyyy-MM-dd-HH-mm: ");
        String inputDate;
        try {
            while (true) {
                inputDate = scanner.next();
                if (InputValidator.validateDateTimeFormat(inputDate)) {
                    break;
                }
                System.out.println("Enter date in correct format:(YYYY-MM-DD-HH-mm:");
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
            LocalDateTime dueDate = LocalDateTime.parse(inputDate, formatter);
            Task task = new Task(taskId, taskTitle, taskDescription, taskPriority, dueDate);

            return task;
        }
        catch(DateTimeException dateTimeException){
            dateTimeException.printStackTrace();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * Method to add a new task to the tasklist of students enrolled in the course/class
     * @param task task to assign
     * @param studentsList students list that are in any class
     * @param coursesList courses that are made by the admin
     */
    public static void addTask(Task task, List<User> studentsList, List<Course> coursesList){
        System.out.println("select the class you want to add task to:");
        System.out.println("1. Java Course");
        System.out.println("2. Python Course");
        System.out.println("3. Mern Course");
        char courseChoice = scanner.next().charAt(0);
        int courseId = 0;
        switch (courseChoice){
            case '1':
                courseId = 1;
                for(Course course : coursesList){
                    if(course.getCourseId() != courseId){
                        System.out.println("Course does not exist.");
                        return;
                    }
                }
                for(User student : studentsList){
                    for(Course course : student.getSubscribedCoursesList()){
                        if(course.getCourseId() == courseId){
                            student.addTaskToList(task);
                            JavaCourse javaCourse = (JavaCourse)course;
                            javaCourse.addJavaTask(task);
                        }
                    }
                }
                System.out.println("task added successfully.");
                return;
            case '2':
                courseId = 2;
                for(Course course : coursesList){
                    if(course.getCourseId() != courseId){
                        System.out.println("Course does not exist.");
                        return;
                    }
                }
                for(User student : studentsList){
                    for(Course course : student.getSubscribedCoursesList()){
                        if(course.getCourseId() == courseId){
                            student.addTaskToList(task);
                            PythonCourse pythonCourse = (PythonCourse) course;
                            pythonCourse.addPythonTask(task);
                        }
                    }
                }
                System.out.println("task added successfully.");
                return;
            case '3':
                courseId = 3;
                for(Course course : coursesList){
                    if(course.getCourseId() != courseId){
                        System.out.println("Course does not exist.");
                        return;
                    }
                }
                for(User student : studentsList){
                    for(Course course : student.getSubscribedCoursesList()){
                        if(course.getCourseId() == courseId){
                            student.addTaskToList(task);
                            MernCourse mernCourse = (MernCourse) course;
                            mernCourse.addMernTask(task);
                        }
                    }
                }
                System.out.println("task added successfully.");
                return;
            default:
                System.out.println("Enter valid choice.");
        }
    }

    /**
     * Method to display all the tasks of a student
     * @param student Current logged in student
     * @param studentsList students list that are in any class
     * @return returns false if the student is not enrolled in any of the course
     */
    public static boolean displayAllTasksOfStudent(User student, List<User> studentsList) {
        boolean isStudentListed = false;
        for(User listedStudent : studentsList) {
            if (listedStudent.getEmail().equals(student.getEmail())) {
                isStudentListed = true;
            }
        }
        if(!isStudentListed){
            System.out.println("You have not joined any course.");
            return false;
        }
        for(User listedStudent : studentsList){
            if(listedStudent.getEmail().equals(student.getEmail())){
                if(listedStudent.getTasksList().isEmpty()){
                    System.out.println("NO tasks assisgned.");
                }
                else {
                    for (Task task : listedStudent.getTasksList()) {
                        task.displayTask();
                    }
                }
            }
        }
        return true;
    }

    /**
     * Method to submit a task by the student
     * @param student current logged in student
     * @param submitTaskId id of the task to submit
     * @param studentsList list of students who have enrolled in any of the courses
     */
    public static void submitTask(User student, int submitTaskId, List<User> studentsList){
        boolean isStudentInACourse = false;
        for(User listedStudent: studentsList){
            if(listedStudent.getEmail().equals(student.getEmail())){
                isStudentInACourse = true;
                break;
            }
        }
        if(!isStudentInACourse){
            System.out.println("You have not joined any course/class.");
            return;
        }
        try {
            for (User listedStudent : studentsList) {
                if (listedStudent.getEmail().equals(student.getEmail())) {
                    for (Task task : listedStudent.getTasksList()) {
                        if (task.getTaskId() == submitTaskId) {
                            listedStudent.getTasksList().remove(task);
                            LocalDateTime currentDateTime = LocalDateTime.now();
                            if (task.getTaskDueDate().isAfter(currentDateTime)) {
                                System.out.println("Task submitted on time successfully.");
                            } else {
                                System.out.println("Late submission of task.");
                            }
                            return;
                        }
                    }
                    System.out.println("NO task found with id " + submitTaskId);
                }
            }
        }
        catch (DateTimeException dateTimeException) {
            dateTimeException.printStackTrace();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

}
