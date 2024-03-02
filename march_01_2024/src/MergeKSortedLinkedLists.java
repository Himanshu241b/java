class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class MergeKSortedLinkedLists{
    public static void main(String[] args){
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(6);

        ListNode l3 = new ListNode(6);
        l3.next = new ListNode(8);
        l3.next.next = new ListNode(9);

        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        ListNode result = mergeKLists(lists);

        while(result != null){
            System.out.println(result.val+" ");
            result = result.next;
        }
    }
    
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;

        return mergeListsHelper(lists, 0, lists.length-1);
    }
    public static ListNode mergeListsHelper(ListNode[] lists, int start, int end){
        if(start == end)
            return lists[start];
        if(start+1 == end)
            return merge(lists[start], lists[end]);
        int mid = start + (end-start) / 2;
        ListNode left = mergeListsHelper(lists, start, mid);
        ListNode right = mergeListsHelper(lists, mid+1, end);
        return merge(left, right);
    }
    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

}