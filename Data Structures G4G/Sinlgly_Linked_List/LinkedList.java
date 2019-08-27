package Sinlgly_Linked_List;

// Singly linked list
public class LinkedList {
    // head of list
    Node head;

    // linked list Node
    static class Node {
        int data;
        Node next;

        // constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // insert method
    public static LinkedList insert(LinkedList list, int data) {
        // create new node
        Node new_node = new Node(data);
        new_node.next = null;

        // if list is empty new node is head
        if(list.head == null) {
            list.head = new_node;
        } else {
            // traverse to last node and insert
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }

        // return the list by the head
        return list;
    }

    // delete by key
    public static LinkedList deleteByKey(LinkedList list, int key) {
        Node currNode = list.head, prev = null;

        // case 1: if head is node to be deleted
        if (currNode != null && currNode.data == key) {
            // change head
            list.head = currNode.next;

            //display message
            System.out.println("\n" + key + " found and deleted");

            // return updated list
            return list;

        }

        // case 2: key is somewhere other than head
        while (currNode != null && currNode.data != key) {
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {
            // unlink current node from linked list
            prev.next = currNode.next;

            // display message
            System.out.println("\n" + key + " found and deleted");
        }

        // case 3: the key is not present
        if (currNode == null) {
            System.out.println("\n" + key + " not found");
        }

        return list;
    }

    // method to print the linked list
    public static void printList(LinkedList list) {
        Node currNode = list.head;
        System.out.print("LinkedList: ");

        // traverse the list printing the node
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {

        // start with the empty list
        LinkedList list = new LinkedList();

        list = insert(list, 1);
        list = insert(list, 2);

        printList(list);

        deleteByKey(list, 1);

        printList(list);
    }
}
