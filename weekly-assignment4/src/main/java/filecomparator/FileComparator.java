package filecomparator;

//imports
import java.io.FileNotFoundException;
import java.time.DateTimeException;
import java.util.List;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import org.w3c.dom.Document;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//import java.io.File;
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
     *
     * @param actualTxtFileList word list from file 1
     * @param expectedTxtFileList word list from file 2
     */
    public void compareTxt(List<String[]> actualTxtFileList, List<String[]> expectedTxtFileList) {
        try {
            // maxlength of number of sentences in files
            int maxLength = Math.max(actualTxtFileList.size(), expectedTxtFileList.size());
            //iterate over sentences
            for (int sentence = 0; sentence < maxLength; sentence++) {
                String[] file1Sentence = sentence < actualTxtFileList.size() ? actualTxtFileList.get(sentence) : new String[0];
                String[] file2Sentence = sentence < expectedTxtFileList.size() ? expectedTxtFileList.get(sentence) : new String[0];

                //check if sentence are equal from both files
                if (!areSentencesEqual(file1Sentence, file2Sentence)) {
                    // if they are not equal print difference between words in the senetence
                    System.out.println("Difference found in sentence " + (sentence + 1) + ":");
                    compareWordsInSentences(file1Sentence, file2Sentence);
                }
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            arrayIndexOutOfBoundsException.printStackTrace();
        }
    }

    /**
     * checks if the sentences are equal or not
     *
     * @param sentenceOfActualFile   sentence of file1
     * @param sentenceOfExpectedFile sentence of file2
     * @return boolean if the sentences are equal or not
     */
    private boolean areSentencesEqual(String[] sentenceOfActualFile, String[] sentenceOfExpectedFile) {

        //if length of sentenceOfActualFile dont match length of sentenceOfExpectedFile they are unequal
        if (sentenceOfActualFile.length != sentenceOfExpectedFile.length) {
            return false;
        }
        try {
            // compare the sentences
            for (int word = 0; word < sentenceOfActualFile.length; word++) {
                if (!sentenceOfActualFile[word].equals(sentenceOfExpectedFile[word])) {
                    return false;
                }
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            arrayIndexOutOfBoundsException.printStackTrace();
        }
        // when they are equal return true
        return true;

    }

    /**
     * method compares words in sentence
     *
     * @param sentenceOfActualFile   sentence of file1
     * @param sentenceOfExpectedFile sentence of file2
     */
    private void compareWordsInSentences(String[] sentenceOfActualFile, String[] sentenceOfExpectedFile) {
        try {
            int maxLength = Math.max(sentenceOfActualFile.length, sentenceOfExpectedFile.length);
            //word by word comparison of sentenceOfActualFile and sentenceOfExpectedFile
            for (int word = 0; word < maxLength; word++) {
                if (word < sentenceOfActualFile.length && word < sentenceOfExpectedFile.length) {
                    if (!sentenceOfActualFile[word].equals(sentenceOfExpectedFile[word])) {
                        System.out.println("Word " + (word + 1) + ":");
                        System.out.println("Actual File: " + sentenceOfActualFile[word]);
                        System.out.println("Expected File: " + sentenceOfExpectedFile[word]);
                    }
                } else if (word < sentenceOfActualFile.length) {
                    //prints extra words in sentenceOfActualFile
                    System.out.println("Extra word in Actual File: " + sentenceOfActualFile[word]);
                } else {
                    //print extra words in sentenceOfExpectedFile
                    System.out.println("Extra word in Expected File: " + sentenceOfExpectedFile[word]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            arrayIndexOutOfBoundsException.printStackTrace();
        }
    }

    /**
     * method to compareCsv files to check if they are same or not
     *
     * @param actualCsvFileList list of all fields in csv file in every row
     * @param expectedCsvFileList list of all fields in csv file in every row
     * @return boolean value if files are equal or not
     */
    public boolean compareCsv(List<String[]> actualCsvFileList, List<String[]> expectedCsvFileList, String[] ignoreColumns) {

        //if lines length don't match return false
        if (actualCsvFileList.size() != expectedCsvFileList.size()) {
            return false;
        }
        try {
            // Compare each line in both files
            for (int row = 0; row < actualCsvFileList.size(); row++) {
                String[] lineOfActualFile = actualCsvFileList.get(row);
                String[] lineOfExpectedFile = expectedCsvFileList.get(row);

                // number of fields must be equal in both files
                if (lineOfActualFile.length != lineOfExpectedFile.length) {
                    return false;
                }

                // comparing the fields per line, excluding ignored columns
                for (int field = 0; field < lineOfActualFile.length; field++) {
                    // Check if the current field should be ignored
                    boolean ignoreField = false;
                    for (String ignoreColumn : ignoreColumns) {
                        if (ignoreColumn.equals(actualCsvFileList.get(0)[field])) {
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
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            arrayIndexOutOfBoundsException.printStackTrace();
        }
        // when all lines and fields are equal
        return true;
    }


    /**
     * method to create a csv output file of differences
     *
     * @param csvList1 the list of fields in first csv file
     * @param csvList2 the list of fields in second csv file
     */
    public void createCsvOutputFile(List<String[]> csvList1, List<String[]> csvList2, String[] ignoreColumns) {
        try {
            // formatter to format datetime format
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            // generates datetime from local machine
            LocalDateTime now = LocalDateTime.now();
            // make a filename to store output
            String filename = "/home/himanshu/Desktop/Avisoft/java/weekly-assignment4/src/main/java/OutputFiles/ResultCSV" + dateTimeFormatter.format(now) + ".csv";

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
                            if (field < csvList1.get(0).length && ignore.equalsIgnoreCase(csvList1.get(0)[field])) {
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
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

            System.out.println("Differences written to file: " + filename);
        } catch (DateTimeException dateTimeException) {
            dateTimeException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    }

//    /**
//     * method to compare two xml files
//     * @param actualXmlPath path of the actual xml file
//     * @param expectedXmlPath   path of the expected xml file
//     */
//    public void compareXml(String actualXmlPath, String expectedXmlPath) throws XmlFileDontExistException{
//        try {
//            // Parse the first XML file
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            File actualXmlFile = new File(actualXmlPath);
//            if (!actualXmlFile.exists() || !actualXmlFile.isFile()) {
//                throw new XmlFileDontExistException("File " + actualXmlPath + " does not exist.");
//            }
//            System.out.println(actualXmlFile.toString());
//            Document actualXmlDocument = builder.parse(actualXmlFile);
//            System.out.println("**********" + actualXmlDocument.toString());
//
//            // Parse the second XML file
//            File expectedXmlFile = new File(expectedXmlPath);
//            if (!expectedXmlFile.exists() || !expectedXmlFile.isFile()) {
//                throw new XmlFileDontExistException("File " + actualXmlPath + " does not exist.");
//            }
//            Document expectedXmlDocument = builder.parse(expectedXmlFile);
//
//            // Compare the documents
//            compareNodes(actualXmlDocument.getDocumentElement(), expectedXmlDocument.getDocumentElement());
//
//        } catch (ParserConfigurationException | SAXException | IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    /**
//     *  method that compares the nodes recursively
//     * @param actualXmlNode Node of actual xml file to compare against node of expected xml file
//     * @param expectedXmlNode Node of expected xml file to compare against node of actual xml file
//     */
//    private static void compareNodes(Node actualXmlNode, Node expectedXmlNode) {
//        try {
//            if (!actualXmlNode.getNodeName().equals(expectedXmlNode.getNodeName())) {
//                System.out.println("Different node name: " + actualXmlNode.getNodeName() + " vs " + expectedXmlNode.getNodeName());
//            }
//
//            // Compare attributes
//            if (!actualXmlNode.getNodeValue().equals(expectedXmlNode.getNodeValue())) {
//                System.out.println("Different node value: " + actualXmlNode.getNodeValue() + " vs " + expectedXmlNode.getNodeValue());
//            }
//        }
//        catch(NullPointerException nullPointerException){
//            nullPointerException.printStackTrace();
//        }
//
//        // Compare child nodes
//        NodeList childrenOfActualXmlNode = actualXmlNode.getChildNodes();
//        NodeList childrenOfExpectedXmlNode = expectedXmlNode.getChildNodes();
//
//        for (int childOfActualXmlNodeIterator = 0; childOfActualXmlNodeIterator < childrenOfActualXmlNode.getLength(); childOfActualXmlNodeIterator++) {
//            Node childNodeOfActualXmlNode = childrenOfActualXmlNode.item(childOfActualXmlNodeIterator);
//            boolean found = false;
//            for (int childOfExpectedXmlNodeIterator = 0; childOfExpectedXmlNodeIterator < childrenOfExpectedXmlNode.getLength(); childOfExpectedXmlNodeIterator++) {
//                Node childNodeOfExpectedXmlNode = childrenOfExpectedXmlNode.item(childOfExpectedXmlNodeIterator);
//                if (childNodeOfActualXmlNode.getNodeType() == Node.ELEMENT_NODE && childNodeOfExpectedXmlNode.getNodeType() == Node.ELEMENT_NODE &&
//                        childNodeOfActualXmlNode.getNodeName().equals(childNodeOfExpectedXmlNode.getNodeName())) {
//                    compareNodes(childNodeOfActualXmlNode, childNodeOfExpectedXmlNode); // Recursively compare child nodes
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                System.out.println("Extra node in file1.xml: " + childNodeOfActualXmlNode.getNodeName());
//            }
//        }
//
//        for (int i = 0; i < childrenOfExpectedXmlNode.getLength(); i++) {
//            Node child2 = childrenOfExpectedXmlNode.item(i);
//            boolean found = false;
//            for (int j = 0; j < childrenOfActualXmlNode.getLength(); j++) {
//                Node child1 = childrenOfActualXmlNode.item(j);
//                if (child2.getNodeType() == Node.ELEMENT_NODE && child1.getNodeType() == Node.ELEMENT_NODE &&
//                        child2.getNodeName().equals(child1.getNodeName())) {
//                    found = true;
//                    break;
//                }
//            }
//            if (!found) {
//                System.out.println("Extra node in file2.xml: " + child2.getNodeName());
//            }
//        }
//    }
//}
//
