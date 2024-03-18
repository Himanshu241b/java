package LinkedListOperations;

import java.util.Scanner;

class SumReversedLinkedLists{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //list1 input
        System.out.println("Enter size of list 1");
        int sizeOfList1 = scanner.nextInt();
        ListNode head1 = new ListNode();
        ListNode list1 = head1;
        System.out.println("enter "+ sizeOfList1+" elements of list 1");
        for(int node = 0; node < sizeOfList1; node++){
            list1.next = new ListNode(scanner.nextInt());
            list1 = list1.next;
        }

        //list2 input
        System.out.println("Enter size of list 2");
        int sizeOfList2 = scanner.nextInt();
        ListNode head2 = new ListNode();
        ListNode list2 = head2;
        System.out.println("enter "+sizeOfList2+" elements of list 1");
        for(int node = 0; node < sizeOfList2; node++){
            list2.next = new ListNode(scanner.nextInt());
            list2 = list2.next;
        }

        ListNode resultList =  addLists(head1.next, head2.next);
        System.out.println("Result:");
        while(resultList != null){
            System.out.print(resultList.val);
            resultList = resultList.next;
        }
    }
    public static ListNode addLists(ListNode list1,ListNode list2){
        ListNode result  = new ListNode();
        ListNode curr = result;
        int carry = 0;

        while(list1 != null || list2 != null || carry == 1){
            int sum = 0;
            if(list1 != null){
                sum += list1.val;
                list1 = list1.next;
            }
            if(list2 != null){
                sum += list2.val;
                list2 = list2.next;
            }
            sum += carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
        }
        return result.next;
    }

}