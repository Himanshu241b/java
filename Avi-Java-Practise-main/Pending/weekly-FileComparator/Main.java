package comparator;

import java.util.InputMismatchException;
import java.util.Scanner;

import static comparator.CsvFile.CompareFileCsv;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Options : ");
                System.out.println("1. Compare Text File : ");
                System.out.println("2. Compare Csv File : ");
                System.out.println("3. Exit the System : ");
                System.out.println("\nEnter Your Choice : ");
                try {
                    int choice = sc.nextInt();
                    sc.nextLine();
                    if (choice > 3) {
                        throw new InputMismatchException();
                    }
                    switch (choice) {
                        case 1:
                            System.out.println("Enter File Path of 1 text File (True) : ");
                            String TextFilename1 = sc.nextLine();
                            TextFile textFileTrue = new TextFile(TextFilename1);
                            System.out.println("Enter File Path of 2 text File (error expected) : ");
                            String TextFilename2 = sc.nextLine();
                            TextFile textFileError = new TextFile(TextFilename2);
                           TextFile.CompareFileText(textFileTrue, textFileError);
                            break;

                        case 2:
                            System.out.println("Enter File Path of 1 csv file(True) : ");
                            String CsvFilename1 = sc.nextLine();
                            CsvFile csvFile1 = new CsvFile(CsvFilename1);
                            System.out.println("Enter File Path of 2 csv file(error expected) : ");
                            String filename2 = sc.nextLine();
                            CsvFile csvFile2 = new CsvFile(filename2);
                            CompareFileCsv(csvFile1, csvFile2);
                            break;


                        case 3:
                            System.out.println("-------Exiting System-------");
                            System.exit(0);

                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
            }

        }
    }
}
