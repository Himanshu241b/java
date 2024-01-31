import java.lang.*;
public class toggle {
    public static void main(String[] args) {
        String s = "Ap#PLe";
        System.out.println(toggleString(s));
    }


    public static String toggleString(String s){  // main logic for toggle
        StringBuilder sb = new StringBuilder();   // stringbuilder object for storage of toggled string
        for(int i = 0; i < s.length(); ++i){
            if(Character.isUpperCase(s.charAt(i)))
                sb.append(Character.toLowerCase(s.charAt(i))); // check if character is lower case and append the uppercased to result
            else
                sb.append(Character.toUpperCase(s.charAt(i)));// check if character is upper case and append the lowercased to result
        }   
        return sb.toString();
    }
}
