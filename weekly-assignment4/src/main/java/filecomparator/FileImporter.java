package filecomparator;

// imports
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    public List<String[]> readTxt(String filePath) {
        // 2d list to return words in each sentence
        List<String[]> sentenceList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read lines from the file until the end is reached
            while ((line = reader.readLine()) != null) {
                // Split the line into sentences based on ". "
                String[] sentences = line.split("\\.\\s+");

                // Process each sentence
                for (String sentence : sentences) {
                    // Split the sentence into words based on whitespace
                    String[] words = sentence.split("\\s+");
                    sentenceList.add(words);
                }
            }
        }catch (FileNotFoundException e) {
            // Handle file not found exception
            e.printStackTrace();
        } catch (IOException e) {
            // Handle other IO exceptions
            e.printStackTrace();
        }
        // return the result list
        return sentenceList;
    }

    /**
     * method to read a csv input file and create a List of string array of field values of csv file
     * @param path path of the csv file
     * @return List of field values
     */
    public List<String[]> readCsv(String path){
        List<String[]> dataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Split by comma
                dataList.add(parts);
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            e.printStackTrace();
        } catch (IOException e) {
            // Handle other IO exceptions
            e.printStackTrace();
        }

        return dataList;
    }
}


     
