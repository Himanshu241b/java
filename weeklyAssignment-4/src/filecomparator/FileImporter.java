package filecomparator;

// imports
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

/**
 * class to read a file and return a list of list words per line
 *  */ 
class FileImporter{

    /**
     * read a file and add words to a list of list line by line and return it
     * @param filePath the path to the file
     */
    public List<String[]> readFile(String filePath){
        // 2d list to return words in each line
        List<String[]> fileList = new ArrayList<String[]>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            // Read lines from the file until the end is reached
            while ((line = reader.readLine()) != null) {
                // Split the line into words based on whitespace
                String[] words = line.split("\\s+");

                fileList.add(words);
                }
                // Close the reader to free resources
            reader.close();
            }
            catch(IOException e){
            e.printStackTrace();
            }
            // return the result list
            return fileList;
        }
}


     
