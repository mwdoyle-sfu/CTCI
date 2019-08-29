package Sinlgly_Linked_List;

public class LinkedList2 {
    Node head;

    // Node class
    class Node {
        int data;
        Node next;
        // constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // push: insert at front O(1)
    public void push(int new_data) {
        // create new node
        Node new_node = new Node(new_data);

        // make next of new node head
        new_node.next = head;

        // move head to point to new node
        head = new_node;
    }

    // insertAfter: inserts node after the given prev_node O(1)
    public void insertAfter(Node prev_node, int new_data) {
        // check given node is not null
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        // create new node
        Node new_node = new Node(new_data);
        // make next of new_node as next of prev_node
        new_node.next = prev_node.next;
        // make next of pre_node as new_node
        prev_node.next = new_node;
    }

    // append: insert node at end O(1) or O(n)
    public void append(int new_data) {
        // create node
        Node new_node = new Node(new_data);
        new_node.next = null;

        // if list is empty make new_node head
        if (head == null) {
            head = new Node(new_data);
            return;
        } else {
            // traverse to the last node
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            // change to next of last node
            last.next = new_node;
            return;
        }
    }

    // delete node given a key
    public void deleteNode(int key) {
        // store the head node
        Node temp = head, prev = null;

        // if head node itself holds the key
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        // search for the key to be deleted
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // if key was not present in linked list
        if (temp == null) return;

        // unlink the node from the list
        prev.next = temp.next;
    }

    // delete given position
    public void deletePos(int position) {
        // if linked list is empty
        if (head == null) return;

        // store head node
        Node temp = head;

        // if head needs to be removed
        if (position == 0) {
            head = temp.next;
            return;
        }

        // find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position; i++) {
            temp = temp.next;
        }

        // if position is more than number of nodes
        if (temp == null || temp.next == null) return;

        //Node temp->next is node to be deleted
        // store pointer
        Node next = temp.next.next;
        // unlink deleted node
        temp.next = next;
    }

    // function to print contents of linked list
    public void printList() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedList2 llist = new LinkedList2();
        // 6->NUllist
        llist.append(6);
        // 7->6->NUllist
        llist.push(7);
        // 1->7->6->NUllist
        llist.push(1);
        // 1->7->6->4->NUllist
        llist.append(4);
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();

        // delete by key
        llist.deleteNode(8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();

        // delete by position
        llist.deletePos(0);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();
    }

}





