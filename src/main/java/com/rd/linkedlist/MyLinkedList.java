package com.rd.linkedlist;

public class MyLinkedList {

    SinglyLLNode head;

    public void insertAtBeginning(int data){
        SinglyLLNode newNode = new SinglyLLNode(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

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

    public String printNodes(){
        SinglyLLNode temp = head;
        StringBuilder builder = new StringBuilder();
        if(head == null)
            return null;
        while (temp != null) {
            if (temp.next != null) {
                builder.append(temp.data + "-->");
            } else {
                builder.append(temp.data);
            }
            temp = temp.next;
        }
        return builder.toString();
    }

    public SinglyLLNode getHead(){
        return head;
    }
}
