package com.rd.linkedlist;

public class LinkedListDriver {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insertAtBeginning(50);
        linkedList.insertAtBeginning(40);
        linkedList.insertAtBeginning(30);
        linkedList.insertAtBeginning(20);
        linkedList.insertAtBeginning(10);

        linkedList.printNodes();

        System.out.println("Middle of LL - Brute Force: "+LinkedListAlgoUtils.printMiddleOfLLUsingBruteForce(linkedList));
        System.out.println("Middle of LL - Two Pointer Technique: "+LinkedListAlgoUtils.printMiddleOfLLUsingTwoPointerTechnique(linkedList));
    }
}
