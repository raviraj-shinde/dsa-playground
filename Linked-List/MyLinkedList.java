
//You can consider it as a API Class so therefore the head and tail are static
//you can use outside this class as  MyLinkedList ll = new MyLinkedList();

import java.util.logging.Handler;

public class MyLinkedList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    static Node head = null;
    static Node tail = null;
    static int size = 0;

    public static boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public static void addFirst(int data) { // O(1)
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
            return;
        }

        // shifting head pointer
        node.next = head;
        head = node;
    }

    public static void addLast(int data) { // O(1)
        Node node = new Node(data);
        node.next = null;

        if (head == null) {
            head = tail = node;
            return;
        }

        // shifting tail pointer
        tail.next = node;
        tail = node;
    }

    public static void printLinkedList() { // O(n)

        if (head == null) {
            System.out.println("Head null");
            return;
        }
        Node node = head;
        while (node != null) {
            System.out.print(" -> " + node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void add(int index, int data) { // O(n)
        Node newNode = new Node(data);
        Node temp = head;

        if (head == null) {
            System.out.println("List empty");
            return;
        }

        int i = 0;
        while (i < index - 1 && temp != null) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void removeFirst() { //O(1)
        if (head == null) {
            System.out.println("List empty");
            return;
        }

        head = head.next;
        size--;
    }

    public static void removeLast() { //O(n)
        if (isEmpty()) return;
        
    // Case 1: Only one node
    if (head == tail) {
        head = tail = null;
    } else {
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;  // disconnect last node
        tail = temp;       // update tail
    }

    size--;
    }

    public static void removeAt(int idx){ //O(n)
        if (isEmpty() || 0 == idx || idx == size) return;
       
        Node prev = head;
        int i = 0;

        while (i < idx - 1 && i <= size) {
            prev = prev.next;
            i++;
        }   

        Node currNext = prev.next;
        prev.next = currNext.next;
        size--;

    }
 
    public static int recursiveSearch(int key){ //O(n)
        return recursiveHelper(head, key, 0);
    }

    public static int recursiveHelper(Node node, int key, int idx){
        if (node.data == key) return idx;
        if (idx == size - 1) return -1;

        idx++;
        return recursiveHelper(node.next, key, idx);
    }

    //Most Important  ********************** <(-_-)> ***************************
    public static void reverseLinkedList(){ //O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
        next = curr.next;    // Save next node
        curr.next = prev;    // Reverse the link
        prev = curr;         // Move prev to curr
        curr = next;         // Move curr to next
        }
        
        head = prev;         // Update head to new front
    }

    //Slow-fast Approach  - make slow mid
    public static findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; //increase by 1 step
            fast = fast.next.next; //increase by 2 step
        }

        return slow; //gets here mid
    }


    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        addFirst(1);
        addLast(99999);
        addFirst(11111);
        addLast(90090);
        add(1, 69);

        printLinkedList(); // Output: -> 11111 -> 69 -> 1 -> 99999 -> 90090
        System.out.println(size);

        removeFirst();
        removeLast();
        printLinkedList(); // Output: -> 69 -> 1 -> 99999
        System.out.println(size);

        removeAt(1);
        printLinkedList();

        addFirst(58);
        addFirst(581);
        printLinkedList();
        System.out.println(size + " || " + recursiveSearch(99999));

        reverseLinkedList();
        printLinkedList();
    }
}
