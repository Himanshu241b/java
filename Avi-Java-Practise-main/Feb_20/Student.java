package Feb_20;
import java.io.FileInputStream;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.*;
import java.util.*;

class Student implements Serializable{
    private String name;
    private int id;
    private double grade;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and setters
    // Note: For brevity, I'm omitting the setters in this example.
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

}


class Main {
    public static final String FILE_NAME = "studentsRecord.dat";

    public static void serialize(List<Student> students) throws IOException
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME)))
        {
            oos.writeObject(students);
            System.out.println("Serialization of students done successfully");
        }
        catch(IOException e){
            System.err.println("Error serilizing students! " + e.getMessage());
        }
    }
    public static List<Student> deserialize() throws IOException, ClassNotFoundException
    {
        List<Student> students = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)))
        {
            students = (List<Student>) ois.readObject();
            System.out.println("Students deserialized successfully!");
        }
        catch(Exception e)
        {
            System.out.println("Error deserializing students " + e.getMessage());
        }
        return students;
    }

    public static void addStudent(Student student) throws IOException, ClassNotFoundException
    {
        List<Student> students = deserialize();
        students.add(student);
        serialize(students);
    }

    public static Student searchByID(int ID) throws IOException, ClassNotFoundException
    {
        List<Student> students = deserialize();
        for(Student st: students)
        {
            if(st.getId() == ID)
            {
                return st;
            }
        }
        return null;
    }

    public static void printStudents() throws IOException, ClassNotFoundException
    {
        List<Student> students = deserialize();
        for(Student st: students)
        {
            System.out.println(st.getName() + " - Grades: " + st.getGrade() + ", ID: " + st.getId());
        }
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tarun", 1, 85.5));
        students.add(new Student("Aliza", 2, 90.0));
        students.add(new Student("Nancy", 3, 75.25));

        serialize(students);

        addStudent(new Student("Rahul", 4, 98.9));

        printStudents();



    }
}

