public class ListReferenceBased{
    
        public static linkedListClass linkedList; // variable declaration
     
        public static void main(String[] args) {
     
            
            linkedList = new linkedListClass();
     
            // adds 12, 3, 25, 18 to the LinkedList
            linkedList.add(12);
            linkedList.add(3);
            linkedList.add(25);
            linkedList.add(18);
            
     
            // Test 1 - displays the current list
            System.out.println("Display the items in the linked list");
            linkedListClass.printStatement();
            
            // Test 2 - adds node to specific location in the linked list
            System.out.println("Add Integer Object valued 13 at index 0 and display the items in the linked list");
            linkedList.add(13,0);
            linkedListClass.printStatement();
            
            // Test 3 - adds node to specific location in the linked list
            System.out.println("Add Integer Object valued 17 at index 2 and display the items in the linked list");
            linkedList.add(17,2);
            linkedListClass.printStatement();
            
            // Test 4 - removes node at the specified index
            System.out.println("Remove Integer Object at index 4 and display the items in the linked list");
            linkedList.remove(4);
            linkedListClass.printStatement();
            
        }
     
    }
     
class linkedListClass extends ListReferenceBased{
 
    // variable declaration
    private static int counter; 
    private Node head;
 
    
    public linkedListClass() {
 
    }
 
    // method checks to see if the linkedlist is empty
    public boolean isEmpty() {
        if (linkedList.size() == 0){ // if linkedlist size is 0, it is empty
            return true;
        }
        return false; // otherwise linkedlist is not empty
    }
    
    // method returns the number of items in this list.
    public int size() {
        return getCounter();
    }
    
    // method that adds node to the end of the LinkedList
    public void add(Object data) {
 
        // initializes the node of the first element
        if (head == null) {
            head = new Node(data);
        }
 
        Node temp = new Node(data);
        Node current = head;
 
        
        if (current != null) {
 
            // itterates from the head node until the end of the list and then adds the item after last node
            while (current.getNext() != null) {
                current = current.getNext();
            }
 
            // last node's "next" pointer set to point to the new node
            current.setNext(temp);
        }
 
        // increment the number items in the list
        incrementCounter();
    }
 
    
    private static int getCounter() {
        return counter;
    }
 
    private static void incrementCounter() {
        counter++;
    }
 
    private void decrementCounter() {
        counter--;
    }
 
    // method that prints out the count and items currently in the list in sequence
    public static void printStatement() {
        System.out.print(linkedList.size() + " Items in the linked list: " );
        for ( int i = 0 ; i < linkedList.size(); i++ ){
            if(i == (linkedList.size() - 1) ){
                System.out.print(linkedList.get(i));
                break;
            }
            System.out.print(linkedList.get(i) + ", ");
        }
        System.out.println();
        
    }
    
    // adds the specified element at a specific position in this list
    public void add(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;
        
        if (current != null) {
			// itterates to the specific index 
			for (int i = 0; i < index && current.getNext() != null; i++) {
				current = current.getNext();
			}
		}
 
        // sets the new node's next-node pointer to point to the node's next-node pointer
        temp.setNext(current.getNext());
 
        // sets this node's next-node pointer to the new node
        current.setNext(temp);
 
        // increment the number of items
        incrementCounter();
    }
 
    // method that removes the item at the specified position in this list.
    public boolean remove(int index) {
 
        // exits if the index is out of range
        if (index < 1 || index > size())
            return false;
 
        Node current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return false;
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
 
            // decrement the number of items in the list
            decrementCounter();
            return true;
 
        }
        return false;
    }
    
    // method that returns the item at the specified position in the list
    public Object get(int index)
    {
        Node current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return null;
                current = current.getNext();
            }
            return current.getData();
        }
        return current;
    }
 
    // methods that removes all the items in the linkedList
    public boolean removeAll(){
        for (int i = 0; i < linkedList.size() ; i++) {
            remove(i);
            return true;
        }
        return true;
    }
    
    private class Node {
        // variable declaration
        Node next;
        Object data;
 
        // Node constructor
        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }
        
        public void setNext(Node nextValue) {
            next = nextValue;
        }
        
        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

    }
    
}

