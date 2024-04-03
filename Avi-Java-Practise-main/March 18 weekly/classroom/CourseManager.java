package classroom;

import java.util.List;

class CourseManager {
    public static void createCourse(List<Course> courseList, Course course) {
        for(Course listedCourses : courseList) {
            if(listedCourses.getCourseId() == course.getCourseId()) {
                System.out.println("Course already exists.");
                return;
            }
        }
        courseList.add(course);
        System.out.println("course added successfully");
    }

    public static void joinCourse(List<Course> courseList, User currentStudent, List<User> studentsList, Course course){
        boolean courseExists = false;
        for(Course listedCourse : courseList) {
            if (listedCourse.getCourseId() == course.getCourseId()) {
                courseExists = true;
                break;
            }
        }
        if(!courseExists){
            System.out.println("course doesn't exist.");
            return;
        }

                for(User student : studentsList){
                    if(student.getEmail().equals(currentStudent.getEmail())){
                        for(Course subscribedCourse : student.getSubscribedCoursesList()) {
                            if (subscribedCourse.getCourseId() == course.getCourseId()) {
                                System.out.println("Course already joined by you.");
                                return;
                            }
                        }
                                student.getSubscribedCoursesList().add(course);
                                System.out.println("Course joined successfully.");
                                return;


                    }
                }
                currentStudent.getSubscribedCoursesList().add(course);
                studentsList.add(currentStudent);
                System.out.println("Course joined successfully.");
    }
}