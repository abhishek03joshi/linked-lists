package linkedList;

import node.SingleNode;

public class CircularSingleLinkedList {

    private SingleNode head;
    private SingleNode tail;
    private int size;

    SingleNode createSingleLinkedList(int nodeValue){
        head = new SingleNode();
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        node.setNext(null);
        head = node;
        tail = node;
        size=1;
        return head;
    }



    public SingleNode getHead() { return head; }
    public void setHead(SingleNode head) { this.head = head; }

    public SingleNode getTail() { return tail; }
    public void setTail(SingleNode tail) { this.tail = tail; }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }

    public boolean existsLinkedList() {
        return head != null;
    }

    //Insert a linked list
    void insertInLinkedList (int nodeValue, int location) {
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        if(!existsLinkedList()){
            System.out.println("Linked List does not exist!!");
            return;
        } else if (location == 0) {
            node.setNext(head);
            head = node;
            tail.setNext(head);
        } else if (location >= size) {
            tail.setNext(node);
            tail = node;
            node.setNext(head);
        } else { // insert in between
            SingleNode tempNode = head;
            int index = 0;
            while( index < location - 1) {
                tempNode = tempNode.getNext();
                index++;
            }
            node.setNext(tempNode.getNext());
            tempNode.setNext(node);
        }
        size++;

    }

    //Traversing a linked list
    void traverseLinkedList(){
        if(existsLinkedList()){
            SingleNode tempNode = head;
            for(int i = 0; i < size; i++){
                System.out.print(tempNode.getValue());
                if( i != size - 1){
                    System.out.print("->");
                }
                tempNode = tempNode.getNext();
            }
            System.out.println();
        } else {
            System.out.println("\nLinked list does not exist !");
        }

    }

    //Searching a linked list
    boolean searchNode(int nodeValue){
        if(existsLinkedList()){
            SingleNode tempNode = head;
            for(int i = 0; i < size; i++){
                if(nodeValue == tempNode.getValue()){
                    System.out.print("Value " + nodeValue + " is found at index " + i + "\n");
                    return true;
                }
                tempNode = tempNode.getNext();
            }
            System.out.println("Value " + nodeValue + " does not exist in linked list");
            return false;
        }
        System.out.println("\nLinked list does not exist !");
        return false;

    }

    //Delete a node in a linked list
    public void deleteNode(int location){
        if(!existsLinkedList()){
            System.out.println("Linked list does not exist!");
        } else if (location == 0){
            if(size <= 1 || head == tail){
                head.setNext(null);
                head = tail = null;
                setSize(getSize() - 1);
                return;
            }
            head = head.getNext();
            tail.setNext(head);
            setSize(getSize() - 1);
        } else if (location >= size){
            SingleNode tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.getNext();
            }
            if (head == tempNode) {
                head.setNext(null);
                head = tail = null;
                setSize(getSize() - 1);
                return;
            }
            tempNode.setNext(head);
            tail = tempNode;
            setSize(getSize() - 1);

        } else {//insert in between
            SingleNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(tempNode.getNext().getNext());
            setSize(getSize() - 1);
        }
    }

    //Delete the entire linked list
    public void deleteLinkedList(){
        System.out.println("Deleting the entire linked list");
        if(head == null || tail == null) {
            System.out.println("Linked list is already deleted!");
        } else {
            head = null;
            tail.setNext(null);
            tail = null;
            System.out.println("Linked list deleted successfully");
        }
    }

    //Show that tail can access head
    void printHeadUsingTail(){
        if(existsLinkedList()){
            System.out.println("Printing tail");
            System.out.println(tail.getValue());

            System.out.println("Printing head using head reference");
            System.out.println(head.getValue());

            System.out.println("Printing head using tail reference");
            System.out.println(tail.getNext().getValue());

        } else {
            System.out.println("Linked list does not exist");
        }
    }

}
