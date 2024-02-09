import java.util.*;

// student blueprint
class Student{
    String name;
    int roll;
    int javaMarks;
    int cppMarks;
    int pythonMarks;
    Student(String name,  int roll, int javaMarks, int cppMarks, int pythonMarks){
        this.name = name;
        this.roll = roll;
        this.javaMarks = javaMarks;
        this.cppMarks = cppMarks;
        this.pythonMarks = pythonMarks;
    }
}

//Main  logic class
class studentrecord {
    static int maxThreshold = 80;
    static int minThreshold = 40;
    static int failMarks = 33;
    static int totalSubjects = 3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        Student[] students = new Student[n];
        try {
            System.out.println("Enter the upper threshold value");
            maxThreshold = sc.nextInt();
            System.out.println("Enter the lower threshold value");
            minThreshold = sc.nextInt();
            if (maxThreshold <= minThreshold) {
                throw new IllegalArgumentException("Upper threshold must be greater than lower threshold.");
            }

           
            System.out.println("Enter the failing marks");
            failMarks = sc.nextInt();
            if (failMarks < 0 || failMarks > 100) {
                throw new IllegalArgumentException("Failing marks should be between 0 and 100.");
            }

            
            for (int i = 0; i < n; i++) {
                System.out.println("Enter name of student " + (i + 1));
                String name = sc.next();
                System.out.println("Enter roll no. of student " + (i + 1));
                int roll = sc.nextInt();
                int javaMarks, cppMarks, pythonMarks;

                // Input validation for student marks
                do {
                    try {
                        System.out.println("Enter java marks of student " + (i + 1));
                        javaMarks = sc.nextInt();
                        System.out.println("Enter cpp marks of student " + (i + 1));
                        cppMarks = sc.nextInt();
                        System.out.println("Enter python marks of student " + (i + 1));
                        pythonMarks = sc.nextInt();

                        if (javaMarks < 0 || javaMarks > 100 || cppMarks < 0 || cppMarks > 100 || pythonMarks < 0 || pythonMarks > 100) 
                            throw new IllegalArgumentException("Marks should be between 0 and 100.");
                        else 
                            break;
                        
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer value.");
                        sc.nextLine(); // Clear the scanner buffer
                    }
                } while (true);

                students[i] = new Student(name, roll, javaMarks, cppMarks, pythonMarks);
            }

            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer value.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        ArrayList<Integer> aboveThresholdList = aboveThreshold(students);
        ArrayList<Integer> belowThresholdList = belowThreshold(students);
        ArrayList<Integer> middleThresholdList = middleThreshold(students);
        ArrayList<Integer> failingList = failing(students);
        ArrayList<Integer> specialAttentionList = specialAttention(belowThresholdList,failingList);
        ArrayList<Integer> topperList = topper(students);

        
        char choice='0';
        do {
            System.out.println("To see first 5 toppers: press 1\nTo see above threshold students: press 2\nTo see below threshold students: press 3\nTo see the middle students: press 4\nTo see the failing: press 5\nTo Terminate: press 0");
            choice = sc.next().charAt(0);

            switch (choice) {
                case '0':
                    System.out.println("Terminated");
                    return; // exit the program
                case '1':
                    System.out.println("First 5 toppers: \n");
                    System.out.println("---------------------------------------------------------");
                    for (int i = 4; i >= 0; i--) {
                        System.out.println("Student name: " + students[topperList.get(i)].name);
                    }
                    System.out.println("---------------------------------------------------------");

                    break;
                case '2':
                    System.out.println("Above threshold students: \n");
                    System.out.println("---------------------------------------------------------");

                    for (int i = 0; i < aboveThresholdList.size(); i++) {
                        System.out.println("Student name: " + students[aboveThresholdList.get(i)].name);
                    }
                    System.out.println("---------------------------------------------------------");

                    break;
                case '3':
                    System.out.println("Below threshold students: \n");
                    System.out.println("---------------------------------------------------------");

                    for (int i = 0; i < belowThresholdList.size(); i++) {
                        System.out.println("Student name: " + students[belowThresholdList.get(i)].name);
                    }
                    System.out.println("---------------------------------------------------------");

                    break;
                case '4':
                    System.out.println("Middle students list: \n");
                    System.out.println("---------------------------------------------------------");
                    for (int i = 0; i < middleThresholdList.size(); i++) {
                        System.out.println("Student name: " + students[middleThresholdList.get(i)].name);
                    }
                    System.out.println("---------------------------------------------------------");

                    break;
                case '5':
                    System.out.println("Failing students:\n");
                    System.out.println("---------------------------------------------------------");
                    for (int i = 0; i < failingList.size(); i++) {
                        System.out.println("Student name: " + students[failingList.get(i)].name);
                    }
                    System.out.println("---------------------------------------------------------");

                    break;
                default:
                    System.out.println("Enter a valid choice");
                    System.out.println("****************************************");
            }
        } while (true);
             
     }
    //method to calculate above threshold students
    public static ArrayList<Integer> aboveThreshold(Student[] students) {
        ArrayList<Integer> aboveThresholdList = new ArrayList<Integer>();
        for(int i = 0; i < students.length; i++)
            if(((students[i].cppMarks + students[i].javaMarks + students[i].pythonMarks) / totalSubjects) >= maxThreshold)
                aboveThresholdList.add(i);
        
        return aboveThresholdList;
    }
        //method to calculate below threshold students
        public static ArrayList<Integer> belowThreshold(Student[] students) {
            ArrayList<Integer> belowThresholdList = new ArrayList<Integer>();
            for(int i = 0; i < students.length; i++)
                if(((students[i].cppMarks + students[i].javaMarks + students[i].pythonMarks) / totalSubjects) <= minThreshold)
                    belowThresholdList.add(i);
            
            return belowThresholdList;
        }
//method to calculate middle threshold students
public static ArrayList<Integer> middleThreshold(Student[] students) {
    ArrayList<Integer> middleThresholdList = new ArrayList<Integer>();
    for(int i = 0; i < students.length; i++)
        if(((students[i].cppMarks + students[i].javaMarks + students[i].pythonMarks) / totalSubjects) < maxThreshold
        && ((students[i].cppMarks + students[i].javaMarks + students[i].pythonMarks) / totalSubjects) > minThreshold)
            middleThresholdList.add(i);
    
    return middleThresholdList;
}
//method to get the failing students
public static ArrayList<Integer> failing(Student[] students) {
    ArrayList<Integer> failingList = new ArrayList<Integer>();
    for(int i = 0; i < students.length; i++)
        if(students[i].javaMarks <failMarks || students[i].cppMarks <failMarks || students[i].pythonMarks <failMarks )
            failingList.add(i);
    
    return failingList;
}
//method to get list of students who need special attention
public static ArrayList<Integer> specialAttention(ArrayList belowThresholdList,ArrayList failingList) {
    ArrayList<Integer> specialAttentionList = new ArrayList<Integer>();
    for(int i = 0; i < belowThresholdList.size();++i){
        specialAttentionList.add((Integer) belowThresholdList.get(i)); // add below threshold students index
    }
    for(int i = 0; i < failingList.size();++i){
        specialAttentionList.add((Integer)failingList.get(i));  // add failed students index
    }
    
    return specialAttentionList;
}
// method to find list of toppers
public static ArrayList<Integer> topper(Student[] students) {
    ArrayList<Integer> top5List = new ArrayList<>();
    
    Arrays.sort(students, new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            double avg1 = (s1.cppMarks + s1.javaMarks + s1.pythonMarks) / 3.0;
            double avg2 = (s2.cppMarks + s2.javaMarks + s2.pythonMarks) / 3.0;
            // Sorting in descending order
            return Double.compare(avg2, avg1);
        }
    });

    // Adding the indices of top 5 students to the list
    for (int i = 0; i < Math.min(5, students.length); i++) {
        top5List.add(i);
    }

    return top5List;
}

}
