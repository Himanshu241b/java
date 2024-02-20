package FileHandler;

// imports
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileDeserializer implements Serializable {

    
    List<Student> deserializedList;
    
    /**
     * method to deserialize the file content and add it to list of students
     * @param fileName
     */
    public void deserialize(String fileName) {
// Deserialize the list (just for demonstration)
try {
    // Create a FileInputStream to read the file
    FileInputStream fileInputStream = new FileInputStream(fileName);

    // Create an ObjectInputStream
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

    // Read the object from the ObjectInputStream
    deserializedList = (List<Student>) objectInputStream.readObject();
    System.out.println("File has been deserialized");
    // Close the ObjectInputStream
    objectInputStream.close();

    // Print the deserialized list (just for demonstration)
    System.out.println("Deserialized List:");
    for (Student student : deserializedList) {
        System.out.println("Student roll: "+student.getRollNo());
        System.out.println("Student age: "+student.getAge());
        System.out.println("Student name: "+ student.getName());;
    }
} catch (IOException | ClassNotFoundException e) {
    e.printStackTrace();
}
    }

    /**
     * method to return sorted deserialized list
     * @return sortedList of  students
     */
    public List<Student> sortObject(){

        Collections.sort(deserializedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getRollNo(), s2.getRollNo());
            }
        });
        return deserializedList;
    }

}
