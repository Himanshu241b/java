package Feb_05.recursion;

import java.util.Scanner;

public class TowerOfHanoi {

    static void TOH(int n, String src, String aux, String dest)
    {
        //base case
        if(n == 1)
        {
            System.out.println(src + " -> " + dest);
            return;
        }

        TOH(n-1, src, dest, aux);
        TOH(1, src, aux, dest);
        TOH(n-1, aux, src, dest);
    }
    public static void main(String[] args) {
        //Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move all disks from source rod to destination rod using third rod (say auxiliary). The rules are :
        //
        //1) Only one disk can be moved at a time.
        //2) A disk can be moved only if it is on the top of a rod.
        //3) No disk can be placed on the top of a smaller disk.
        //Print the steps required to move n disks from source rod to destination rod.
        //
        //Source Rod is named as 'a', auxiliary rod as 'b' and destination rod as 'c'.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of disks: ");
        int n = sc.nextInt();

        TOH(n, "Source", "Auxilary", "Destination");

    }
}
