package april_01_2024;
import java.util.*;

public class WordTranformation {

    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        List<List<String>> transformationSequences = new ArrayList<>();
        Set<String> dictionary = new HashSet<>(dict);

        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(Arrays.asList(start)));

        Set<String> visited = new HashSet<>();
        visited.add(start);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> currentLevelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                List<String> sequence = queue.poll();
                String currentWord = sequence.get(sequence.size() - 1);

                if (currentWord.equals(end)) {
                    transformationSequences.add(sequence);
                    found = true;
                    continue;
                }

                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordArray = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String transformedWord = new String(wordArray);
                        if (dictionary.contains(transformedWord) && !visited.contains(transformedWord)) {
                            List<String> newSequence = new ArrayList<>(sequence);
                            newSequence.add(transformedWord);
                            queue.offer(newSequence);
                            currentLevelVisited.add(transformedWord);
                        }
                    }
                }
            }

            visited.addAll(currentLevelVisited);
        }

        return transformationSequences;
    }

    public static void main(String[] args) {
        WordTranformation solution = new WordTranformation();
        String start = "hit";
        String end = "cog";
        List<String> dict = Arrays.asList("hot", "dot", "dog", "lot", "log");
        List<List<String>> transformationSequences = solution.findLadders(start, end, dict);
        for (List<String> sequence : transformationSequences) {
            System.out.println(sequence);
        }
    }
}

