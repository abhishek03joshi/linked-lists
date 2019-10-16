package linkedList;

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.createSingleLinkedList(5);
        list.traverseLinkedList();

        list.insertInLinkedList(10,1);
        list.traverseLinkedList();

        list.insertInLinkedList(20,2);
        list.traverseLinkedList();

        list.insertInLinkedList(30,3);
        list.traverseLinkedList();

        list.insertInLinkedList(40,4);
        list.traverseLinkedList();

        System.out.println();

        System.out.println("\nSearching the node having value 40.....");
        list.searchNode(40);


        System.out.println("\nSearching the node having value 500.....");
        list.searchNode(500);


        System.out.println("\n\nDeleting the node at location = 0: ");
        System.out.println("Before Deletion:");
        list.traverseLinkedList();
        list.deleteNode(0);
        System.out.println("After Deletion:");
        list.traverseLinkedList();
        System.out.println();

        System.out.println("Deleting the node at location = 2");
        System.out.println("Before Deletion");
        list.traverseLinkedList();
        list.deleteNode(2);
        System.out.println("After Deletion");
        list.traverseLinkedList();
        System.out.println();

        System.out.println("Deleting the node at location = 100 (the last node)");
        System.out.println("Before Deletion");
        list.traverseLinkedList();
        list.deleteNode(100);
        System.out.println("After Deletion");
        list.traverseLinkedList();
        System.out.println();

        list.deleteLinkedList();
        list.traverseLinkedList();

    }
}
