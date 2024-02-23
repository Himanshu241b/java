import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
class Person {
    private String name;
    private int age;
    private String cls;

    // Getters and setters (or you can use lombok annotations for brevity)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    // Optional: Override toString() method for printing
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cls='" + cls + '\'' +
                '}';
    }
}

class ShowXml
{
    int c=0;
    void show(String filepath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filepath);

            NodeList studentList = document.getElementsByTagName("student");
            StringBuilder xmlContent = new StringBuilder();
            xmlContent.append("<students>\n");

            for (int i = 0; i < studentList.getLength(); i++) {
                Node studentNode = studentList.item(i);
                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) studentNode;
                    String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
                    String age = studentElement.getElementsByTagName("age").item(0).getTextContent();
                    String cls = studentElement.getElementsByTagName("class").item(0).getTextContent();
                    System.out.println("Details of student :"+(c+1));
                    c++;
                    System.out.println("Name : " + name);
                    System.out.println("Age : " + age);
                    System.out.println("Class : " + cls);  
                    System.out.println("***********************************");
} 
            }
        }
        catch (Exception e) {
            e.printStackTrace();
    }
}
}
 class XMLParser {
    static Scanner nc = new Scanner(System.in).useDelimiter("[,\\s]");
    static Scanner sc = new Scanner(System.in);
    int c=0;
    void parse(String filepath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filepath);

            NodeList studentList = document.getElementsByTagName("student");
            StringBuilder xmlContent = new StringBuilder();
            xmlContent.append("<students>\n");

            for (int i = 0; i < studentList.getLength(); i++) {
                Node studentNode = studentList.item(i);
                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) studentNode;
                    String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
                    String age = studentElement.getElementsByTagName("age").item(0).getTextContent();
                    String cls = studentElement.getElementsByTagName("class").item(0).getTextContent();
                    System.out.println("Details of student :"+(c+1));
                    c++;
                    System.out.println("Name : " + name);
                    System.out.println("Age : " + age);
                    System.out.println("Class : " + cls);
                    System.out.println("***********************************");
                    System.out.println("Would you like to make any changes? If yes, press 1");
                    int n = sc.nextInt();
                    if (n == 1) {
                        System.out.println("Enter a choice");
                        System.out.println("1 : Change Name");
                        System.out.println("2 : Change age");
                        System.out.println("3 : Change class");
                        int c = sc.nextInt();
                        switch (c) {
                            case 1:
                                System.out.println("Enter new name");
                                String nm = nc.next();
                                name = nm;
                                break;
                            case 2:
                                System.out.println("Enter new age");
                                String age1 = nc.next();
                                age = age1;
                                break;
                            case 3:
                                System.out.println("Enter new class");
                                String cls1 = nc.next();
                                cls = cls1;
                                break;
                            default:
                                break;
                        }
                    }
                    xmlContent.append("    <student>\n");
                    xmlContent.append("        <name>").append(name).append("</name>\n");
                    xmlContent.append("        <age>").append(age).append("</age>\n");
                    xmlContent.append("        <class>").append(cls).append("</class>\n");
                    xmlContent.append("    </student>\n");
                }
            }
            xmlContent.append("</students>");

            // Write the XML content to a file
            try (FileWriter writer = new FileWriter("src/output.xml")) {
                writer.write(xmlContent.toString());
                System.out.println("Data written to output.xml successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReadCSV{
    static Scanner nc = new Scanner(System.in).useDelimiter("[,\\s]");
    static Scanner sc = new Scanner(System.in);

    void showCsv(String filepath) {
        int c=0;
        String line;
        String csvSplitBy = ","; // CSV separator
            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                br.readLine(); // Skip header line
                // Read each line of the CSV file
                while ((line = br.readLine()) != null) {
                    // Split the line into fields
                    String[] data = line.split(csvSplitBy);
                    System.out.println("Details of Student :"+(c+1));
                    c++;
                    System.out.println("Name : " + data[0]);
                    System.out.println("Age : " + data[1]);
                    System.out.println("Class : " + data[2]);
                    System.out.println("***********************************");
                }
            }
catch (IOException e) {
    System.err.println(e.getMessage());
}
    }
}
class HandleCsv {
    static Scanner nc = new Scanner(System.in).useDelimiter("[,\\s]");
    static Scanner sc = new Scanner(System.in);
    int c=0;
    void csv(String filepath) {
        String line;
        String csvSplitBy = ","; // CSV separator

        try (FileWriter writer = new FileWriter("src/studentOutput.csv")) {
            writer.write("Name,Age,Class\n"); // CSV header
            
            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                br.readLine(); // Skip header line
                // Read each line of the CSV file
                while ((line = br.readLine()) != null) {
                    // Split the line into fields
                    String[] data = line.split(csvSplitBy);
                    System.out.println("Details of student :"+(c+1));
                    c++;
                    System.out.println("Name : " + data[0]);
                    System.out.println("Age : " + data[1]);
                    System.out.println("Class : " + data[2]);
                    System.out.println("***********************************");
                    System.out.println("Would you like to make any changes? If yes, press 1");
                    int n = sc.nextInt();
                    if (n == 1) {
                        System.out.println("Enter a choice");
                        System.out.println("1 : Change Name");
                        System.out.println("2 : Change age");
                        System.out.println("3 : Change class");
                        int c = sc.nextInt();
                        switch (c) {
                            case 1:
                                System.out.println("Enter new name");
                                String name = nc.next();
                                data[0] = name;
                                break;
                            case 2:
                                System.out.println("Enter new age");
                                String age = nc.next();
                                data[1] = age;
                                break;
                            case 3:
                                System.out.println("Enter new class");
                                String cls = nc.next();
                                data[2] = cls;
                                break;
                            default:
                                break;
                        }
                    }
                    // Write data to the CSV file
                    writer.write(String.join(",", data) + "\n");
                }
                System.out.println("Csv written!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
class JsonShow{
        static Scanner nc=new Scanner(System.in).useDelimiter("[,\\s]");
        static Scanner sc=new Scanner(System.in);
        void showJason(String filePath) {
            try {		
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                StringBuilder jsonText = new StringBuilder();
            
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    jsonText.append(line);
                }
                bufferedReader.close();
            
                // Parse JSON text
                JSONParser parser = new JSONParser();
                JSONArray jsonArray = (JSONArray) parser.parse(jsonText.toString());
    
               
    
                // Iterate over JSON array and create Person objects
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    Person person = new Person();
                    person.setName((String) jsonObject.get("name"));
                    person.setAge(((Long) jsonObject.get("age")).intValue());
                    person.setCls((String) jsonObject.get("class"));
                    System.out.println("Details of Student :"+i+1);
                    System.out.println("Name : "+jsonObject.get("name"));
                    System.out.println("Name : "+jsonObject.get("age"));
                    System.out.println("Name : "+jsonObject.get("class")); 
                    System.out.println("***********************************");
                } }catch (Exception e) {
                    e.printStackTrace();
                }
}
}
class JsonParser {
    static Scanner nc=new Scanner(System.in).useDelimiter("[,\\s]");
    static Scanner sc=new Scanner(System.in);
    public static Person[] parseJSONFromFile(String filePath) {
        Person[] persons = null;
        try {		
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            StringBuilder jsonText = new StringBuilder();
        
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText.append(line);
            }
            bufferedReader.close();
        
            // Parse JSON text
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(jsonText.toString());

            // Initialize array to store Person objects
            persons = new Person[jsonArray.size()];

            // Iterate over JSON array and create Person objects
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Person person = new Person();
                person.setName((String) jsonObject.get("name"));
                person.setAge(((Long) jsonObject.get("age")).intValue());
                person.setCls((String) jsonObject.get("class"));
                System.out.println("Details are :");
                System.out.println("Name : "+jsonObject.get("name"));
                System.out.println("Name : "+jsonObject.get("age"));
                System.out.println("Name : "+jsonObject.get("class")); 
                System.out.println("Would you like to make any changes ? if yes Press 1");
                int n=sc.nextInt();
                if(n==1)
                {
                System.out.println("Enter a choice");
                System.out.println("1 : Change Name");
                System.out.println("2 : Change age");
                System.out.println("3 : Change class");
                int c=sc.nextInt();
                switch (c) {
                    case 1:
                        System.out.println("Enter new name");
                        String name=nc.next();
                        person.setName(name);
                        break;
                    case 2:
                        System.out.println("Enter new age");
                        int age=sc.nextInt();
                        person.setAge(age);
                        break;
                    case 3:
                        System.out.println("Enter new class");
                        String cls=nc.next();
                        person.setCls(cls);
                        break;
                    default:
                        break;
                }
                }
                persons[i] = person;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return persons;
    }
}


class JsonWriter {
    public static void writeJSONToFile(Person[] persons, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);

            // Write the opening square bracket for the JSON array
            fileWriter.write("[\n");

            // Iterate over the array of Person objects
            for (int i = 0; i < persons.length; i++) {
                Person person = persons[i];

                // Write the JSON object for each Person
                fileWriter.write("    {\n");
                fileWriter.write("        \"name\": \"" + person.getName() + "\",\n");
                fileWriter.write("        \"age\": " + person.getAge() + ",\n");
                fileWriter.write("        \"class\": \"" + person.getCls() + "\"\n");
                fileWriter.write("    }");

                // Add comma if not the last object
                if (i < persons.length - 1) {
                    fileWriter.write(",\n");
                } else {
                    fileWriter.write("\n");
                }
            }

            // Write the closing square bracket for the JSON array
            fileWriter.write("]\n");

            // Close the FileWriter
            fileWriter.close();

            System.out.println("JSON data written to file: " + filePath);
        } catch (Exception e) {
            // Print an error message if an exception occurs
            System.out.println("Error: " + e.getMessage());
        }
    }
}

 class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int c=0;
        while(c!=-1)
        {
        System.out.println("Enter a choice");
        System.out.println("1 : Read JSON file");
        System.out.println("2 : Edit JSON file");
        System.out.println("3 : Read CSV file");
        System.out.println("4 : Edit CSV file");
        System.out.println("5 : Read XML file");
        System.out.println("6 : Edit XML file");
        c=sc.nextInt();
        String filePath ;
        switch (c) {
            case 1:
            System.out.println("Enter file path example: src/file1.csv");
            filePath =sc.next();
            if(filePath.contains(".json"))
            {
            System.out.println("YOUR JSON FILE \n*************************");
            JsonShow j=new JsonShow();
            j.showJason(filePath);
            }
            else
            System.out.println("invalid file extension");
            break;
            case 2:
            System.out.println("Enter file path example: src/file1.csv");
            filePath =sc.next();
            if(filePath.contains(".json"))
            {
            Person[] persons = JsonParser.parseJSONFromFile(filePath);
            JsonWriter.writeJSONToFile(persons,"src/outputJson.json");
            System.out.println("YOUR EDITED JSON FILE \n*************************");
            JsonShow j=new JsonShow();
            j.showJason("src/outputJson.json");
            }
            else
            System.out.println("invalid file extension");
            break;
            case 3:
            System.out.println("Enter file path example: src/file1.csv");
            filePath =sc.next();
            if(filePath.contains(".csv"))
            {
            ReadCSV r=new ReadCSV();
            r.showCsv(filePath);
            }
            else
            System.out.println("invalid file extension");
            break;
            case 4:
            System.out.println("Enter file path example: src/file1.csv");
            filePath =sc.next();
            if(filePath.contains(".csv"))
            {
            HandleCsv x=new HandleCsv();
            x.csv(filePath);
            System.out.println("***********************************");
            System.out.println("After Editing");
            ReadCSV read=new ReadCSV();
            read.showCsv("src/studentOutput.csv");
            }
            break;
            case 5:
            System.out.println("Enter file path example: src/file1.xml");
            filePath =sc.next();
            if(filePath.contains(".xml"))
            {
            ShowXml s=new ShowXml();
            s.show(filePath);
            }
            else
            System.out.println("invalid file extension");
            break;
            case 6:
            System.out.println("Enter file path example: src/file1.xml");
            filePath =sc.next();
            if(filePath.contains(".xml"))
            {
            XMLParser xml=new XMLParser();
            xml.parse(filePath);
            System.out.println("***********************************");
            System.out.println("After Editing");
            ShowXml s=new ShowXml();
            s.show("src/output.xml");
            }
            break;
            default:
                break;
        }
        }
    }
 }
 