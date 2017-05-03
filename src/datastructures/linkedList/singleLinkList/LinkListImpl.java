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
    public void showList() {
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
        showList();
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
    public Node reverseList() {
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
}