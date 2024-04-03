package classroom;

import java.util.ArrayList;
import java.util.List;

class JavaCourse extends Course{
    private int courseId = 1;
    private String courseName = "javaCourse";

    private List<Task> javaTasks = new ArrayList<Task>();
    JavaCourse(String courseName){
        super(courseName);
    }

    //getters and setters
    public int getCourseId(){
        return courseId;
    }

    public List<Task> getJavaTasks(){
        return javaTasks;
    }
    public void addJavaTask(Task task){
        javaTasks.add(task);
    }
}
