class odd_evendigitssum {
    public static void main(String[] args) {
        int oddSum = 0;
        int evenSum = 0;
        int val = 12435;
        while(val > 0){
            int digit = val % 10;
            val /= 10;
            if(digit % 2 == 0)
                evenSum += digit;
            else 
                oddSum += digit;
        }
        System.out.println("evenSum: " + evenSum);  
        System.out.println("oddSum: " + oddSum);
    }
}