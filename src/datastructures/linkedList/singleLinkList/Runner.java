package datastructures.linkedList.singleLinkList;

/**
 * @author rams0516
 *         Date: 5/3/2017
 *         Time: 1:21 PM
 */
public class Runner {
    public static void main(String[] args) {
        LinkListImpl linkOne = new LinkListImpl();

        linkOne.insertNodeAtBeginning(10);
        linkOne.insertNodeAtBeginning(8);
        linkOne.insertNodeAtBeginning(5);
        linkOne.insertNodeAtBeginning(2);
        linkOne.showList(linkOne.head);
        System.out.print("Place holder for function call");

        LinkListImpl lt = new LinkListImpl();
        lt.insertNodeAtBeginning(21);
        lt.insertNodeAtBeginning(43);
        lt.insertNodeAtBeginning(41);
        lt.insertNodeAtBeginning(21);
        lt.insertNodeAtBeginning(12);
        lt.insertNodeAtBeginning(11);
        lt.insertNodeAtBeginning(12);
        lt.removeDupUnsorted();
        lt.showList(lt.head);
    }
}