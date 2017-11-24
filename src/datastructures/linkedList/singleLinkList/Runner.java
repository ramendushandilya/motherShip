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
        //linkOne.showList(linkOne.head);
        System.out.print(linkOne.getN(3));
    }
}