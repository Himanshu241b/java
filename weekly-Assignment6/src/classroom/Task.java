package classroom;

//imports
import java.time.LocalDate;
import java.time.LocalDateTime;

class Task{
    private int taskId;
    private String taskTitle;
    private String taskDescription;
    private Priority taskPriority;
    private LocalDateTime taskDueDate;
    private Status taskStatus = Status.Pending;

    //constructors
    Task(int id, String title, String description,Priority priority, LocalDateTime dueDate){
        this.taskId = id;
        this.taskTitle = title;
        this.taskDescription = description;
        this.taskPriority = priority;
        this.taskDueDate = dueDate;
    }

    //getters and setters
    public int getTaskId() {
        return taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDateTime getTaskDueDate() {
        return taskDueDate;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public Priority getTaskPriority() {
        return taskPriority;
    }

    public Status getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Status taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void displayTask(){
        System.out.println("Task id: " + taskId);
        System.out.println("Task title: "+taskTitle);
        System.out.println("Task description: "+taskDescription);
        System.out.println("Task priority: "+taskPriority);
        System.out.println("Task status: "+taskStatus);
        System.out.println("Task due date: "+taskDueDate);
    }

}