package com.rd.linkedlist;

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

    }
}
