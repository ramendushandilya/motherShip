package datastructures.linkedList.singleLinkList;


/**
 * @author rams0516
 *         Date: 5/3/2017
 *         Time: 1:18 PM
 */
public class LinkListImpl {
    Node head;

    LinkListImpl() {
        head = null;
    }

    /**
     * Inserts Node in the beginning of the list
     * @param data
     * @return
     */
    public Node insertNodeAtBeginning(int data) {
        Node node = new Node(data);
        node.setNext(head);
        head = node;
        return head;
    }

    /**
     * show the contents of the list
     */
    public void showList(Node head) {
        Node cursor = head;
        while (cursor != null) {
            System.out.print(cursor.getData() + "->>");
            cursor = cursor.getNext();
        }
        System.out.println("NULL");
    }

    /**
     * Get the nth node from the beginning
     * @param n
     * @return
     */
    public int getN(int n) {
        if (n < 1) {
            System.out.println("Enter 1 based index");
            return -1;
        } else {
            int pos = 0;
            Node cursor = head;
            while (pos != n - 1) {
                cursor = cursor.getNext();
                pos++;
            }
            return cursor.getData();
        }
    }

    /**
     * Return a random node reference
     * @return
     */
    public Node getReference() {
        int count = 0;
        Node ref = head;
        while(count != 2) {
            count++;
            ref = ref.getNext();
        }
        return ref;
    }

    /**
     * Remove a node from the link list to which a reference is provided, there is no reference to the head node
     */
    public void removeByReference() {
        Node reference = getReference();
        if(reference != null) {
            System.out.println("Removal of the node with data = "+reference.getData()+" initiated");
            reference.setData(reference.getNext().getData());
            reference.setNext(reference.getNext().getNext());
        }
        showList(head);
    }

    /**
     * Finds the middle element of a link list, if even numbered return the second mid element, or else the middle one
     * @return
     */
    public int findMiddleElement() {
        Node slowRef = head;
        Node fastRef = head;

        while(true) {
            slowRef = slowRef.getNext();
            fastRef = fastRef.getNext().getNext();
            if(fastRef == null) break;
            if(fastRef.getNext() == null) break;
        }
        return slowRef.getData();
    }

    /**
     * Get the Nth node from the last
     * @param n
     * @return
     */
    public int getNFromLast(int n) {
        Node fast = head;
        Node slow = head;

        int count = 0;
        while(count != n) {
            count++;
            fast = fast.getNext();
        }
        while(fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow.getData();
    }

    /**
     * Reverses a link list
     * @return
     */
    public Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = head;

        while(next != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    /**
     * Make loop in the link list
     */
    public void makeLoop() {
        Node two = head;
        two.getNext().getNext().getNext().getNext().setNext(two.getNext().getNext());
    }

    /**
     * Find loop in the link list
     */
    public void findLoop() {
        Node slow = head;
        Node fast = head;
        boolean flag = false;

        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if(slow == fast) {
                System.out.println("There is a loop present");
                flag = true;
                break;
            }
        }
        if(flag == false) {
            System.out.println("There is no loop present");
        }
    }

    /**
     * Find if a list is palindrome or not
     * @return
     */
    public boolean isPalindrome() {
        Node pivot = null;
        Node first = head;
        Node second = head;
        int flag = 0;

        while(second != null && second.getNext() != null) {
            first = first.getNext();
            second = second.getNext().getNext();
            pivot = first;

            if(second == null) {
                flag = 1; // Even number of nodes contained
            }
        }
        if(flag == 1) {
            pivot.setNext(reverseList(pivot.getNext()));
            first = head;
            second = pivot.getNext();

            while(second != null) {
                if(second.getData() != first.getData()) {
                    //Reconstruct list
                    return false;
                }
                first = first.getNext();
                second = second.getNext();
            }
            return true;
        } else {
            pivot.getNext().setNext(reverseList(pivot.getNext().getNext()));
            first = head;
            second = pivot.getNext().getNext();
            while(second != null) {
                if(second.getData() != first.getData()) {
                    //Reconstruct list
                    return false;
                }
                first = first.getNext();
                second = second.getNext();
            }
            return true;
        }
    }

    /**
     * Write a recursive function treeToList(Node root) that takes an ordered binary tree and rearranges the internal
     * pointers to make a circular doubly linked list out of the tree nodes. The”previous” pointers should be stored
     * in the “small” field and the “next” pointers should be stored in the “large” field. The list should be arranged
     * so that the nodes are in increasing order. Return the head pointer to the new list.
     * @param root
     */
    public void treeToList(Node root) {
        //TODO
    }

    /**
     * Clone a link list which has next and an arbitrary pointer
     * @return
     */
    public Node cloneListWithRandomReference() {
        /**
         * Make copy of node 1 between node 1 and 2, and so on for the node N make it's copy between Node n and the null
         * space. Set the arbitrary link like current.getNext().setArbit(current.getArbit().getNext());
         * At the end of it all, segregate Original and clone nodes and build the two lists, at last return the head to
         * clone node.
         */
        return null;
    }

    /**
     * Insert a node in an already sorted array
     * @param data
     */
    public void insertIntoSortedList(int data) {
        Node node = new Node(data);
        Node previous = null;
        Node current = head;
        if(head == null) {
            head = node;
        }
        while(current.getData() < data) {
            previous = current;
            current = current.getNext();
            if(current == null) {
                break;
            }
        }
        previous.setNext(node);
        node.setNext(current);
    }

    /**
     * Find the intersection point of two linked lists
     * @param listOne
     * @param listTwo
     */
    public void findIntersection(Node listOne, Node listTwo) {
        int countOne = 0;
        int countTwo = 0;
        int difference;
        Node cursorOne = listOne;
        Node cursorTwo = listTwo;
        while(cursorOne != null) {
            countOne++;
            cursorOne = cursorOne.getNext();
        }
        while(cursorTwo != null) {
            countTwo++;
            cursorTwo = cursorTwo.getNext();
        }

        if(countOne > countTwo) {
            cursorOne = listOne;
            cursorTwo = listTwo;
            difference = countOne-countTwo;
            while(difference != 0) {
                difference = difference - 1;
                cursorOne = cursorOne.getNext();
            }
            intersectionHelper(cursorOne, cursorTwo);
        } else if(countOne < countTwo){
            cursorOne = listOne;
            cursorTwo = listTwo;
            difference = countTwo-countOne;
            while(difference != 0) {
                difference = difference - 1;
                cursorTwo = cursorTwo.getNext();
            }
            intersectionHelper(cursorOne, cursorTwo);
        } else {
            cursorOne = listOne;
            cursorTwo = listTwo;
            intersectionHelper(cursorOne, cursorTwo);
        }
    }

    public void intersectionHelper(Node cursorOne, Node cursorTwo) {
        while (cursorOne != null) {
            if(cursorOne == cursorTwo) {
                System.out.println("The point of intersection is = "+cursorOne.getData());
                break;
            }
            cursorOne = cursorOne.getNext();
            cursorTwo = cursorTwo.getNext();
        }
    }

    /**
     * Print the link list in reverse using recursion
     * @param iterator
     */
    public void printRev(Node iterator) {
        if(iterator != null) {
            printRev(iterator.getNext());
            System.out.print(iterator.getData()+" - ");
        }
    }

    /**
     * Remove the duplicate elements in a sorted increasing array
     */
    public void removeDupSortedArray() {
        Node current = head;
        while(current.getNext() != null) {
            if(current.getNext().getData() == current.getData()) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
    }

    /**
     * Remove duplicate elements in a array which is not sorted
     */
    public void removeDupUnsorted() {
       //TODO
    }

    /**
     * Split a circular link list into two halves
     */
    public void splitCircularList() {
        //TODO Find the mid node of the list and make loops using appropriate node references, easy
    }

    /**
     * Move the last node of link list to the first position
     */
    public void moveLastNodeToFirst() {
        if(head == null || head.getNext() == null) {
            return;
        }
        Node curr = head;
        Node prev = head;
        while(curr.getNext() != null) {
            prev = curr;
            curr = curr.getNext();
        }
        prev.setNext(null);
        curr.setNext(head);
        head = curr;
    }

    /**
     * Pairwise swap of elements in linked list
     */
    public void pairWiseSwap() {
        Node curr = head;
        while(curr != null && curr.getNext() != null) {
            int temp = curr.getData();
            curr.setData(curr.getNext().getData());
            curr.getNext().setData(temp);
            curr = curr.getNext().getNext();
        }
    }

    /**
     * Return the intersection of two sorted linked lists
     * @param listOne
     * @param listTwo
     * @return
     */
    public Node intersectionSortedLinkedLists(Node listOne, Node listTwo) {
        Node head = null;
        Node guard = null;
        Node tether = null;
        Node currOne = listOne;
        Node currTwo = listTwo;

        while(currOne != null && currTwo != null) {
            if(currOne.getData() == currTwo.getData()) {
                guard = new Node(currOne.getData());
                if(head == null) {
                    head = guard;
                    tether = head;
                } else {
                    tether.setNext(guard);
                    tether = tether.getNext();
                }
                currOne = currOne.getNext();
                currTwo = currTwo.getNext();
            } else if(currOne.getData() < currTwo.getData()) {
                currOne = currOne.getNext();
            } else {
                currTwo = currTwo.getNext();
            }
        }
        guard.setNext(null);
        return head;
    }

    /**
     * Delete alternate nodes in a linked list
     */
    public void deleteAlternateNodes() {
        Node roam = head;
        while(roam != null && roam.getNext() != null) {
            roam.setNext(roam.getNext().getNext());
            roam = roam.getNext();
        }
    }

    /**
     * Split a link list in alternating fashion
     */
    public void alternatingSplit() {
        LinkListImpl listOne = new LinkListImpl();
        LinkListImpl listTwo = new LinkListImpl();
        int flag = 0;
        Node cur = head;
        while(cur != null) {
            if(flag == 0) {
                listOne.insertNodeAtBeginning(cur.getData());
                flag = 1;
                cur = cur.getNext();
            } else {
                listTwo.insertNodeAtBeginning(cur.getData());
                flag = 0;
                cur = cur.getNext();
            }
        }
        System.out.println("List one");
        showList(reverseList(listOne.head));
        System.out.println("List two");
        showList(reverseList(listTwo.head));
    }
}