class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverse(slow.next);
        slow.next = null;

        // Step 3: Merge the two halves
        ListNode firstHalf = head;
        while (firstHalf != null && secondHalf != null) {
            ListNode nextFirst = firstHalf.next;
            ListNode nextSecond = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = nextFirst;

            firstHalf = nextFirst;
            secondHalf = nextSecond;
        }
    }
}
