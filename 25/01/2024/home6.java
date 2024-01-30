class home6 {
    public static void main(String[] args){
        int n = 15451;
        String s = String.valueOf(n);
        if(checkPalindrome(s))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
    public static boolean checkPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
