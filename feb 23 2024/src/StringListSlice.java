// imports
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class to Slice the string contains main driver code
 */
public class StringListSlice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the input string");
            String str = sc.next();
            System.out.println("Enter the begin index:");
            int start = sc.nextInt();
            System.out.println("Enter the end index:");
            int end = sc.nextInt();
            StringList sl = new StringList(str);
            String result = sl.stringListSlice(start, end);
            System.out.println("sliced string is :" + result);
        }
        catch(InputMismatchException e){
            System.out.println("Enter valid input");
        }
    }

}

/**
 * ListNode class representing one node of a list
 */
class ListNode{
    char val;
    ListNode next;

    /**
     * constructor to initialize a node
     * @param val a character value present in node
     */
    ListNode(char val){
        this.val = val;
        this.next = null;
    }
}

/**
 * StringList class representing the list of chars
 */
class StringList{
    ListNode head;
    ListNode tail;

    /**
     * constructor to initialize the list with a string
     * @param str string to be stored in list
     */
    StringList(String str){
        for(char c : str.toCharArray())
                append(c);
    }

    /**
     * method to append character to list
     * @param c character to append to list
     */
    public void append(char c) {
        ListNode newNode = new ListNode(c);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * method to slice the string
     * @param begin from where to slice
     * @param end end index to reach
     * @return slicedString
     */
    public String stringListSlice(int begin, int end){
        StringBuilder slicedString = new StringBuilder();
        ListNode curr = head;
        int index = 0;

        while(curr != null){
            if(index >= begin && index < end)
                slicedString.append(curr.val);
            else if(index >= end)
                break;
            curr = curr.next;
            ++index;
        }
        return slicedString.toString();
    }
}