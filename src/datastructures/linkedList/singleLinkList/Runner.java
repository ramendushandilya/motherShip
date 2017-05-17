package datastructures.linkedList.singleLinkList;

/**
 * @author rams0516
 *         Date: 5/3/2017
 *         Time: 1:21 PM
 */
public class Runner {
    public static void main(String[] args) {
        LinkListImpl linkOne = new LinkListImpl();

        linkOne.insertNodeAtBeginning(20);
        linkOne.insertNodeAtBeginning(3);
        linkOne.insertNodeAtBeginning(2);
        linkOne.showList(linkOne.head);

        LinkListImpl linkTwo = new LinkListImpl();
        linkTwo.insertNodeAtBeginning(22);
        linkTwo.insertNodeAtBeginning(3);
        linkTwo.insertNodeAtBeginning(2);

        linkTwo.showList(linkTwo.head);

        linkOne.isIdentical(linkOne.head, linkTwo.head);
    }
}