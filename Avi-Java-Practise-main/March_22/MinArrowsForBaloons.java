import java.util.Arrays;

public class MinArrowsForBaloons {
    public static void main(String[] args) {
        int[] ARR1 = {2, 1, 5, 4, 3};
        int[] ARR2 = {3, 2, 1,};
        System.out.println(minArrows(ARR1));
        System.out.println(minArrows(ARR2));
    }

    public static int minArrows(int[] ARR) {
        if (ARR.length == 0) return 0;


        int arrows = 1;
        int maxHeight = ARR[0];

        for (int i = 1; i < ARR.length; i++) {
            if (ARR[i] > maxHeight) {
                arrows++;
                maxHeight = ARR[i];
            }
        }

        return arrows;
    }
}
