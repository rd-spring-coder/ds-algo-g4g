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

    public void printNodes(){
        SinglyLLNode temp = head;
        if(head == null)
            return;
        while(temp!=null){
            if(temp.next!=null){
                System.out.print(temp.data+"-->");
            }else {
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }

    public SinglyLLNode getHead(){
        return head;
    }
}
