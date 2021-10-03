package com.bridgelabz;

import java.util.Objects;

public class HashTable {
    HashNode[] Buckets;
    int noOfBuckets;
    int size; // no of key value pair in hash table

    public HashTable(int capacity) {
        this.noOfBuckets = capacity;
        this.Buckets = new HashNode[noOfBuckets];
        this.size = 0;
    }

    public int getBucketIndex(int key) {
        return key % noOfBuckets;
    }

    public void put(int key, String value) {

        int bucketIndex = getBucketIndex(key);

        HashNode head = Buckets[bucketIndex];               //empty bucket is replaced with head
        while (head != null) {
            if (Objects.equals(head.key, key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = Buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        Buckets[bucketIndex] = node;

    }

    public int freqChecker(String value) {
        HashNode node = Buckets[0];
        int wordFreq = 0;
        while (node != null) {
            if (node.value.equals(value)) {
                wordFreq++;
            }
            node = node.next;
        }
        return wordFreq;
    }
}
