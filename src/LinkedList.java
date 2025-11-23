import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    ListNode head;
    ListNode tail;

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // constructor
    LinkedList(int val) {
        ListNode newHead = new ListNode(val);
        // head must be null
        this.head = newHead;
        this.tail = this.head;
        this.head.next = this.tail;
    }

    LinkedList() {

    }

    private void addTail(int val) {
        ListNode newNode = new ListNode(val);

        this.tail.next = newNode;
        this.tail = newNode;
        this.tail.next = null;
    }

    private ListNode getHead() {
        return this.head;
    }

    // private void findAndRemove(int val) {
    // ListNode current = this.head;
    // ListNode previous = this.head;
    // while (current != null) {
    // if (current == this.head && current.val == val) {
    // this.head = current.next;
    // previous = this.head;
    // } else if (current.val == val) {
    // previous.next = current.next;
    // } else {
    // previous = current;
    // }
    // current = current.next;
    // }
    // }

    private void printAndTraverse() {
        List<Integer> listOfVal = new ArrayList<>();
        ListNode current = this.head;
        while (current != null) {
            listOfVal.add(current.val);
            current = current.next;
        }

        System.out.println(listOfVal.toString());
    }

    private void printAndTraverse(ListNode head) {
        List<Integer> listOfVal = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            listOfVal.add(current.val);
            current = current.next;
        }

        System.out.println(listOfVal.toString());
    }

    /** Leetcode Linkedlist */
    // private boolean linkedListCycle(ListNode head) {

    // /**
    // * 141. Linked List Cycle
    // * Easy
    // * Topics
    // * premium lock icon
    // * Companies
    // * Given head, the head of a linked list, determine if the linked list has a
    // * cycle in it.
    // *
    // * There is a cycle in a linked list if there is some node in the list that
    // can
    // * be reached again by continuously following the next pointer. Internally,
    // pos
    // * is used to denote the index of the node that tail's next pointer is
    // connected
    // * to. Note that pos is not passed as a parameter.
    // *
    // * Return true if there is a cycle in the linked list. Otherwise, return
    // false.
    // *
    // * Example 1:
    // *
    // *
    // * Input: head = [3,2,0,-4], pos = 1
    // * Output: true
    // * Explanation: There is a cycle in the linked list, where the tail connects
    // to
    // * the 1st node (0-indexed).
    // * Example 2:
    // *
    // *
    // * Input: head = [1,2], pos = 0
    // * Output: true
    // * Explanation: There is a cycle in the linked list, where the tail connects
    // to
    // * the 0th node.
    // * Example 3:
    // *
    // *
    // * Input: head = [1], pos = -1
    // * Output: false
    // * Explanation: There is no cycle in the linked list.
    // *
    // */

    // if (head == null)
    // return false;

    // ListNode current = head;
    // Integer pos = 3;
    // Integer counter = 0;

    // while (current != null) {
    // counter += 1;
    // current = current.next;
    // }

    // if ((pos < counter - 1 && pos >= 0))
    // return true;

    // return false;

    // }

    private ListNode reverseLinkedList(ListNode head) {

        /**
         * Given the head of a singly linked list, reverse the list, and return the
         * reversed list.
         * 
         * Example 1:
         * 
         * 
         * Input: head = [1,2,3,4,5]
         * Output: [5,4,3,2,1]
         * Example 2:
         * 
         * 
         * Input: head = [1,2]
         * Output: [2,1]
         * Example 3:
         * 
         * Input: head = []
         * Output: []
         * 
         * 
         * Constraints:
         * 
         * The number of nodes in the list is the range [0, 5000].
         * -5000 <= Node.val <= 5000
         * 
         * 
         * Follow up: A linked list can be reversed either iteratively or recursively.
         * Could you implement both?
         * 
         * 
         */
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        head = previous;
        System.out.println(head.val);
        return head;
    }

    // call from main entry point program
    public static void runProblem() {
        LinkedList myList = new LinkedList(2);
        myList.addTail(5);
        myList.addTail(10);
        myList.addTail(15);
        myList.addTail(5);

        myList.printAndTraverse();
        ListNode myReverseNode = myList.reverseLinkedList(myList.getHead());

        myList.printAndTraverse(myReverseNode);

    }

}
