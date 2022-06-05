public class Stack <T extends Comparable <T>>{
    private T item1;
    private class Node{
        T item;
        Node next; // next Node in linked list

        // default constructor
        public Node() {
            item1 = null;
            next = null;
        }
        // constructor
        public Node(T m, Node n) {
            item1 = m;
            next = n;
        }
    }
    private Node head;

    //Constructor
    Stack() {
        this.head = null;
    }

    public void push(T x) {
        Node temp = new Node();
 
        if (temp == null) {
            return;
        }
 
         temp.item = x;
     

         temp.next = head;
  
    
         head = temp;
        
    
}
    public T pop(){
        if (head == null) {
            return null;
        }
        
        T value = head.item;
        head = head.next;
        return value;
    }
 
  
    public boolean isEmpty(){
        return head == null;
    }
    public T peek(){
        if (!isEmpty()) {
            return head.item;
        }else{
            return null;
        }


    }
 
 
    public int getCount() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}