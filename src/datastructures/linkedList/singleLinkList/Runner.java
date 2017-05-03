package datastructures.linkedList.singleLinkList;

/**
 * @author rams0516
 *         Date: 5/3/2017
 *         Time: 1:21 PM
 */
public class Runner {
    public static void main(String[] args) {
        LinkListImpl linkList = new LinkListImpl();
        linkList.insertNodeAtBeginning(12);
        linkList.insertNodeAtBeginning(22);
        linkList.insertNodeAtBeginning(32);
        linkList.insertNodeAtBeginning(42);

        linkList.showList();

        System.out.println(linkList.getN(0));
        linkList.removeByReference();
    }
}