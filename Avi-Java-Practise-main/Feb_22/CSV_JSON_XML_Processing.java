package Feb_22;

import java.util.*;
import java.io.*;

public class CSV_JSON_XML_Processing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input and output file path
        String inputFile = sc.nextLine();
        String outputFile = sc.nextLine();

        String csv = "csv";
        String xml = "xml";
        String json = "json";

        String temp = "";
        for(int i=inputFile.length()-1; i>=0; i--)
        {
            if(inputFile.charAt(i) == '.') break;
            temp = inputFile.charAt(i) + temp;
        }

        String temp2 = "";
        for(int i=outputFile.length()-1; i>=0; i--)
        {
            if(outputFile.charAt(i) == '.') break;
            temp = outputFile.charAt(i) + temp2;
        }
        if(temp != temp2){
            System.out.println("Your file extensions dont match");
            return;
        }

        if(temp == csv)
        {
            DataProcessing data = new DataProcessing();
            data.handleCSV(inputFile, outputFile);
        }
        else if(temp == xml)
        {

        }
        else if(temp == json)
        {
            DataProcessing data = new DataProcessing();
            data.handleJSON(inputFile, outputFile);
        }
        else System.out.println("Sorry! we dont support this type of format");
    }
}
