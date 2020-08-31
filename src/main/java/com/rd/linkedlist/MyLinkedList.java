package com.rd.linkedlist;

import java.util.LinkedList;

/**
 * @author riteshdharmatti
 * Custom data structure for linked list
 */
public class MyLinkedList {

    SinglyLLNode head;

    /**
     * Insert a node at the beginning of the linked list
     * @param data
     */
    public void insertAtBeginning(int data){
        SinglyLLNode newNode = new SinglyLLNode(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    /**
     * Insert a node at the end of the linked list
     * @param data
     */
    public void insertAtEnd(int data){
        SinglyLLNode newNode = new SinglyLLNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        SinglyLLNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    /**
     *
     * @return String representation of nodes of the linked list starting from head
     * e.g. 10-->20-->30-->40-->50
     */
    public String printNodes(){
        return LinkedListAlgoUtils.printNodes(head);
    }

    /**
     *
     * @return head node of the linked list
     */
    public SinglyLLNode getHead(){
        return head;
    }
}
