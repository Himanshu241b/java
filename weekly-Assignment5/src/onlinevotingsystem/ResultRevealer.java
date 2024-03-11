package onlinevotingsystem;
//import
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.NumberFormatException;

/**
 * class to reveal the results
 */
class ResultRevealer{
    /**
     * method to show current status of voting
     * @param candidateCsvPath path of candidatecsv file
     */
    public static void showStatus(String candidateCsvPath){
        // read the input file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(candidateCsvPath))) {
            String line;
            bufferedReader.readLine();
            //displays all candidates with their results
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


    /**
     * method to display the final result at election end it just finds the candidate with maximum number of votes
     * @param candidateCsvPath path to the candidatecsv file
     */

        public static void declare(String candidateCsvPath){
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(candidateCsvPath))) {
                String line;
                int maxVotes = 0;
                bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split(",");
                    int candidateVotes = Integer.parseInt(parts[5]);
                    if (candidateVotes > maxVotes)
                        maxVotes = candidateVotes;
                }
                displayResult(maxVotes, candidateCsvPath);
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("invalid input while parsing string to integer.");
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("File not found while trying to display candidate");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    /**
     * methodto display the end result of voting
     * @param maxVotes max number of votes obtained in the election
     * @param candidateCsvPath path of candidatecsv file
     */
    public static void displayResult(int maxVotes, String candidateCsvPath){
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(candidateCsvPath))) {
                String line;
                System.out.println("************Result************");
                bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if(parts[5].equals(String.valueOf(maxVotes)));
                        System.out.println(parts[2] +" has won the election");
                }
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("File not found while trying to display candidate");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}