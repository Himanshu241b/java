package filecomparator;

//imports
import java.util.List;
import java.util.Scanner;
/**
 * Main class containing the driver code
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileComparator fileComparator = new FileComparator();
        FileImporter reader = new FileImporter();

        char choice;
        do{
            System.out.println("press 1. for csv file");
            System.out.println("press 2. for text file");
            System.out.println("press 3. for xml file");
            System.out.println("press 0. to exit program");
            choice = scanner.next().charAt(0);
            switch(choice){
                case '1':
                    System.out.println("Enter path of actual file:");
                    String csvPath1 = scanner.next();
                    System.out.println("Enter path of expected file:");
                    String csvPath2 = scanner.next();
                    System.out.println("Do you want to ignore any columns(yes/no)?");
                    String ignoreCase = scanner.next();
                    if(ignoreCase.equalsIgnoreCase("yes")){
                        System.out.println("How many columns you want to ignore?");
                        int ignoreCount = scanner.nextInt();
                        String[] ignoreColumns = new String[ignoreCount];
                        System.out.println("Enter the name of columns");
                        for(int column = 0; column < ignoreCount; column++){
                            ignoreColumns[column] = scanner.next();
                        }
                        List<String[]> csvList1 = reader.readCsv(csvPath1);
                        List<String[]> csvList2 = reader.readCsv(csvPath2);
                        if(fileComparator.compareCsv(csvList1, csvList2, ignoreColumns))
                            System.out.println("Files are equal so no new file generated");
                        else
                            fileComparator.createCsvOutputFile(csvList1, csvList2, ignoreColumns);
                    }
                    break;
                case '2':
                    System.out.println("Enter path of actual file:");
                    String txtPath1 = scanner.next();
                    System.out.println("Enter path of expected file:");
                    String txtPath2 = scanner.next();
                    List<String[]> txtList1 = reader.readTxt(txtPath1);
                    List<String[]> txtList2 = reader.readTxt(txtPath2);
                    fileComparator.compareTxt(txtList1, txtList2);
                    break;
                case '3':
                    System.out.println("Enter path of actual file:");
                    String xmlPath1 = scanner.next();
                    System.out.println("Enter path of expected file:");
                    String xmlPath2 =scanner.next();
                    try {
                        fileComparator.compareXml(xmlPath1, xmlPath2);
                    }catch (XmlFileDontExistException xmlFileDontExistException){
                        System.out.println(xmlFileDontExistException.getMessage());
                    }
                    break;
                case '0':
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice");
            }
        }while(true);
    }
}


