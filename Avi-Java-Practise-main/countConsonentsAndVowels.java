public class countConsonentsAndVowels {
    public static void main(String[]args)
    {
        String str = "Ae#zyu*";
        int c = 0, v = 0, o = 0;

        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') v++;

            else if((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z')) o++;

            else c++;

        }

        System.out.println("Consonents: " + c);
        System.out.println("Vowels: " + v);
        System.out.println("Others: " + o);
    }
}
