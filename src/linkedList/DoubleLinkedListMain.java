package linkedList;

public class DoubleLinkedListMain {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.createDoubleLinkedList(5);
        list.traverseDoubleLinkedList();

        list.insertInDoubleLinkedList(10, 1);
        list.traverseDoubleLinkedList();

        list.insertInDoubleLinkedList(20, 2);
        list.traverseDoubleLinkedList();

        list.insertInDoubleLinkedList(30, 3);
        list.traverseDoubleLinkedList();

        list.insertInDoubleLinkedList(40, 4);
        list.traverseDoubleLinkedList();


        System.out.println("\nSearching the node having value 40: ");
        list.searchDoubleNode(40);

        System.out.println("\n\nSearching the node having value 400: ");
        list.searchDoubleNode(400);


        System.out.println("\n\nLinked List in order");
        list.traverseDoubleLinkedList();
        System.out.println("Linked List in reverse order");
        list.traverseDoubleLinkedListReverse();


        System.out.println("\n\nDeleting the node having location = 2: ");
        System.out.println("List before deletion: ");
        list.traverseDoubleLinkedList();
        list.deleteDoubleNode(2);
        System.out.println("List after deletion: ");
        list.traverseDoubleLinkedList();


        System.out.println("\n\nDeleting the node having location = 3: ");
        System.out.println("List before deletion: ");
        list.traverseDoubleLinkedList();
        list.deleteDoubleNode(3);
        System.out.println("List after deletion: ");
        list.traverseDoubleLinkedList();


        list.deleteDoubleLinkedList();
        list.traverseDoubleLinkedList();
    }
}
