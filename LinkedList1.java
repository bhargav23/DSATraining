/*package whatever //do not write package name here */

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
    /* 
    public void delete(int data) {
        
    } 
    */
  /*  find(data)
1.Take a temp reference and assign it with head node
2.While temp is not null,
  a.If the data at temp is equal to the data being searched for then, return temp
  b.Else, make the next node as temp
3.If data is not found then, return null
    */
    

}
class LL {
  public static void main (String[] args) {
    LinkedList list = new LinkedList();
        list.addAtEnd(10);
        list.addAtEnd(20);
        list.addAtBeginning(5);
        list.inset(15,10);
        list.inset(2,5);
        list.inset(2,20);
        list.display();
        
  }
}
