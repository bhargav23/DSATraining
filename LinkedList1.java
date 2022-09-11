import java.io.*;
class Node {
    private int data;
    private Node next;
    public Node (int data){
        this.data = data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public void setNext(Node node){
        this.next=node;
    }
    public int getData() {
        return this.data;
    }
    public Node getNext(){
        return this.next;
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    public Node getHead(){
        return this.head;
    }
    public Node getTail(){
        return this.tail;
    }
    public void addAtEnd(int data){
        Node node = new Node(data); 
        if(this.head==null){
            this.head = this.tail =node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }
    /* 


1. Create a new node with the data passed to the method

2. If the linked list is empty, make the new node as the head and the tail node.

3. If the linked list is not empty, add the new node at the beginning, 
i.e., before the current head node and make the new node as the head.
    
    */
    public void addAtBeginning(int data){
        Node node = new Node(data);
      if(this.head==null) {
        this.head = this.tail = node;
      } else {
            node.setNext(this.head);
            this.head = node;
           
      }
    }
    public void display(){
        Node temp = this.head;
        while(temp!=null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    public Node find(int data) {
        Node temp = this.head;
        while(temp!=null) {
            if(temp.getData()==data) {
                return temp;
            } else {
                temp = temp.getNext();
            }
        }
        return null;
    }    
    public void inset(int data, int before){
            
            Node key = this.find(before);
            if(key==null) 
                System.out.println("Not found");
            else {
                Node node = new Node(data);
                //System.out.println(node.getData());
                node.setNext(key.getNext());
                key.setNext(node);
                //key.setNext(node.getNext());
                //node.setNext(key);
                if(key == this.tail)
                    this.tail = node;
            }
                
    }

    public void delete(int data) {
        System.out.println("Key = "+data);
      Node key = this.find(data);
      if(key==null){
        System.out.println("key Not found");
        return;
      }
      if(this.head==null){
        System.out.println("List is empty");
        return;
      }
      if(this.head==key && this.tail == key){
        this.head=this.tail=null;
        System.out.println("Key is head and tail also");
        return;
      }
      if(key==this.head){
            this.head=this.head.getNext();
            key.setNext(null);
            return;
      }
      Node temp = this.head;
      Node nodeBefore = null;
      while(temp!=null) {
        if(temp.getNext()==key){
          nodeBefore = temp;
          break;
        }
        temp=temp.getNext();
      }
        nodeBefore.setNext(key.getNext());
        if(key==this.tail)
            this.tail = nodeBefore;
        key.setNext(null);
    }
}
class LL {
  public static void main (String[] args) {
        LinkedList list = new LinkedList();
        list.addAtEnd(10);
        list.addAtEnd(20);
        list.addAtBeginning(5);
        list.inset(15,10);
        list.inset(2,20);
        list.display();
        list.delete(2);
        list.display();
  }
}
