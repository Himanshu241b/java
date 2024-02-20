package FileHandler;
import java.io.Serializable;

/**
 * This class represents a student record
 */
public class Student implements Serializable{
    private String name;
    private int age;
    private int rollNo;

    /**
     * Constructs a new Student object with the given name and age.
     * @param name The name of the student.
     * @param age The age of the student.
     * @param rollNo The roll of the student
     */
    public Student(String name, int age, int rollNo) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
    }

    /**
     * Gets the name of the student.
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student.
     * @param name The name of the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the age of the student.
     * @return The age of the student.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the student.
     * @param age The age of the student.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *  Gets the roll number of the student.
     * @return The roll number of the student
     */
    public int getRollNo(){
        return rollNo;
    }

    /**
     * Sets the rollNo of student
     * @param rollNo The roll no of student
     */
    public void setRollNo(int roll){
        rollNo = roll;
    }

}

