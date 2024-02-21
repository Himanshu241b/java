package FileHandler;

// imports
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *  Class representing the serializer that serializes the objects
 */
public class FileSerializer{

    
    /**
     * method to serialize the object and write to file
     * @param fileName
     * @param students
     */
    public void serialize(String fileName, List<Student> students) {
        try {
            // Create a FileOutputStream to append to the file
            FileOutputStream fileOutputStream = new FileOutputStream(fileName); // true for append mode
            // Create an ObjectOutputStream
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Write the list object to the ObjectOutputStream
            objectOutputStream.writeObject(students);
            System.out.println("Object serialized successfully");

            // Close the ObjectOutputStream
            objectOutputStream.close();

            System.out.println("List serialized and appended to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
