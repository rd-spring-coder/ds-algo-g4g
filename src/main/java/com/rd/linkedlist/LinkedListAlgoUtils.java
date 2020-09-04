package com.rd.linkedlist;

import org.apache.commons.lang.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListAlgoUtils {

//    private static final Logger LOG = LoggerFactory.getLogger(LinkedListAlgoUtils.class.getName());

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
        for( int i = 1; i < lengthOfLL-nthNode+1; i++){
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
            if(first!=null)
                second = second.next;
        }
        return second.data;
    }

    /**
     *
     * @param head head pointer of the linked list
     * @return reversed linked list with head pointed to the last element of the provided head linked list
     * using brute force technique
     */
    public static MyLinkedList reverseUsingBruteForceIterative(SinglyLLNode head){
        List<Integer> auxList = new ArrayList<>();
        SinglyLLNode current = head;

        if(current == null){
            return null;
        }

        MyLinkedList reversedLL = new MyLinkedList();
        while(current!=null){
            auxList.add(current.data);
            current = current.next;
        }

        for(int i = auxList.size()-1; i>=0; i--){
            reversedLL.insertAtEnd(auxList.get(i));
        }
        return reversedLL;
    }

    /**
     *
     * @param head head pointer of the linked list
     * @return reversed linked list with head pointed to the last element of the provided head linked list
     * using next, prev and current pointers
     */
    public static SinglyLLNode reverseUsingEfficientPointerTechniqueIterative(SinglyLLNode head){
        SinglyLLNode current = head;

        if(current == null){
            return null;
        }

        SinglyLLNode prev = null;

        while(current!=null){
            SinglyLLNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    /**
     *
     * @param head - pointer to the next node
     * @return new head after reversing the linked list
     */
    public static SinglyLLNode recursiveReverseFromEnd(SinglyLLNode head){
        if(head == null || head.next == null){
            return head;
        }

        SinglyLLNode rest_head = recursiveReverseFromEnd(head.next);
        SinglyLLNode rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }

    /**
     *
     * @param current - pointer to the next head
     * @param prev - pointer to the prev node of head
     * @return new head after reversing the linked list
     */
    public static SinglyLLNode recursiveReverseFromBeginning(SinglyLLNode current, SinglyLLNode prev){
        if(current == null){
            return prev;
        }

        SinglyLLNode next = current.next;
        current.next = prev;
        return recursiveReverseFromBeginning(next, current);
    }

//    public static SinglyLLNode reverseInGroupsOfSizeK(SinglyLLNode head, int k, int iterationCnt){
//
//        SinglyLLNode nextHead = head;
//        SinglyLLNode current = head;
//        SinglyLLNode reversedHead = null;
//        SinglyLLNode prevNode = null;
//
//        int i = 1;
//        while(current!=null && i < k){
//            SinglyLLNode nextNode = current.next;
//            if(i == k-1){
//                nextHead = nextNode.next;
//            }else {
//                prevNode = current;
//                nextNode.next = prevNode;
//                current = nextNode;
//            }
//
//
//            if(iterationCnt == 0){
//                reversedHead = current;
//            }
//            i++;
//        }
//
//        reverseInGroupsOfSizeK(nextHead, k, iterationCnt++);
//
//        return reversedHead;
//    }

    /**
     *
     * @param head - current head pointer
     * @param k - group size
     * @return - head of the reversed linked list in groups of size k
     */
    public static SinglyLLNode recursivelyReverseInGroupsOfSizeK(SinglyLLNode head, int k){
        SinglyLLNode current = head;
        SinglyLLNode prev = null;
        SinglyLLNode next = null;
        int count = 0;

        while(current != null && count < k){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(next!=null){
            head.next = recursivelyReverseInGroupsOfSizeK(next, k);
        }

        return prev;
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

    /**
     *
     * @param temp current pointer
     * @return String representation of nodes of the linked list starting from head
     * e.g. 10-->20-->30-->40-->50
     */
    public static String printNodes(SinglyLLNode temp){
        StringBuilder builder = new StringBuilder();
        if(temp == null)
            return null;
        while (temp != null) {
            if (temp.next != null) {
                builder.append(temp.data).append("-->");
            } else {
                builder.append(temp.data);
            }
            temp = temp.next;
        }
        return builder.toString();
    }

    /**
     *
     * @param head head of the linked list
     * @return last node of the linked list
     */
    public static SinglyLLNode getLastNode(SinglyLLNode head){
        SinglyLLNode temp = head;
        while(temp!=null){
            temp = temp.next;
            if(temp.next==null){
                return temp;
            }
        }
        return null;
    }

    /**
     *
     * @param linkedList linkedlist to use for creating a dummy linked list with cycle
     * @return cyclic linked list
     */
    public static MyLinkedList createCyclicLinkedList(MyLinkedList linkedList) {
        MyLinkedList floydCycleDetectionList = (MyLinkedList) SerializationUtils.clone(linkedList);
        SinglyLLNode lastNode = getLastNode(floydCycleDetectionList.getHead());
        //Create a cycle here
        lastNode.next = floydCycleDetectionList.getHead().next.next;
        return floydCycleDetectionList;
    }

    /**
     *
     * @param head head pointer of the linked list
     * @return true if cycle exists else false
     */
    public static boolean floydCycleDetection( SinglyLLNode head){

        SinglyLLNode slow = head;
        SinglyLLNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param head head pointer of the linked list
     */
    public static void detectAndRemoveLoop( SinglyLLNode head){
        Set<SinglyLLNode> nonCyclicSet = new HashSet<>();
        SinglyLLNode current = head;
        while(current!=null){
            if(nonCyclicSet.contains(current.next)){
                current.next = null;
            }
            nonCyclicSet.add(current);
            current = current.next;
        }
    }

    /**
     *
     * @param head head pointer of the linked list
     */
    public static void detectAndRemoveLoopUsingFloydAlgorithm( SinglyLLNode head){
        SinglyLLNode slow = head;
        SinglyLLNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(slow!=fast){
            return;
        }
        slow = head;
        while(slow.next != fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    /**
     * The trick here is to copy next nodes data into current node and replace reference of next node to point to its next node
     * @param nodeToBeDeleted reference of the node to be deleted
     */
    public static void deleteNodeExceptTail(SinglyLLNode nodeToBeDeleted){
        nodeToBeDeleted.data = nodeToBeDeleted.next.data;
        nodeToBeDeleted.next = nodeToBeDeleted.next.next;
    }

    /**
     *
     * @param head head pointer of the original list
     * @return head pointer of the segregated linked list
     */
    public static SinglyLLNode segregateEvenOdd(SinglyLLNode head){
        SinglyLLNode evenStart = null;
        SinglyLLNode evenEnd = null;
        SinglyLLNode oddStart = null;
        SinglyLLNode oddEnd = null;

        for(SinglyLLNode current = head; current!=null; current = current.next){
            int data = current.data;
            if(data % 2 == 0){
                if(evenStart == null){
                    evenStart = current;
                    evenEnd = evenStart;
                }else{
                    evenEnd.next = current;
                    evenEnd =   evenEnd.next;
                }
//                setStartEnd(evenStart, evenEnd, current);
            }else{
                if(oddStart == null){
                    oddStart = current;
                    oddEnd = oddStart;
                }else{
                    oddEnd.next = current;
                    oddEnd =   oddEnd.next;
                }
//                setStartEnd(oddStart, oddEnd, current);
            }
        }

        if(evenStart == null || oddStart == null){
            return head;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }

    //For some reason, this refactoring doesn't work, Will investigate later
    private static void setStartEnd(SinglyLLNode start, SinglyLLNode end, SinglyLLNode current) {
        if(start == null){
            start = current;
            end = start;
        }else{
            end.next = current;
            end =   end.next;
        }
    }
}
