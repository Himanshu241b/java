package comparator;

import java.io.*;


public class TextFile {
    String TextFilePath;

    public TextFile(String textFilePath) {
        TextFilePath = textFilePath;
    }



    public static void CompareFileText(TextFile textFile1, TextFile textFile2) {


        boolean flag = false;           //flag to check any differences present in the File or not


        //read the file
        try (BufferedReader reader1 = new BufferedReader(new FileReader(textFile1.TextFilePath));
             BufferedReader reader2 = new BufferedReader(new FileReader(textFile2.TextFilePath))) {
            String currentLine1;
            String currentLine2;
            int SentenceNumber=1;
            while ((currentLine1 = reader1.readLine()) != null && (currentLine2 = reader2.readLine()) != null) {
                String[] segments1 = currentLine1.split("\\. "); // Split line into Sentences
                String[] segments2 = currentLine2.split("\\. "); // Split line into Sentences

                int minLength = Math.min(segments1.length, segments2.length);

                for (int i = 0; i < minLength; i++) {
                    String[] words1 = segments1[i].split("\\s+"); // Split segment into words
                    String[] words2 = segments2[i].split("\\s+"); // Split segment into words

                    int minWordLength = Math.min(words1.length, words2.length);

                    for (int j = 0; j < minWordLength; j++) {
                        if (!words1[j].equals(words2[j])) {
                            System.out.println("Difference found (Sentence No)="+SentenceNumber+"\n" +"Expected : "+ words1[j] + " Present : " + words2[j]+"\n");
                            flag = true; // Set flag to true if differences are found
                        }
                    }
                    SentenceNumber++;
                }


            }
            if (!flag) {
                System.out.println("Both Text Files are same");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
