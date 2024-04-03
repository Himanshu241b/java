package Feb_13;

public class Main {
    public static void main(String[] args) {

        University university = new University();

        //adding courses
        Course MCA = new Course(1, "MCA", 100);
        Course MBA = new Course(2, "MBA", 150);
        Course btech = new Course(3, "btech", 150);

        university.addCourse(MCA);
        university.addCourse(MBA);
        university.addCourse(btech);

        //adding students
        Student student1 = new Student("Tarun", 23);
        Student student2 = new Student("Aliza", 24);
        Student student3 = new Student("Rahul", 21);
        Student student4 = new Student("Nancy", 23);
        Student student5 = new Student("Aryan", 20);

        student1.enrollCourse(MCA);
        student1.enrollCourse(MBA);
        student1.enrollCourse(btech);
        student1.enrollCourse(MCA);
        student1.enrollCourse(MBA);

        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);
        university.addStudent(student4);
        university.addStudent(student5);

        //adding faculty
        Faculty f1 = new Faculty("Dr. Sumit Sharma", 42, "Computer Science");
        Faculty f2 = new Faculty("Dr. Sumit Sharma", 42, "Computer Applications");

        f1.teachCourse(btech);
        f2.teachCourse(MCA);

        university.addFaculty(f1);
        university.addFaculty(f2);

        //displayiing all details of university
        university.allDetails();

    }
}
