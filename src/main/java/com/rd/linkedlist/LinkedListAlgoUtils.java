package com.rd.linkedlist;

public class LinkedListAlgoUtils {

    /**
     * Brute Force approach of traversing through a given linked list
     * and finding the middle element
     * This requires two traversals
     * @param source linked list to operate on
     * @return middle element of the linked list
     */
    public static Integer printMiddleOfLLUsingBruteForce(MyLinkedList ll){
        int count = 0;
        if(ll.getHead() == null){
            return null;
        }
        SinglyLLNode temp = ll.getHead();

        while(temp!=null){
            count++;
            temp = temp.next;
        }

        SinglyLLNode middle = ll.getHead();
        for(int i=0; i < count/2; i++){
            middle = middle.next;
        }

        return middle.data;
    }

    /**
     *
     * @param source linked list to operate on
     * @return middle element of the linked list
     */
    public static Integer printMiddleOfLLUsingTwoPointerTechnique(MyLinkedList ll){
        if(ll.getHead() == null){
            return null;
        }
        SinglyLLNode slow = ll.getHead();
        SinglyLLNode fast = ll.getHead();
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
