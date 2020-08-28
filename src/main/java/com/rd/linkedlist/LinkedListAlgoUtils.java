package com.rd.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListAlgoUtils {

    private static final Logger LOG = LoggerFactory.getLogger(LinkedListAlgoUtils.class.getName());

    /**
     * Brute Force approach of traversing through a given linked list
     * and finding the middle element
     * This requires two traversals
     * @param myLinkedList source linked list to operate on
     * @return middle element of the linked list
     */
    public static Integer printMiddleOfLLUsingBruteForce(MyLinkedList myLinkedList){

        if(myLinkedList.getHead() == null){
            return null;
        }

        int count = getLengthOfLL(myLinkedList.getHead());

        SinglyLLNode middle = myLinkedList.getHead();
        for(int i=0; i < count/2; i++){
            middle = middle.next;
        }

        return middle.data;
    }

    /**
     *
     * @param myLinkedList source linked list to operate on
     * @return middle element of the linked list
     */
    public static Integer printMiddleOfLLUsingTwoPointerTechnique(MyLinkedList myLinkedList){
        if(isLLEmpty(myLinkedList.getHead())){
            return null;
        }

        SinglyLLNode slow = myLinkedList.getHead();
        SinglyLLNode fast = myLinkedList.getHead();
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    /**
     *
     * @param head head pointer of the linked list
     * @param nthNode n-th node of the linked list to be found
     * @return value of n-th node of the linked list if found else null
     */
    public static Integer nthNodeOfLLUsingBruteForce(SinglyLLNode head, int nthNode){
        if(isLLEmpty(head)){
            return null;
        }
        int lengthOfLL = getLengthOfLL(head);

        if(lengthOfLL < nthNode){
            return null;
        }

        SinglyLLNode current = head;
        SinglyLLNode temp = head;
        for( int i = 0; i < lengthOfLL-nthNode+1; i++){
            temp = current;
            if(current!=null)
                current = current.next;
            else
                return null;
        }
        return temp.data;
    }

    /**
     *
     * @param head head pointer of the linked list
     * @param nthNode n-th node of the linked list to be found
     * @return value of n-th node of the linked list if found else null
     */
    public static Integer nthNodeOfLLUsingTwoPointerTechnique(SinglyLLNode head, int nthNode) {
        if(isLLEmpty(head)){
            return null;
        }
        SinglyLLNode first = head;
        for(int i = 0; i < nthNode; i++){
            first = first.next;
        }

        SinglyLLNode second = head;
        while(first != null ){
            first = first.next;
            second = second.next;
        }
        return second.data;
    }

    /**
     *
     * @param head head pointer of the linked list
     * @return number of elements in a given linked list
     */
    public static int getLengthOfLL(SinglyLLNode head){
        SinglyLLNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    /**
     *
     * @param head head pointer of the linked list
     * @return true if the linked list is not empty else false
     */
    private static boolean isLLEmpty(SinglyLLNode head){
        return head == null;
    }
}
