package linkedList;

import node.SingleNode;

public class SingleLinkedList {
    private SingleNode head;
    private SingleNode tail;
    private int size;

    //Creation of a linked list
    public SingleNode createSingleLinkedList(int nodeValue) {
        head = new SingleNode();//initialise this for traversing
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        node.setNext(null);
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public SingleNode getHead() { return head; }
    public void setHead(SingleNode head) { this.head = head; }

    public SingleNode getTail() { return tail; }
    public void getTail(SingleNode tail) { this.tail = tail; }

    public int getSize() { return size; }
    public void setSize(int size) { this.size=size; }


    public boolean existsLinkedList() {
        return head != null;
    }

    //Insertion in a linked list
    public void insertInLinkedList(int nodeValue, int location) {

        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
        if(!existsLinkedList()){
            System.out.println("No linked list exists for insertion");
            return;
        } else if(location == 0){
            node.setNext(head);
            head = node;
        } else if (location >= size){
            node.setNext(null);
            tail.setNext(node);
            tail = node;
        } else { //insert at a specific location
            SingleNode tempNode = head;
            int index = 0;
            while (index < location - 1){
                tempNode = tempNode.getNext();
                index++;
            }
            SingleNode nextNode = tempNode.getNext();
            tempNode.setNext(node);
            node.setNext(nextNode);

        }
        setSize(getSize() + 1);

    }

    //Traverse a linked list
    void traverseLinkedList(){
        if(existsLinkedList()){
            SingleNode tempNode = head;
            for(int i = 0; i < getSize(); i++){
                System.out.println(tempNode.getValue());
                tempNode=tempNode.getNext();
            }
        } else{
            System.out.println("Linked list does not exist!");
        }
        System.out.println("\n");
    }

    //Searching a node with a given value
    boolean searchNode(int nodeValue){
        if(existsLinkedList()) {
            SingleNode tempNode = head;
            for(int i = 0; i < size; i++){
                if(tempNode.getValue() == nodeValue){
                    System.out.println("Found the node at location " + i + "\n");
                    return true;
                }
                tempNode = tempNode.getNext();
            }
        }
        System.out.println("Node with the value " + nodeValue + " not found! \n");
        return false;
    }

    //Deletes node from a location
    public void deleteNode(int location) {
        if(!existsLinkedList()){
            System.out.println("The linked list does not exist!!");//Linked list does not exist
            return;
        } else if (location == 0){//delete the first node
            head = head.getNext();
            if(getSize()  == 0){
                head = tail = null;
            }
            setSize(getSize() - 1);

        } else if( location >= getSize()){//delete the last node
            SingleNode tempNode = head;
            if(tempNode.getNext() == null && size == 1){//This is the only node in the list
                head = tail = null;
                setSize(0);
                return;
            }
            for (int i = 0; i < getSize() - 1 ; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(null);
            tail = tempNode;
            setSize(getSize() - 1);
        } else {//delete the node in between
            SingleNode tempNode = head;
            for ( int i = 0; i < location - 1; i++){
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(tempNode.getNext().getNext());
            setSize(getSize() - 1);
        }
    }

    //Deletes entire LinkedList
    void deleteLinkedList() {
        System.out.println("\n\n Deleting Linked List ....");
        head = null;
        tail = null;
        System.out.println("Linked List deleted successfully");
    }
}
