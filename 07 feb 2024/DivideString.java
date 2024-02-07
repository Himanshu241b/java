import java.util.*;
class DivideString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<String> words = new ArrayList<String>();
        System.out.println("Enter the string");
        String s = sc.next();
        System.out.println("Enter size of word list");
        int n= sc.nextInt();
        System.out.println("Enter the list of words");
        for(int i = 0; i < n; i++){
            words.add(sc.next());
        }
        if(wordBreak(s, words))
            System.out.println("true");
        else
            System.out.println("false");

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(); // length of string
        boolean dp[] = new boolean[n+1];
        dp[n] = true;

        for(int i = n-1; i>=0; --i){
            for(int j = 0; j<wordDict.size(); ++j){
                if(i+wordDict.get(j).length() <= n && s.substring(i, i+wordDict.get(j).length()).equals(wordDict.get(j)))
                    dp[i] = dp[i + wordDict.get(j).length()];
                if(dp[i])
                    break;
            }
        }
        return dp[0];
    }
}