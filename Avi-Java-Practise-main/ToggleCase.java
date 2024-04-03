public class ToggleCase {
    public static void main(String[]args)
    {
        String str = "AhghKJH^&*(";
        String ans = "";

        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(Character.isUpperCase(ch)) ans += Character.toLowerCase(ch);

            else if(Character.isLowerCase(ch)) ans += Character.toUpperCase(ch);

            else ans += ch;

        }

        for(int i=0; i<str.length(); i++) System.out.print(ans.charAt(i));
    }
}
