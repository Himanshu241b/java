package filecomparator;

//imports
import java.util.List;

/**
 * Class to compare two files 
 */
public class FileComparator {

    /**
     * Method to compare two files
     * @param fileList1 word list from file 1
     * @param fileList2 word list from file 2
     */
    public void compare(List<String[]> fileList1, List<String[]> fileList2) {    

        int maxLength = Math.max(fileList1.size(), fileList2.size());

        for (int i = 0; i < maxLength; i++) {

            String [] file1Line = fileList1.get(i);
            String [] file2Line = fileList2.get(i);
            if (!file1Line.equals(file2Line)) {
                System.out.println("Difference found in line " + (i + 1) + ":");

                // Print words difference
                for (int j = 0; j < Math.max(file1Line.length, file2Line.length); j++) {
                    if (j < file1Line.length && j < file2Line.length) {
                        if (!file1Line[j].equals(file2Line[j])) {
                            System.out.println("File 1: " + file1Line[j]);
                            System.out.println("File 2: " + file2Line[j]);
                        }
                    } else if (j < file1Line.length) {
                        System.out.println("Extra word in File 1: " + file1Line[j]);
                    } else {
                        System.out.println("Extra word in File 2: " + file2Line[j]);
                    }
                }
            }
        }
   
    }
}
