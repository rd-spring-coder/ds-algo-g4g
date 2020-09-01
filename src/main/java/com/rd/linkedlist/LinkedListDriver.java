package com.rd.linkedlist;

import org.apache.commons.lang.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class LinkedListDriver {

    private static final Logger LOG = LoggerFactory.getLogger(LinkedListDriver.class.getName());

    public static void main(String[] args) throws CloneNotSupportedException {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insertAtBeginning(50);
        linkedList.insertAtBeginning(40);
        linkedList.insertAtBeginning(30);
        linkedList.insertAtBeginning(20);
        linkedList.insertAtBeginning(10);

        LOG.info("Nodes of the LL : {} ", linkedList.printNodes());

        LOG.info("---------------Middle Node of the Linked List [START]---------------");
        LOG.info("Middle of LL - Brute Force: {}",LinkedListAlgoUtils.printMiddleOfLLUsingBruteForce(linkedList));
        LOG.info("Middle of LL - Two Pointer Technique: {}", LinkedListAlgoUtils.printMiddleOfLLUsingTwoPointerTechnique(linkedList));
        LOG.info("---------------Middle Node of the Linked List [END]---------------");

        LOG.info("---------------Nth Node of the Linked List from the end [START]---------------");
        Random random = new Random();
        int nthNode = random.nextInt(LinkedListAlgoUtils.getLengthOfLL(linkedList.getHead()));
        LOG.info("nth node : {}", nthNode);
        LOG.info("Nth Node of the LL from the end - Brute Force: {}", LinkedListAlgoUtils.nthNodeOfLLUsingBruteForce(linkedList.getHead(),nthNode));
        LOG.info("Nth Node of the LL from the end - Two Pointer Technique: {}", LinkedListAlgoUtils.nthNodeOfLLUsingTwoPointerTechnique(linkedList.getHead(),nthNode));
        LOG.info("---------------Nth Node of the Linked List from the end [END]---------------");

        LOG.info("---------------Original Linked list [START]---------------");
        LOG.info(linkedList.printNodes());
        LOG.info("---------------Original Linked list [END]---------------");
        LOG.info("---------------Reverse of a linked list Brute Force[START]---------------");
        MyLinkedList reversed = LinkedListAlgoUtils.reverseUsingBruteForceIterative(linkedList.getHead());
        LOG.info("Head data of reversed ll : {}", reversed.getHead().data);
        LOG.info(reversed.printNodes());
        LOG.info("---------------Reverse of a linked list [END]]---------------");

        LOG.info("---------------Original Linked list [START]---------------");
        LOG.info(linkedList.printNodes());
        LOG.info("---------------Original Linked list [END]---------------");
        LOG.info("---------------Reverse of a linked list Efficient Iteration[START]---------------");
        MyLinkedList tempEfficientLinkedList = (MyLinkedList) SerializationUtils.clone(linkedList);
        SinglyLLNode reversedEfficientPtrTechHead = LinkedListAlgoUtils.reverseUsingEfficientPointerTechniqueIterative(tempEfficientLinkedList.getHead());
        LOG.info("Head data of reversed ll : {}", reversedEfficientPtrTechHead.data);
        LOG.info(LinkedListAlgoUtils.printNodes(reversedEfficientPtrTechHead));
        LOG.info("---------------Reverse of a linked list Efficient Iteration[END]]---------------");

        LOG.info("---------------Original Linked list [START]---------------");
        LOG.info(linkedList.printNodes());
        LOG.info("---------------Original Linked list [END]---------------");
        LOG.info("---------------Recursive Reverse of a linked list From End[START]---------------");
        MyLinkedList tempFromEndLinkedList = (MyLinkedList) SerializationUtils.clone(linkedList);
        SinglyLLNode reversedHeadFromEnd = LinkedListAlgoUtils.recursiveReverseFromEnd(tempFromEndLinkedList.getHead());
        LOG.info("Head data of reversed ll : {}", reversedHeadFromEnd.data);
        LOG.info(LinkedListAlgoUtils.printNodes(reversedHeadFromEnd));
        LOG.info("---------------Recursive Reverse of a linked list From End[END]---------------");

        LOG.info("---------------Original Linked list [START]---------------");
        LOG.info(linkedList.printNodes());
        LOG.info("---------------Original Linked list [END]---------------");
        LOG.info("---------------Recursive Reverse of a linked list From End[START]---------------");
        MyLinkedList tempFromBeginningLinkedList = (MyLinkedList) SerializationUtils.clone(linkedList);
        SinglyLLNode reversedHeadFromBeginning = LinkedListAlgoUtils.recursiveReverseFromBeginning(tempFromBeginningLinkedList.getHead(), null);
        LOG.info("Head data of reversed ll : {}", reversedHeadFromBeginning.data);
        LOG.info(LinkedListAlgoUtils.printNodes(reversedHeadFromBeginning));
        LOG.info("---------------Recursive Reverse of a linked list From End[END]---------------");
    }
}
