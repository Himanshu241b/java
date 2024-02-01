import java.util.*;
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
        for(int i = 0; i < n; i++){
            System.out.println("Enter name of student "+(i+1));
            String name = sc.next();
            System.out.println("Enter roll no. of student "+(i+1));
            int roll = sc.nextInt();
            System.out.println("Enter java marks of student "+(i+1));
            int javaMarks = sc.nextInt();
            System.out.println("Enter cpp marks of student "+(i+1));
            int cppMarks = sc.nextInt(); 
            System.out.println("Enter python marks of student"+(i+1));
            int pythonMarks = sc.nextInt();
            students[i] = new Student(name, roll, javaMarks, cppMarks, pythonMarks);
        }
        ArrayList<Integer> aboveThresholdList = aboveThreshold(students);
        ArrayList<Integer> belowThresholdList = belowThreshold(students);
        ArrayList<Integer> middleThresholdList = middleThreshold(students);
        ArrayList<Integer> failingList = failing(students);
        ArrayList<Integer> specialAttentionList = specialAttention(belowThresholdList,failingList);
        int[] topperList = topper(students);
        System.out.println("To see first 5 toppers: press 1\n To see above threshold students: press 2\n To see below threshold students: press 3\n To see the middle students: press 4\n To see the failing : press 5 ");
        int choice  = sc.nextInt();
        switch (choice) {
            case 1:
                    System.out.println("First 5 toppers: \n");
                    for(int i = 4; i >= 0; i--) {
                        System.out.println("Student name: " + students[topperList[i]].name);
                        System.out.println("---------------------------------------------------------");
                    }
                    break;
                case 2:
                    System.out.println("Above threshold students: \n");
                    for(int i = 0; i < aboveThresholdList.size(); i++) {
                        System.out.println("Student name: " + students[aboveThresholdList.get(i)].name);
                        System.out.println("-------------------------------belowThresholdList.get(i)-------------");
                    }
                    break;
                case 3:
                    System.out.println("below threshold students: \n");
                    for(int i = 0; i < belowThresholdList.size(); i++) {
                        System.out.println("Student name: " + students[belowThresholdList.get(i)].name);
                        System.out.println("---------------------------------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("Middle students list: \n");
                    for(int i = 0; i < middleThresholdList.size(); i++) {
                        System.out.println("Student name: " + students[middleThresholdList.get(i)].name);
                        System.out.println("---------------------------------------------------------");
                    }
                    break;
                case 5:
                    System.out.println("failing students:\n");
                    for(int i = 0; i < failingList.size(); i++) {
                        System.out.println("Student name: " + students[failingList.get(i)].name);
                        System.out.println("---------------------------------------------------------");
                    }
                    break;
                    default:
                    System.out.println("choice not available : Terminating ...");
                    
        }
             
     }
    //method to calculate above threshold students
    public static ArrayList aboveThreshold(Student[] students) {
        ArrayList<Integer> aboveThresholdList = new ArrayList<Integer>();
        for(int i = 0; i < students.length; i++)
            if(((students[i].cppMarks + students[i].javaMarks + students[i].pythonMarks) / totalSubjects) >= maxThreshold)
                aboveThresholdList.add(i);
        
        return aboveThresholdList;
    }
        //method to calculate below threshold students
        public static ArrayList belowThreshold(Student[] students) {
            ArrayList<Integer> belowThresholdList = new ArrayList<Integer>();
            for(int i = 0; i < students.length; i++)
                if(((students[i].cppMarks + students[i].javaMarks + students[i].pythonMarks) / totalSubjects) <= minThreshold)
                    belowThresholdList.add(i);
            
            return belowThresholdList;
        }
//method to calculate middle threshold students
public static ArrayList middleThreshold(Student[] students) {
    ArrayList<Integer> middleThresholdList = new ArrayList<Integer>();
    for(int i = 0; i < students.length; i++)
        if(((students[i].cppMarks + students[i].javaMarks + students[i].pythonMarks) / totalSubjects) < maxThreshold
        && ((students[i].cppMarks + students[i].javaMarks + students[i].pythonMarks) / totalSubjects) > minThreshold)
            middleThresholdList.add(i);
    
    return middleThresholdList;
}
//method to get the failing students
public static ArrayList failing(Student[] students) {
    ArrayList<Integer> failingList = new ArrayList<Integer>();
    for(int i = 0; i < students.length; i++)
        if(students[i].javaMarks <failMarks || students[i].cppMarks <failMarks || students[i].pythonMarks <failMarks )
            failingList.add(i);
    
    return failingList;
}
//method to get list of students who need special attention
public static ArrayList specialAttention(ArrayList belowThresholdList,ArrayList failingList) {
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
public static int[] topper(Student[] students) {
    int[] sortedByAverage = new int[students.length];
    for(int i = 0; i < students.length;++i){
        sortedByAverage[i] = (students[i].javaMarks+students[i].cppMarks+students[i].pythonMarks) / totalSubjects; 
    }
    Arrays.sort(sortedByAverage);
    
    return sortedByAverage;
}
}
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