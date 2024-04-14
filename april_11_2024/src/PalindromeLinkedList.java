class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class PalindromeLinkedList {

    public static int isPalindrome(ListNode A) {
        if (A == null || A.next == null) {
            return 1; // Single node or empty list is considered palindrome
        }

        // Find the middle of the linked list
        ListNode slow = A;
        ListNode fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode secondHalf = reverseList(slow.next);

        // Compare the first half and the reversed second half
        ListNode p1 = A;
        ListNode p2 = secondHalf;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return 0; // Not a palindrome
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return 1; // Palindrome
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head1)); // Output: 1

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(2);
        System.out.println(isPalindrome(head2)); // Output: 0
    }
}
