package classroom;

import java.util.ArrayList;
import java.util.List;

class PythonCourse extends Course{
    private int courseId = 2;
    private String courseName = "Python";

    private List<Task> pythonTasks = new ArrayList<Task>();
    PythonCourse(String courseName){
        super(courseName);
    }

    //getters and setters
    public int getCourseId() {
        return courseId;
    }

    public List<Task> getPythonTasks(){
        return pythonTasks;
    }
    public void addPythonTask(Task task){
        pythonTasks.add(task);
    }
}