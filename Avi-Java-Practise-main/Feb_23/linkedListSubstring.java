package Feb_23;

import java.util.LinkedList;
import java.util.Scanner;

class Node{
    char data;
    Node next;

    Node(char d)
    {
        this.data = d;
        next = null;
    }
}
class StringList {
    Node head;

    // Constructor to initialize the linked list with the given string
    StringList(String str) {
        if (str != null && str.length() > 0) {
            head = new Node(str.charAt(0));
            Node current = head;
            for (int i = 1; i < str.length(); i++) {
                current.next = new Node(str.charAt(i));
                current = current.next;
            }
        }
    }
}
public class linkedListSubstring {

    public static String string_list_slice(StringList stringList, int begin, int end) {
        StringBuilder sb = new StringBuilder();
        Node current = stringList.head;
        int index = 0;
        while (current != null && index < end) {
            if (index >= begin) {
                sb.append(current.data);
            }
            current = current.next;
            index++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {


            // Test examples
            StringList stringList1 = new StringList("A whole new internet");
            System.out.println(string_list_slice(stringList1, 2, 11)); // Output: "whole new"

            StringList stringList2 = new StringList("Computing calmly at home");
            System.out.println(string_list_slice(stringList2, 0, 50)); // Output: "Computing calmly at home"



    }
}
