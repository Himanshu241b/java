
public class home1 {
    public static void main(String[] args) {
        int n = 12;
        String ans = Binary(n);
        System.out.println(ans);
    }

    public static String Binary(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int rem = decimal % 2;
            binary.insert(0, rem); // add at the beginning of the string
            decimal = decimal / 2;
        }

        return binary.toString();
    }
}

