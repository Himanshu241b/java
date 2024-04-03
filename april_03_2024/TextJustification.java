package april_01_2024;
import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int currentLineLength = 0;
        List<String> currentLineWords = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (currentLineLength + word.length() + currentLineWords.size() > maxWidth) {
                result.add(justifyLine(currentLineWords, currentLineLength, maxWidth));
                currentLineWords.clear();
                currentLineLength = 0;
            }
            currentLineWords.add(word);
            currentLineLength += word.length();
        }

        // Last line (left-justified)
        StringBuilder lastLine = new StringBuilder();
        lastLine.append(String.join(" ", currentLineWords));
        lastLine.append(" ".repeat(Math.max(0, maxWidth - currentLineLength - currentLineWords.size() + 1)));
        result.add(lastLine.toString());

        return result;
    }

    private String justifyLine(List<String> words, int currentLineLength, int maxWidth) {
        StringBuilder line = new StringBuilder();
        if (words.size() == 1 || words.size() == maxWidth) {
            line.append(words.get(0));
            line.append(" ".repeat(Math.max(0, maxWidth - currentLineLength)));
        } else {
            int totalSpaces = maxWidth - currentLineLength;
            int spaceSlots = words.size() - 1;
            int spacesBetweenWords = totalSpaces / spaceSlots;
            int extraSpaces = totalSpaces % spaceSlots;

            for (int i = 0; i < words.size() - 1; i++) {
                line.append(words.get(i));
                line.append(" ".repeat(spacesBetweenWords));
                if (extraSpaces > 0) {
                    line.append(" ");
                    extraSpaces--;
                }
            }
            line.append(words.get(words.size() - 1));
        }
        return line.toString();
    }

    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> result = textJustification.fullJustify(words, maxWidth);
        for (String line : result) {
            System.out.println(line);
        }
    }
}

