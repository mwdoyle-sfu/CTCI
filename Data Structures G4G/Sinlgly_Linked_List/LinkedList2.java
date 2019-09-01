package Sinlgly_Linked_List;

public class LinkedList2 {
    static Node head, head2;

    // Node class
    static class Node {
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

    // iteratively returns count of nodes in linked list
    public int ittGetCount() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // recursively returns count of nodes in linked list
    public int getCountRec(Node node) {
        // base case
        if (node == null) {
            return 0;
        }

        return 1 + getCountRec(node.next);
    }

    // wrapper over recursive function getCountRec
    public int recGetCount() {
        return getCountRec(head);
    }

    // reverse a linked list
    Node reverse(Node node) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        Node prev = null;
        Node curr = node;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    // merge sort
    Node mergeSort(Node h) {
        // outperforms quickSort/heapSort
        // Time Complexity: O(n Log n)
        // base case if head is null
        if (h == null || h.next == null) {
            return h;
        }

        // get the middle of the list
        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;
        // set the next of middle node to null
        middle.next = null;
        // apply mergeSort on left list
        Node left = mergeSort(h);
        // apply mergeSort on right list
        Node right = mergeSort(nextOfMiddle);
        // merge the left and right lists
        Node sortedList = sortedMerge(left, right);
        return sortedList;
    }

    // utility function to merge two sorted lists
    Node sortedMerge(Node a, Node b) {
        Node result = null;

        // base case
        if (a == null)
            return b;
        if (b == null)
            return a;

        // pick either a or b and recur
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    // utility function to get middle of linked list
    public static Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // swap Nodes by changing links
    public void swapNodes(int x, int y) {
        // nothing to do if x and y are the same
        if (x == y)
            return;

        // search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // search for y(keep track of prevY and CurrY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // if either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;

        // if x is not the head of the linked list
        if (prevX != null)
            prevX.next = currY;
        else // make y the new head
            head = currY;

        // if y is not the head of the linked list
        if (prevY != null)
            prevY.next = currX;
        else // make y the new head
            head = currX;

        // swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    // reverse a list of k nodes
    Node reverseK(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        // reverse first k nodes of linked list
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // next is now a pointer to the (K+1)th node
        // recursively call for the list starting from current
        // and make the rest of the list as next of first node
        if (next != head)
            head.next = reverseK(next, k);

        // prev is now head of input list
        return prev;
    }

    // detect and remove loop
    public int detectAndRemoveLoop(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // if slow and fast meet at the same point then a loop is present
            if (slow == fast) {
//                System.out.println("\n Loop detected...");
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    // utility function for detect and remove loop
    private void removeLoop(Node loop, Node curr) {
        Node ptr1 = null, ptr2 = null;

        // set a pointer to the beginning of the linked list and move it one by one
        // to find the first node which is part of the linked list
        ptr1 = curr;
        while (1 == 1) {
            // now start a pointer from loop_node and check if it ever reaches ptr2
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }

            // if ptr2 reaches ptr1 then there is a loop so break
            if (ptr2.next == ptr1)
                break;

            // if ptr2 didnt reach prt1 then try the next node after ptr1
            ptr1 = ptr1.next;
        }
        // after the end of the loop ptr2 is the last node in the loop
        // so make ptr2.next null
        ptr2.next = null;
    }

    // add the contents of two linked lists
    Node addTwoLists(Node first, Node second) {
        Node res = null;    // head of node of result list
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        while (first != null || second != null) {
            // calculate the value of next digit in result list
            // the next digit is the sum of the following
            // (i) carry
            // (ii) next digit of first list (if it exists)
            // (iii) next digit of second list (if it exists)
            sum = carry + (first != null? first.data : 0)
                    + (second != null ? second.data : 0);

            // update the carry for next calculation
            carry = (sum >= 10) ? 1 : 0;
            // update sum if it is greater than 10
            sum = sum % 10;
            // create a new node with sum as data
            temp = new Node(sum);
            // if this is the first node then set it as head of result list
            if (res == null) {
                res = temp;
            } else {    //if this is not the first node then connect it to the rest
                prev.next = temp;
            }
            // set prev for insertion
            prev = temp;
            // move first and second pointers to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
        if (carry > 0) {
            temp.next = new Node(carry);
        }

        // return head of result list
        return res;
    }

    // function to print contents of linked list
    public void printList() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
    }

    // funtion to print contents of a given linked list
    public void printGivenList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    // main
    public static void main(String[] args) {

        LinkedList2 llist = new LinkedList2();
        // insert
        test01(llist);
        // delete by key/position
        test02(llist);
        // get length
        test03(llist);
        // swap Nodes
        test04(llist);
        // merge sort
        test05(llist);
        // reverse
        test06(llist);
        // reverse in k groups
        test07(llist);
        // detect and remove a loop
        test08(llist);
        // add two numbers represented by linked lists
        test09(llist);


    }

    private static void test09(LinkedList2 llist) {
        // add two numbers represented by linked lists
        // create first list
        System.out.println("\n Create new lists: ");
        head = null;
        head = new Node(7);
        head.next = new Node(5);
        head.next.next = new Node(9);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(6);
        System.out.print("First List: ");
        llist.printGivenList(head);

        // create second list
        head2 = new Node(8);
        head2.next = new Node(4);
        System.out.print("Second List: ");
        llist.printGivenList(head2);

        /*
         * Input: List1: 7->5->9->4->6  // represents number 64957
         * List2: 8->4 //  represents number 48
         * Output: Resultant list: 5->0->0->5->6  // represents number 65005
         */

        // add results of the two lists
        Node result = llist.addTwoLists(head, head2);
        System.out.print("Resulting List: ");
        llist.printGivenList(result);
    }

    private static void test08(LinkedList2 llist) {
        // detect and remove a loop
        System.out.println("\n Create new list: ");
        head = null;
        // 10->NUllist
        llist.push(10);
        // 4->10->NUllist
        llist.push(4);
        // 15->4->10->NUllist
        llist.push(15);
        // 20->15->4->10->NUllist
        llist.push(20);
        // 50->20->15->4->10->NUllist
        llist.push(50);
        llist.printList();

        // create loop for testing
        //          ;------;
        // 50->20->15->4->10
        head.next.next.next.next.next = head.next.next;
        llist.detectAndRemoveLoop(head);

        System.out.println("\n Linked List after removing loop : ");
        llist.printList();
    }

    private static void test07(LinkedList2 llist) {
        // reverse in k groups
        System.out.println("\n Reverse list in groups of k = 3: ");
        head = llist.reverseK(head, 3);
        llist.printList();
    }

    private static void test06(LinkedList2 llist) {
        // reverse
        System.out.println("\n Reverse list: ");
        head = llist.reverse(head);
        llist.printList();
    }

    private static void test05(LinkedList2 llist) {
        // merge sort
        System.out.println("\n Merge sort: ");
        head = llist.mergeSort(head);
        llist.printList();
    }

    private static void test04(LinkedList2 llist) {
        // swap Nodes
        System.out.println("\n Swap nodes 9 and 3: ");
        llist.swapNodes(9, 3);
        llist.printList();
    }

    private static void test03(LinkedList2 llist) {
        // get counts
        System.out.print("\n Iterative: " + llist.ittGetCount());
        System.out.print("\n Recursive: " + llist.recGetCount());
    }

    private static void test02(LinkedList2 llist) {
        // delete by key
        llist.deleteNode(8);

        System.out.println("\n Delete node 8: ");
        llist.printList();

        // delete by position
        llist.deletePos(0);

        System.out.println("\n Delete position 0: ");
        llist.printList();
    }

    private static void test01(LinkedList2 llist) {
        // insert
        // 6->NUllist
        llist.append(6);
        // 7->6->NUllist
        llist.push(7);
        // 1->7->6->NUllist
        llist.push(1);
        // 1->7->6->4->NUllist
        llist.append(4);
        // 1->7->6->4->9->NUllist
        llist.append(9);
        // 1->7->6->4->9->8->NUllist
        llist.append(2);
        // 1->7->6->4->9->2->3->NUllist
        llist.append(3);
        // 1->7->8->6->4->9->8->3->NUllist
        llist.insertAfter(head.next, 8);

        System.out.println("\n Created Linked list is: ");
        llist.printList();
    }

}





