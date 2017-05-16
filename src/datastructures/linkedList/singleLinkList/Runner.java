package datastructures.linkedList.singleLinkList;

/**
 * @author rams0516
 *         Date: 5/3/2017
 *         Time: 1:21 PM
 */
public class Runner {
    public static void main(String[] args) {
        LinkListImpl linkOne = new LinkListImpl();
        linkOne.insertNodeAtBeginning(52);
        linkOne.insertNodeAtBeginning(42);
        linkOne.insertNodeAtBeginning(32);
        linkOne.insertNodeAtBeginning(22);
        linkOne.insertNodeAtBeginning(12);
        linkOne.showList(linkOne.head);
        linkOne.alternatingSplit();

        /*LinkListImpl linkTwo = new LinkListImpl();
        linkTwo.insertNodeAtBeginning(60);
        linkTwo.insertNodeAtBeginning(43);
        linkTwo.insertNodeAtBeginning(43);
        linkTwo.insertNodeAtBeginning(21);
        linkTwo.insertNodeAtBeginning(11);
        linkTwo.insertNodeAtBeginning(11);
        linkTwo.insertNodeAtBeginning(11);*/

        /*LinkListImpl linkOn = new LinkListImpl();

        linkOn.insertNodeAtBeginning(6);
        linkOn.insertNodeAtBeginning(4);
        linkOn.insertNodeAtBeginning(3);
        linkOn.insertNodeAtBeginning(2);
        linkOn.insertNodeAtBeginning(1);

        LinkListImpl linkO = new LinkListImpl();

        linkO.insertNodeAtBeginning(8);
        linkO.insertNodeAtBeginning(6);
        linkO.insertNodeAtBeginning(4);
        linkO.insertNodeAtBeginning(2);

        Node node = linkO.intersectionSortedLinkedLists(linkO.head, linkOn.head);
        linkOn.showList(node);*/
    }
}