package linkedList;

import node.DoubleNode;

public class CircularDoubleLinkedList {
    DoubleNode head;
    DoubleNode tail;
    int size;

    public DoubleNode getHead() {
        return head;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public void setTail(DoubleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Create a circular double linked list
    DoubleNode createDoubleCircularLinkedList(int nodeValue){
        head = new DoubleNode();
        DoubleNode node = new DoubleNode();
        node.setValue(nodeValue);
        head=node;
        tail=node;
        node.setNext(node);
        node.setPrev(node);
        size = 1;
        return head;
    }

    //Check existence of linked list
    boolean existsCircularDoubleLinkedList(){
        return head != null;
    }

    //Insert node in a linked list
    public void insertInDoubleCircularLinkedList(int nodeValue, int location){
        DoubleNode node = new DoubleNode();
        node.setValue(nodeValue);
        if(!existsCircularDoubleLinkedList()){
            System.out.println("No linked list exists");
        } else if (location == 0){
            node.setNext(head);
            node.setPrev(tail);
            head.setPrev(node);
            tail.setNext(head);
            head=node;
            setSize(getSize() + 1);
        } else if (location >= size - 1){ // this block is O(1) instead of O(n)
            node.setNext(head);
            node.setPrev(tail);
            tail.setNext(node);
            head.setPrev(node);
            tail=node;
            setSize(getSize() + 1);
        } else { // insert node in between
            DoubleNode tempNode = head;
            for(int i = 0; i < location - 1; i++){
                tempNode = tempNode.getNext();
                node.setPrev(tempNode);
                node.setNext(tempNode.getNext());
                tempNode.getNext().setPrev(node);
                tempNode.setNext(node);
            }
            setSize(getSize() + 1);
        }
    }

    //Traversing a circular double linked list
    public void traverseDoublCircularLinkedList(){
        if(existsCircularDoubleLinkedList()){
            System.out.println("Linked list correct order : \n");
            DoubleNode tempNode = head;
            for(int i = 0; i < size; i++){
                System.out.print(tempNode.getValue());
                if(i != size - 1){
                    System.out.print("->");
                }
                tempNode = tempNode.getNext();
            }
        } else {
            System.out.println("Linked list does not exist");
        }
        System.out.println("\n");
    }

    //Traverse Linked list in reverse order
    public void traverseDoubleLinkedListReverse(){
        if(existsCircularDoubleLinkedList()){
            System.out.println("Linked list reverse order : \n");
            DoubleNode tempNode = tail;
            for(int i = 0; i < size; i++){
                System.out.print(tempNode.getValue());
                if(i != size - 1){
                    System.out.print("->");
                }
                tempNode = tempNode.getPrev();
            }
        } else {
            System.out.println("Linked list does not exist");
        }
        System.out.println("\n");
    }

    //Reverse traversing a circular double linked list
    void printHeadUsingTail(){
        System.out.println("\n\nPrinting tail...");
        System.out.println(tail.getValue());

        System.out.println("\n\nPrinting head using tail");
        System.out.println(tail.getNext().getValue());

        System.out.println("\n\nPrinting tail using head");
        System.out.println(head.getPrev().getValue());

        System.out.println("\n\nPrinting head");
        System.out.println(head.getValue());
    }

    //Searching for a node in linked list
    boolean searchNode(int nodeValue){
        if(existsCircularDoubleLinkedList()){
            DoubleNode tempNode = head;
            for(int i = 0; i < size; i++){
                if(nodeValue == tempNode.getValue()){
                    System.out.println("Value " + nodeValue +" found at index: " + i);
                    return true;
                }
                tempNode = tempNode.getNext();
            }
            System.out.println("Value " + nodeValue + " does not exist in the linked list");
            return false;
        } else {
            System.out.println("Linked list does not exist");
            return false;
        }
    }

    //Deletion of a node from DCLL
    void deleteNode(int location){
        if(!existsCircularDoubleLinkedList()){
            System.out.println("Linked list does not exist!");
        } else if(location == 0){
            if(head == tail || getSize() == 1){
                head.setNext(null);
                head.setPrev(null);
                head = tail = null;
                setSize(getSize() - 1);
                return;
            }
            tail.setNext(head.getNext());
            head.getNext().setPrev(tail);
            head=head.getNext();
            setSize(getSize() - 1);
        } else if(location >= size - 1){
            if(head == tail || getSize() == 1){
                head.setPrev(null);
                head.setNext(null);
                head = tail = null;
                setSize(getSize()-1);
                return;
            }
            tail = tail.getPrev();
            tail.setNext(head);
            head.setPrev(tail);
            setSize(getSize() - 1);
        } else { //delete node in between
            DoubleNode tempNode = head;
            for(int i = 0; i < location - 1; i++){
                tempNode = tempNode.getNext();
            }
            tempNode.getNext().getNext().setPrev(tempNode);
            tempNode.setNext(tempNode.getNext().getNext());
            setSize(getSize() - 1);
        }
    }

    //Deletion of entire DCLL
    void deleteCircularDoubleLinkedList(){
        if(existsCircularDoubleLinkedList()){
            DoubleNode tempNode = head;
            for (int i = 0; i < getSize(); i++){
                tempNode.setPrev(null);
            }
            tail.setNext(null);
            head=null;
            tail=null;
            System.out.println("\nLinked list deleted successfully!");
        } else {
            System.out.println("\nLinked list does not exist!");
        }
    }
}
