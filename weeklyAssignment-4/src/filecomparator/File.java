package filecomparator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class File {
    public static void main(String[] args) {
        String file1Path = "file1.txt";
        String file2Path = "file2.txt";

        try {
            List<String> file1Lines = Files.readAllLines(Paths.get(file1Path));
            List<String> file2Lines = Files.readAllLines(Paths.get(file2Path));

            int maxLength = Math.max(file1Lines.size(), file2Lines.size());

            for (int i = 0; i < maxLength; i++) {
                List<String> file1Words = new ArrayList<>();
                List<String> file2Words = new ArrayList<>();

                if (i < file1Lines.size())
                    file1Words.addAll(Arrays.asList(file1Lines.get(i).split("\\s+")));
                if (i < file2Lines.size())
                    file2Words.addAll(Arrays.asList(file2Lines.get(i).split("\\s+")));

                if (!file1Words.equals(file2Words)) {
                    System.out.println("Difference found in line " + (i + 1) + ":");

                    // Print words difference
                    for (int j = 0; j < Math.max(file1Words.size(), file2Words.size()); j++) {
                        if (j < file1Words.size() && j < file2Words.size()) {
                            if (!file1Words.get(j).equals(file2Words.get(j))) {
                                System.out.println("File 1: " + file1Words.get(j));
                                System.out.println("File 2: " + file2Words.get(j));
                            }
                        } else if (j < file1Words.size()) {
                            System.out.println("Extra word in File 1: " + file1Words.get(j));
                        } else {
                            System.out.println("Extra word in File 2: " + file2Words.get(j));
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }
}
