package com.rd.linkedlist;

import org.apache.commons.lang.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class LinkedListDriver {

    private static final Logger LOG = LoggerFactory.getLogger(LinkedListDriver.class.getName());

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.insertAtBeginning(50);
        linkedList.insertAtBeginning(40);
        linkedList.insertAtBeginning(30);
        linkedList.insertAtBeginning(20);
        linkedList.insertAtBeginning(10);

        MyLinkedList evenOddLinkedList = new MyLinkedList();
        evenOddLinkedList.insertAtBeginning(5);
        evenOddLinkedList.insertAtBeginning(4);
        evenOddLinkedList.insertAtBeginning(3);
        evenOddLinkedList.insertAtBeginning(2);
        evenOddLinkedList.insertAtBeginning(1);

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

        LOG.info("---------------Original Linked list [START]---------------");
        LOG.info(linkedList.printNodes());
        LOG.info("---------------Original Linked list [END]---------------");
        LOG.info("---------------Recursive Reverse of a linked list in groups of size K[START]---------------");
        MyLinkedList revGrpKList = (MyLinkedList) SerializationUtils.clone(linkedList);
        SinglyLLNode revGrpKHead = LinkedListAlgoUtils.recursivelyReverseInGroupsOfSizeK(revGrpKList.getHead(), 3);
        LOG.info("Head data of reversed ll : {}", revGrpKHead.data);
        LOG.info("Reversed Linked List : {}", LinkedListAlgoUtils.printNodes(revGrpKHead));
        LOG.info("---------------Recursive Reverse of a linked list in groups of size K[END]---------------");

        LOG.info("---------------FLOYD CYCLE DETECTION ALGORITHM [START]---------------");
        MyLinkedList floydCycleDetectionList = LinkedListAlgoUtils.createCyclicLinkedList(linkedList);
        boolean cyclic = LinkedListAlgoUtils.floydCycleDetection(floydCycleDetectionList.getHead());
        LOG.info("Cycle exists : {}", cyclic);
        LOG.info("---------------FLOYD CYCLE DETECTION ALGORITHM [END]---------------");

        LOG.info("---------------DETECT AND REMOVE LOOP [START]---------------");
        MyLinkedList detectAndRemoveLoopList = LinkedListAlgoUtils.createCyclicLinkedList(linkedList);
        LinkedListAlgoUtils.detectAndRemoveLoop(detectAndRemoveLoopList.getHead());
        LOG.info("---------------REMOVED LOOP, PRINTING NODES---------------");
        LOG.info(detectAndRemoveLoopList.printNodes());
        LOG.info("---------------DETECT AND REMOVE LOOP [END]---------------");

        LOG.info("---------------DETECT AND REMOVE LOOP USING FLOYD'S ALGORITHM[START]---------------");
        MyLinkedList detectAndRemoveLoopFloydList = LinkedListAlgoUtils.createCyclicLinkedList(linkedList);
        LinkedListAlgoUtils.detectAndRemoveLoopUsingFloydAlgorithm(detectAndRemoveLoopFloydList.getHead());
        LOG.info("---------------REMOVED LOOP, PRINTING NODES---------------");
        LOG.info(detectAndRemoveLoopFloydList.printNodes());
        LOG.info("---------------DETECT AND REMOVE LOOP USING FLOYD'S ALGORITHM[END]---------------");

        LOG.info("---------------DELETE NODE EXCEPT TAIL[START]---------------");
        MyLinkedList deleteNodeExceptTailList =  (MyLinkedList) SerializationUtils.clone(linkedList);
        LinkedListAlgoUtils.deleteNodeExceptTail(deleteNodeExceptTailList.getHead().next.next);
        LOG.info("---------------DELETED NODE, PRINTING LIST NODES---------------");
        LOG.info(deleteNodeExceptTailList.printNodes());
        LOG.info("---------------DELETE NODE EXCEPT TAIL[END]---------------");

        LOG.info("---------------SEGREGATE EVEN ODD NODES[START]---------------");
        MyLinkedList evenOddSegregatedList =  (MyLinkedList) SerializationUtils.clone(evenOddLinkedList);
        SinglyLLNode headNodeAfterSegregation = LinkedListAlgoUtils.segregateEvenOdd(evenOddSegregatedList.getHead());
        LOG.info("---------------SEGREGATED NODES, PRINTING LIST NODES---------------");
        LOG.info(LinkedListAlgoUtils.printNodes(headNodeAfterSegregation));
        LOG.info("---------------SEGREGATE EVEN ODD NODES[END]---------------");

    }
}
