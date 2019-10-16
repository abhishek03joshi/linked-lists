package linkedList;
import node.DoubleNode;

public class DoubleLinkedList {
    DoubleNode head;
    DoubleNode tail;
    int size;

    public DoubleNode getHead() { return head; }

    public void setHead(DoubleNode head) { this.head = head; }

    public DoubleNode getTail() { return tail; }

    public void setTail(DoubleNode tail) { this.tail = tail; }

    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }

    //Create linked list
    public DoubleNode createDoubleLinkedList(int nodeValue){
        head = new DoubleNode();
        DoubleNode node = new DoubleNode();
        node.setValue(nodeValue);
        node.setNext(null);
        node.setPrev(null);
        head=node;
        tail=node;
        size=1;
        return head;

    }

    //check for the existence of the linked list
    boolean existsDoubleLinkedList(){
        return head !=null;
    }

    //Insert in double linked list
    void insertInDoubleLinkedList(int nodeValue, int location){
        DoubleNode node = new DoubleNode();
        node.setValue(nodeValue);
        if(!existsDoubleLinkedList()){
            System.out.println("The linked list does not exist");
        } else if(location == 0) {
            node.setNext(head);
            node.setPrev(null);
            head.setPrev(node);
            head=node;
        } else if(location >= size) {
            node.setNext(null);
            node.setPrev(tail);
            tail.setNext(node);
            tail=node;
        } else { // insert in between
            DoubleNode tempNode = head;
            int index = 0;
            while( index < location -1) {
                tempNode = tempNode.getNext();
                index++;
            }
            node.setNext(tempNode.getNext());
            node.setPrev(tempNode);
            tempNode.getNext().setPrev(node);
            tempNode.setNext(node);

        }
        setSize(getSize() + 1);
    }

    //Traverse linked list
    void traverseDoubleLinkedList(){
        if(existsDoubleLinkedList()){
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.getValue());
                if( i != size -1){
                    System.out.print("->");
                }
                tempNode = tempNode.getNext();
            }

        } else {
            System.out.println("Linked list does not exist");
        }
        System.out.println("\n");
    }

    //Traverse linked list in reverse order
    void traverseDoubleLinkedListReverse(){
        if(existsDoubleLinkedList()){
            DoubleNode tempNode = tail;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.getValue());
                if(i != size-1){
                    System.out.print("->");
                }
                tempNode = tempNode.getPrev();
            }

        } else{
            System.out.println("Linked list does not exist");
        }
        System.out.println("\n");
    }


    //Search node in a linked list
    boolean searchDoubleNode(int nodeValue){
        DoubleNode tempNode = head;
        for(int i = 0; i < size; i++){
            if(nodeValue == tempNode.getValue()){
                System.out.println("The element " + nodeValue + " is found at index : " + i);
                return true;
            }
            tempNode  = tempNode.getNext();
        }
        System.out.println("Given element does not exist in the Double linked list");
        return false;
    }

    //Delete node in a linked list
    public void deleteDoubleNode(int location){
        if(!existsDoubleLinkedList()){
            System.out.println("The linked list does not exist!");
            return;
        } else if (location == 0){
            if(getSize() == 1){
                head = tail = null;
                setSize(getSize() - 1);
                return;
            }
            head.getNext().setPrev(null);
            head = head.getNext();
            setSize(getSize() - 1);
        } else if(location >= size - 1){
            if(head == tail){
                tail = head = null;
                setSize(getSize() - 1);
                return;
            }
            tail.getPrev().setNext(null);
            tail=tail.getPrev();
            setSize(getSize() - 1);
        } else {//Insert in between
            DoubleNode tempNode = head;
            for (int i = 0; i < location - 1; i++){
                tempNode = tempNode.getNext();
            }
            tempNode.getNext().getNext().setPrev(tempNode);
            tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
            setSize(getSize() - 1);
        }

    }

    //Delete entire linked list
    void deleteDoubleLinkedList(){
        System.out.println("\n\nDeleting entire linked list.....");
        DoubleNode tempNode = head;
        for (int i = 0 ; i < size; i++) {
            tempNode.setPrev(null);
            tempNode = tempNode.getNext();
        }
        head = null;
        tail = null;
        System.out.println("\nLinked list has been deleted successfully!");
    }
}
