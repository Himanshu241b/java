package medicalmanagement;

import java.util.ArrayList;
import java.util.List;

class User {
    private String email;
    private String name;
    private List<Course> subscribedCoursesList = new ArrayList<>();
    private List<Course> ownedCoursesList = new ArrayList<>();

    private List<Task> tasksList = new ArrayList<>();

    User(String email, String name) {
        this.email = email;
        this.name = name;
    }
    // getters and setters


    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getSubscribedCoursesList() {
        return subscribedCoursesList;
    }

    public List<Course> getOwnedCoursesList() {
        return ownedCoursesList;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addSubscribedCourseList(Course course) {
        subscribedCoursesList.add(course);
    }

    public List<Task> getTasksList() {
        return tasksList;
    }
    public void addTaskToList(Task task) {
        tasksList.add(task);
    }
    public void addownedCourseList(Course course) {ownedCoursesList.add(course);}


}