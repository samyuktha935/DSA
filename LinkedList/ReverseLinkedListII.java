class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int count = 0;
        ListNode temp = dummy;

        ListNode beforeLeft = null;
        ListNode leftNode = null;
        ListNode rightNode = null;

        while (temp != null) {
            count++;

            if (count == left) {
                beforeLeft = temp;
                leftNode = temp.next;
            }

            if (count == right + 1) {
                rightNode = temp;
                break;
            }

            temp = temp.next;
        }

        ListNode afterRight = rightNode.next;

        rightNode.next = null;

        ListNode reversedHead = reverse(leftNode);

        beforeLeft.next = reversedHead;

        leftNode.next = afterRight;

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}