import java.util.Scanner;
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
            System.out.print(temp.getData()+" ");
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
    
    public void swapNode(int a,int b) {
        Node A = this.find(a);
        Node B = this.find(b);
        Node nodeBeforeA = null;
        Node nodeBeforeB = null;
        if(A==null || B == null) {
            System.out.println("Values not found");
            return;
        }
        
        Node temp = this.head;
        while(temp!=null && temp.getData() != a) {
            nodeBeforeA = temp;
            temp=temp.getNext();
            
        }
        
        Node temp1 = this.head;
        while(temp1!=null && temp1.getData() != b) {
            nodeBeforeB = temp1;
            temp1=temp1.getNext();
        }
        
        if(nodeBeforeA!=null) {
            nodeBeforeA.setNext(B);
        } else
            this.head = B;
        
        if(nodeBeforeB!=null) {
            nodeBeforeB.setNext(A);
        } else
            this.head = A;
        
        Node temp3 = A.getNext();
        A.setNext(B.getNext());
        B.setNext(temp3);
        
        
    }
}
class LL {
  public static void main (String[] args) {
    int t,x;
    LinkedList list = new LinkedList();
    Scanner in=new Scanner(System.in);
    t=in.nextInt();
    while(t>0){
        x=in.nextInt();
        list.addAtEnd(x);
        t=t-1;
    }
    System.out.println("Before Swapping Values = ");
    list.display();
    list.swapNode(1,5);
    System.out.println("\nAfter Swapping Values = ");
    list.display();
  }
}
