package csvread;

//imports
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class containing driver code
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // define the csv file path
        String filePath = "/home/himanshu/Desktop/Avisoft/java/21 feb 2024/src/csvread/employee.csv";
        
        //readCSV object
        ReadCSV reader = new ReadCSV();
        double averageSalary = reader.getAverageSalary(filePath); // getting averageSalary

        int thresholdPercent;
        while(true){
        try{
        System.out.println("Enter the threshold percentage:");
        thresholdPercent = sc.nextInt();
        break;
        }
        catch(InputMismatchException e){
            System.err.println("Enter valid threshold percentage");
        }
    }
        // writing the csv file with name,salary above averagethreshold

        reader.writeCSVFilteredBySalary("output.csv", thresholdPercent);
        
        }
    }

