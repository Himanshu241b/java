package filecomparator;

//imports
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
    public void compareXml(String xmlPath1, String xmlPath2) {
        try {
            // Parse the first XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc1 = builder.parse(new File(xmlPath1));
            System.out.println("**********"+doc1.toString());
            // Parse the second XML file
            Document doc2 = builder.parse(new File(xmlPath2));

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
