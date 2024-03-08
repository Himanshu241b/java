package onlinevotingsystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ResultRevealer{
    public static void showStatus(String candidateCsvPath){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(candidateCsvPath))) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println(parts[2] + " with symbol " + parts[4] + " has " + parts[5]+" votes.");
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found while trying to display candidate");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}