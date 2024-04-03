package javaBasics.date_01_03_24;

// Definition of ListNode class representing nodes in a linked list
class ListNode {
    int val; // Value of the node
    ListNode next; // Reference to the next node in the list

    // Constructors
    ListNode() {} // Default constructor
    ListNode(int val) { this.val = val; } // Constructor with value parameter
    ListNode(int val, ListNode next) { // Constructor with both value and next node parameters
        this.val = val;
        this.next = next;
    }
}

// Class to merge k sorted linked lists
class MergeKSortedLinkedLists {
    // Method to merge k sorted linked lists
    public static ListNode mergeKLists(ListNode[] lists) {
        // Check if the input list of linked lists is null or empty
        if (lists == null || lists.length == 0)
            return null; // If so, return null

        // Call the helper method to perform the merge operation recursively
        return mergeListsHelper(lists, 0, lists.length - 1);
    }

    // Helper method to merge lists recursively
    public static ListNode mergeListsHelper(ListNode[] lists, int start, int end) {
        // Base cases for recursion
        if (start == end) // If only one list is remaining
            return lists[start]; // Return that list
        if (start + 1 == end) // If there are two lists remaining
            return merge(lists[start], lists[end]); // Merge and return them

        // Calculate the middle index
        int mid = start + (end - start) / 2;
        // Recursively merge the lists on the left and right sides of the current range
        ListNode left = mergeListsHelper(lists, start, mid);
        ListNode right = mergeListsHelper(lists, mid + 1, end);
        // Merge the resulting lists
        return merge(left, right);
    }

    // Method to merge two sorted linked lists
    public static ListNode merge(ListNode l1, ListNode l2) {
        // Create a dummy node to facilitate merging
        ListNode dummy = new ListNode();
        ListNode curr = dummy; // Pointer to the current node in the merged list

        // Iterate through both lists until one of them reaches the end
        while (l1 != null && l2 != null) {
            // Compare the values of the current nodes in the two lists
            if (l1.val < l2.val) {
                // If the value in the first list is smaller, append it to the merged list
                curr.next = l1;
                l1 = l1.next; // Move to the next node in the first list
            } else {
                // If the value in the second list is smaller or equal, append it to the merged list
                curr.next = l2;
                l2 = l2.next; // Move to the next node in the second list
            }
            curr = curr.next; // Move the current pointer to the newly added node in the merged list
        }

        // Append the remaining nodes from the non-empty list
        curr.next = (l1 != null) ? l1 : l2;

        // Return the merged list (excluding the dummy node)
        return dummy.next;
    }

    // Main method to test the merge operation
    public static void main(String[] args) {
        // Create an array to hold the linked lists
        ListNode[] lists = new ListNode[3];

        // Create three sorted linked lists
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(6);

        ListNode l3 = new ListNode(6);
        l3.next = new ListNode(8);
        l3.next.next = new ListNode(9);

        // Assign the linked lists to the array
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        // Merge the lists and store the result
        ListNode result = mergeKLists(lists);

        // Print the values of the merged list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
