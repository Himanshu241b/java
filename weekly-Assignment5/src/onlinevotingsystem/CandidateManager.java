package onlinevotingsystem;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Candidate Manager class to manage the candidate through admin
 */
class CandidateManager{
    static Scanner scanner = new Scanner(System.in);

    /**
     * method to add a candidate to the list of candidates in database
     * @param candidatesCsvPath
     */
    public static void addCandidate(String candidatesCsvPath){

        // take add details
        System.out.println("Enter candidate id:");
        String candidateId = scanner.next();
        System.out.println("Enter candidate name:");
        String candidateName = scanner.next();
        System.out.println("Enter candidate date of birth:");
        String candidateDateOfBirth = scanner.next();
        System.out.println("Enter candidate symbol:");
        String candidateSymbol = scanner.next();
        System.out.println("Enter candidate's employee id");
        String candidateEmployeeId = scanner.next();

        // Create  new entry
        String[] newEntry = {candidateEmployeeId,candidateId, candidateName, candidateDateOfBirth, candidateSymbol, "0"};

        //write to database
        try {
            // Create a BufferedWriter to write to the CSV file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(candidatesCsvPath, true));

            // Join the array elements into a CSV-formatted string
            String csvLine = String.join(",", newEntry);

            // Write the new entry to the CSV file
            bufferedWriter.write(csvLine);
            bufferedWriter.newLine();

            // Close the bufferedWriter
            bufferedWriter.close();

            System.out.println("New candidate added successfully");
        }
        catch(FileNotFoundException fileNotFoundException){
            System.out.println("File not found while adding candidate");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editCandidate(String candidateCsvPath){
        System.out.println("Enter id of candidate to edit:");
        String candidateId = scanner.next();

        // ID of the candidate you want to edit
        System.out.println("Enter new id:");
        String candidateIdToEdit = scanner.next();
        System.out.println("Enter new name:");
        String newNameToEdit = scanner.next();
        System.out.println("Enter new date Of Birth:");
        String  newDateOfBirthToEdit = scanner.next();
        System.out.println("Enter new election symbol:");
        String newElectionSymbolToEdit = scanner.next();


        // Read all lines from the CSV file
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(candidateCsvPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // If the line corresponds to the candidate we want to edit, update it
                if (parts.length > 0 && parts[1].equals(candidateId)) {
                    lines.add(new String[]{parts[0],candidateIdToEdit, newNameToEdit, newDateOfBirthToEdit, newElectionSymbolToEdit, parts[5]});
                } else {
                    lines.add(parts);
                }
            }
        }
        catch(FileNotFoundException fileNotFoundException){
            System.out.println("File not found while trying to edit candidate");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the updated contents back to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(candidateCsvPath))) {
            for (String[] parts : lines) {
                String line = String.join(",", parts);
                bw.write(line);
                bw.newLine();
            }
        }
            catch (FileNotFoundException fileNotFoundException){
                System.out.println("File not found while trying to edit candidate");
            }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Candidate credentials updated successfully.");
    }

    public static void deleteCandidate(String candidateCsvPath){
        System.out.println("Enter candidate id of candidate to delete:");
        String deleteCandidateId = scanner.next();
        System.out.println("Enter candidate id again to confirm the deletion:");
        String deleteCandidateIdAgain = scanner.next();
        if(!deleteCandidateIdAgain.equals(deleteCandidateId)) {
            System.out.println("Id of candidate dont match cant delete");
            return;
        }

        boolean isDeleted = false;
        // Read all lines from the CSV file
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(candidateCsvPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                // If the line corresponds to the candidate we want to edit, update it
                if (parts.length > 0 && parts[1].equals(deleteCandidateId)) {
                    isDeleted = true;
                    continue;
                } else {
                    lines.add(parts);
                }
            }
        }
        catch(FileNotFoundException fileNotFoundException){
            System.out.println("File not found while trying to edit candidate");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the updated contents back to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(candidateCsvPath))) {
            for (String[] parts : lines) {
                String line = String.join(",", parts);
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(isDeleted){
            System.out.println("Candidate deleted successfully");
        }
        else
            System.out.println("Candidate not found");
    }
}