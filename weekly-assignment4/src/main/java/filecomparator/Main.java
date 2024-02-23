package filecomparator;

//imports
import java.util.List;

/**
 * Main class containing the driver code
 */
public class Main {
    public static void main(String[] args) {
        //declaring the filepaths
        String txtPath1 = "/home/himanshu/Desktop/Avisoft/java/weekly-assignment4/src/main/java/filecomparator/file1.txt";
        String txtPath2 = "/home/himanshu/Desktop/Avisoft/java/weekly-assignment4/src/main/java/filecomparator/file2.txt";

        //make file reader class that returns the file in list of list
        FileImporter reader = new FileImporter();
        List<String[]> fileList1 = reader.readFile(txtPath1);
        List<String[]> fileList2 = reader.readFile(txtPath2);
    
    
        //make file comparator class and call compare function to compare txt files
        FileComparator comparator = new FileComparator();
        comparator.compareTxt(fileList1, fileList2);

        //compare xml files 
        String xmlPath1 = "/home/himanshu/Desktop/Avisoft/java/weekly-assignment4/src/main/java/filecomparator/xmlFile1.xml";
        String xmlPath2 = "/home/himanshu/Desktop/Avisoft/java/weekly-assignment4/src/main/java/filecomparator/xmlFile1.xml";
        comparator.compareXml(xmlPath1, xmlPath2);

    }
}


