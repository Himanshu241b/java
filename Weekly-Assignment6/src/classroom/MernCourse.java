package classroom;

import java.util.ArrayList;
import java.util.List;

class MernCourse extends Course{
    private int courseId = 3;

    private String courseName;

    private List<Task> mernTasks = new ArrayList<Task>();
    MernCourse(String courseName){
        super(courseName);
    }

    // getters and setters
    public String getCourseName(){
        return courseName;
    }

    public List<Task> getMernTasks(){
        return mernTasks;
    }
    public void addMernTask(Task task){
        mernTasks.add(task);
    }
}