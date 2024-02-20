package FileHandler;

// imports
import java.util.ArrayList;
import java.util.List;
/**
 * Main class containing driver code
 */
public class Main {
    public static void main(String[] args){
        List<Student> students = new ArrayList(); // generic arraylist to store student instances

        // file name where we serialize
        String fileName = "serialized.txt";

        // create two objects of student class
        Student student1 = new Student("atul", 22, 2);
        Student student2 = new Student("test", 35, 1);

        // add student objects to list 
        students.add(student1);
        students.add(student2);

        
        // Serialize the list of students(object)
        FileSerializer serializer = new FileSerializer();
        serializer.serialize(fileName, students);

        // deserialize file and get the list(object)
        FileDeserializer deserializer = new FileDeserializer();
        deserializer.deserialize(fileName);

        // method to sort deserialized object and again serializing it
        List<Student> sortedStudents = deserializer.sortObject();
        serializer.serialize(fileName, sortedStudents);
    }
}  
