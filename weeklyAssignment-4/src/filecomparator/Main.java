package filecomparator;

//imports
import java.util.List;

/**
 * Main class containing the driver code
 */
public class Main {
    public static void main(String[] args) {
        //declaring the filepaths
        String file1Path = "/home/himanshu/Desktop/Avisoft/java/weeklyAssignment-4/src/filecomparator/file1.txt";
        String file2Path = "/home/himanshu/Desktop/Avisoft/java/weeklyAssignment-4/src/filecomparator/file2.txt";

        //make file reader class that returns the file in list of list
        FileImporter reader = new FileImporter();
        List<String[]> fileList1 = reader.readFile(file1Path);
        List<String[]> fileList2 = reader.readFile(file2Path);
    
    
        //make file comparator class and call compare function to compare
        FileComparator comparator = new FileComparator();
        comparator.compare(fileList1, fileList2);

    }
}


