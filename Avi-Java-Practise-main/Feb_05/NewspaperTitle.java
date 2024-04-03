package Feb_05;

import java.util.*;

public class NewspaperTitle {
    public static void main(String[] args) {
        //Assume you are working at a newspaper. Your task is to prepare a page with titles that writers send you. Your cat was walking over your keyboard and accidentally added characters. Now you need to filter out the titles and prepare them for publishing.
        //Assume that titles are in an array of strings. You need to do the following procedures on it:
        //• Create a single string by concatenating the strings in the array
        //• Delete all numeric symbols from the string
        //• Capitalize the first character of each word in the string
        //Don't forget to think through any corner cases.
        String[] arr = {"break3ing news5:", "1A 1circle is round!"};

        StringBuilder res = new StringBuilder();

        for(String i: arr)
        {
            int j = 0;
            while(Character.isDigit(i.charAt(j))){
                j++;
            }
            for(int k=j;  k<i.length(); k++)
            {
                if(k == j){
                    res.append(Character.toUpperCase(i.charAt(k)));
                }
                else if(i.charAt(k-1) == ' ' && Character.isDigit(i.charAt(k))){
                 while(k < i.length() && Character.isDigit(i.charAt(k)))  k++;
                 if(k < i.length()) res.append(Character.toUpperCase(i.charAt(k)));
                }
                else if(i.charAt(k-1) == ' ' && !Character.isDigit(i.charAt(k))) res.append(Character.toUpperCase(i.charAt(k)));
                else if(!Character.isDigit(i.charAt(k))) res.append(i.charAt(k));
            }
            res.append(' ');
        }
        System.out.println(res);
    }
}
