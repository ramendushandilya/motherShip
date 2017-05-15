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

        linkOne.showList();
        linkOne.printRev(linkOne.head);
    }
}