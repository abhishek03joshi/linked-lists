package linkedList;

public class CircularDoubleLinkedListMain {
    public static void main(String[] args) {
        CircularDoubleLinkedList list = new CircularDoubleLinkedList();
        list.createDoubleCircularLinkedList(5);
        System.out.println("List Now: ");
        list.traverseDoublCircularLinkedList();
        list.insertInDoubleCircularLinkedList(10, 1);
        System.out.println("List Now: ");
        list.traverseDoublCircularLinkedList();
        list.insertInDoubleCircularLinkedList(20, 2);
        System.out.println("List Now: ");
        list.traverseDoublCircularLinkedList();
        list.insertInDoubleCircularLinkedList(30, 2);
        System.out.println("List Now: ");
        list.traverseDoublCircularLinkedList();
        list.insertInDoubleCircularLinkedList(40, 2);
        System.out.println("List Now: ");
        list.traverseDoublCircularLinkedList();

        System.out.println("List Now: ");
        list.traverseDoublCircularLinkedList();

        list.traverseDoubleLinkedListReverse();
        list.printHeadUsingTail();


        System.out.println("\nSearching the node having value 40: ");
        list.searchNode(40);

        System.out.println("\nSearching the node having value 200: ");
        list.searchNode(200);


        System.out.println("\n\nDeleting the node having location = 0: ");
        System.out.println("Before Deletion...");
        list.traverseDoublCircularLinkedList();
        list.deleteNode(0);
        System.out.println("After Deletion...");
        list.traverseDoublCircularLinkedList();

        System.out.println("\n\nDeleting the node having location = 3: ");
        System.out.println("Before Deletion...");
        list.traverseDoublCircularLinkedList();
        list.deleteNode(3);
        System.out.println("After Deletion...");
        list.traverseDoublCircularLinkedList();

        System.out.println("\n\nDeleting the node having location = 20: ");
        System.out.println("Before Deletion...");
        list.traverseDoublCircularLinkedList();
        list.deleteNode(20);
        System.out.println("After Deletion...");
        list.traverseDoublCircularLinkedList();


        list.deleteCircularDoubleLinkedList();
        list.traverseDoublCircularLinkedList();
    }
}
