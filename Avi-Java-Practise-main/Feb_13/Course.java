package Feb_13;

public class Course {
      private int courseCode;
      private String courseName;
      private int credits;

      public Course(int courseCode, String courseName, int credits)
      {
          this.courseCode = courseCode;
          this.courseName = courseName;
          this.credits = credits;
      }

      //getters
      public int getCourseCode()
      {
          return courseCode;
      }
    public int getCredits()
    {
        return credits;
    }
    public String getCourseName()
    {
        return courseName;
    }
}
