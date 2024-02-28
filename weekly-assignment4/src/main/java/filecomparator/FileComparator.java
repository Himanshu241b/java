package filecomparator;

//imports
import java.time.DateTimeException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class to compare two files 
 */
public class FileComparator {

    /**
     * Method to compare two files
     * @param fileList1 word list from file 1
     * @param fileList2 word list from file 2
     */
    public void compareTxt(List<String[]> fileList1, List<String[]> fileList2) {
        // maxlength of number of sentences in files
        int maxLength = Math.max(fileList1.size(), fileList2.size());
        //iterate over sentences
        for (int sentence = 0; sentence < maxLength; sentence++) {
            String[] file1Sentence = sentence < fileList1.size() ? fileList1.get(sentence) : new String[0];
            String[] file2Sentence = sentence < fileList2.size() ? fileList2.get(sentence) : new String[0];

            //check if sentence are equal from both files
            if (!areSentencesEqual(file1Sentence, file2Sentence)) {
                // if they are not equal print difference between words in the senetence
                System.out.println("Difference found in sentence " + (sentence + 1) + ":");
                compareWordsInSentences(file1Sentence, file2Sentence);
            }
        }
    }

    /**
     * checks if the sentences are equal or not
     * @param sentenceOfActualFile sentence of file1
     * @param sentenceOfExpectedFile sentence of file2
     * @return boolean if the sentences are equal or not
     */
    private boolean areSentencesEqual(String[] sentenceOfActualFile, String[] sentenceOfExpectedFile) {
        //if length of sentenceOfActualFile dont match length of sentenceOfExpectedFile they are unequal
        if (sentenceOfActualFile.length != sentenceOfExpectedFile.length) {
            return false;
        }
        // compare the sentences
        for (int i = 0; i < sentenceOfActualFile.length; i++) {
            if (!sentenceOfActualFile[i].equals(sentenceOfExpectedFile[i])) {
                return false;
            }
        }
        // when they are equal return true
        return true;
    }

    /**
     * method compares words in sentence
     * @param santenceOfActualFile sentence of file1
     * @param sentenceOfExpectedFile sentence of file2
     */
    private void compareWordsInSentences(String[] santenceOfActualFile, String[] sentenceOfExpectedFile) {
        int maxLength = Math.max(santenceOfActualFile.length, sentenceOfExpectedFile.length);
        //word by word comparison of santenceOfActualFile and sentenceOfExpectedFile
        for (int word = 0; word < maxLength; word++) {
            if (word < santenceOfActualFile.length && word < sentenceOfExpectedFile.length) {
                if (!santenceOfActualFile[word].equals(sentenceOfExpectedFile[word])) {
                    System.out.println("Word " + (word + 1) + ":");
                    System.out.println("File 1: " + santenceOfActualFile[word]);
                    System.out.println("File 2: " + sentenceOfExpectedFile[word]);
                }
            } else if (word < santenceOfActualFile.length) {
                //prints extra words in santenceOfActualFile
                System.out.println("Extra word in File 1: " + santenceOfActualFile[word]);
            } else {
                //print extra words in sentenceOfExpectedFile
                System.out.println("Extra word in File 2: " + sentenceOfExpectedFile[word]);
            }
        }
    }

    /**
     * method to compareCsv files to check if they are same or not
     * @param csvList1 list of all fields in csv file in every row
     * @param csvList2  list of all fields in csv file in every row
     * @return boolean value if files are equal or not
     */
    public boolean compareCsv(List<String[]> csvList1, List<String[]> csvList2, String[] ignoreColumns) {
        //if lines length don't match return false
        if (csvList1.size() != csvList2.size()) {
            return false;
        }

        // Compare each line in both files
        for (int row = 0; row < csvList1.size(); row++) {
            String[] lineOfActualFile = csvList1.get(row);
            String[] lineOfExpectedFile = csvList2.get(row);

            // number of fields must be equal in both files
            if (lineOfActualFile.length != lineOfExpectedFile.length) {
                return false;
            }

            // comparing the fields per line, excluding ignored columns
            for (int field = 0; field < lineOfActualFile.length; field++) {
                // Check if the current field should be ignored
                boolean ignoreField = false;
                for (String ignoreColumn : ignoreColumns) {
                    if (ignoreColumn.equals(csvList1.get(0)[field])) {
                        ignoreField = true;
                        break;
                    }
                }

                // If the field is ignored, skip the comparison
                if (ignoreField) {
                    continue;
                }

                if (!lineOfActualFile[field].equals(lineOfExpectedFile[field])) {
                    return false;
                }
            }
        }
        // when all lines and fields are equal
        return true;
    }


    /**
     * method to create a csv output file of differences
     * @param csvList1 the list of fields in first csv file
     * @param csvList2 the list of fields in second csv file
     */
    public void createCsvOutputFile(List<String[]> csvList1, List<String[]> csvList2, String[] ignoreColumns) {
        try {
            // formatter to format datetime format
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            // generates datetime from local machine
            LocalDateTime now = LocalDateTime.now();
            // make a filename to store output
            String filename = "/home/himanshu/Desktop/Avisoft/java/weekly-assignment4/src/main/java/filecomparator/ResultCSV" + dtf.format(now) + ".csv";

            // make a file and append first row to it
            try (FileWriter writer = new FileWriter(filename)) {
                writer.append("RowNo.ColumnNo.:Column_name,Actual,Expected\n");

                // row by row and field by field compare values and append differences in file
                for (int row = 0; row < csvList1.size(); row++) {
                    String[] lineOfActualFile = csvList1.get(row);
                    String[] lineOfExpectedFile = csvList2.get(row);

                    for (int field = 0; field < Math.min(lineOfActualFile.length, lineOfExpectedFile.length); field++) {
                        // Check if the current column should be ignored
                        boolean ignoreColumn = false;
                        for (String ignore : ignoreColumns) {
                            if (field < csvList1.get(0).length && ignore.equals(csvList1.get(0)[field])) {
                                ignoreColumn = true;
                                break;
                            }
                        }

                        // If the column is ignored, skip writing it to the output file
                        if (ignoreColumn) {
                            continue;
                        }

                        if (!lineOfActualFile[field].equals(lineOfExpectedFile[field])) {
                            writer.append("RowNo." + (row + 1) + "ColumnNo." + (field + 1) + "_" + csvList2.get(0)[field] + ",");
                            writer.append(lineOfActualFile[field] + ",");
                            writer.append(lineOfExpectedFile[field] + "\n");
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Differences written to file: " + filename);
        } catch (DateTimeException e) {
            e.printStackTrace();
        }
    }


    public void compareXml(String xmlPath1, String xmlPath2) {
        try {
            // Parse the first XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file1 = new File(xmlPath1);
            if (!file1.exists() || !file1.isFile()) {
                System.err.println("File " + xmlPath1 + " does not exist or is not a regular file.");
                return;
            }
            System.out.println(file1.toString());
            Document doc1 = builder.parse(file1);
            System.out.println("**********" + doc1.toString());

            // Parse the second XML file
            File file2 = new File(xmlPath2);
            if (!file2.exists() || !file2.isFile()) {
                System.err.println("File " + xmlPath2 + " does not exist or is not a regular file.");
                return;
            }
            Document doc2 = builder.parse(file2);

            // Compare the documents
            compareNodes(doc1.getDocumentElement(), doc2.getDocumentElement());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    // Compare nodes recursively
    private static void compareNodes(Node node1, Node node2) {
        if (!node1.getNodeName().equals(node2.getNodeName())) {
            System.out.println("Different node name: " + node1.getNodeName() + " vs " + node2.getNodeName());
        }

        // Compare attributes
        if (!node1.getNodeValue().equals(node2.getNodeValue())) {
            System.out.println("Different node value: " + node1.getNodeValue() + " vs " + node2.getNodeValue());
        }

        // Compare child nodes
        NodeList children1 = node1.getChildNodes();
        NodeList children2 = node2.getChildNodes();

        for (int i = 0; i < children1.getLength(); i++) {
            Node child1 = children1.item(i);
            boolean found = false;
            for (int j = 0; j < children2.getLength(); j++) {
                Node child2 = children2.item(j);
                if (child1.getNodeType() == Node.ELEMENT_NODE && child2.getNodeType() == Node.ELEMENT_NODE &&
                        child1.getNodeName().equals(child2.getNodeName())) {
                    compareNodes(child1, child2); // Recursively compare child nodes
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Extra node in file1.xml: " + child1.getNodeName());
            }
        }

        for (int i = 0; i < children2.getLength(); i++) {
            Node child2 = children2.item(i);
            boolean found = false;
            for (int j = 0; j < children1.getLength(); j++) {
                Node child1 = children1.item(j);
                if (child2.getNodeType() == Node.ELEMENT_NODE && child1.getNodeType() == Node.ELEMENT_NODE &&
                        child2.getNodeName().equals(child1.getNodeName())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Extra node in file2.xml: " + child2.getNodeName());
            }
        }
    }
}
