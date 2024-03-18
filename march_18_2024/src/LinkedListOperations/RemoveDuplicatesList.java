package LinkedListOperations;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class ListNode{
    int val;
    ListNode next;

    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
}

class RemoveDuplicatesList{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of list 1");
        int sizeOfList1 = scanner.nextInt();
        ListNode head1 = new ListNode();
        ListNode list1 = head1;
        System.out.println("enter "+ sizeOfList1+" elements of list 1");
        for(int node = 0; node < sizeOfList1; node++){
            list1.next = new ListNode(scanner.nextInt());
            list1 = list1.next;
        }
        ListNode resultList = duplicateRemove(head1.next);
        System.out.println("Result list:");
        while(resultList != null){
            System.out.println(resultList.val);
            resultList = resultList.next;
        }
    }

    public static ListNode duplicateRemove(ListNode head){
        Set<Integer> listValues = new HashSet<Integer>();
        ListNode result = new ListNode();
        ListNode curr = result;
        while(head != null){

            if(!listValues.contains(head.val)) {
                curr.next = new ListNode((head.val));
                curr = curr.next;
            }
            listValues.add(head.val);
            head = head.next;

        }
        return result.next;
    }

}