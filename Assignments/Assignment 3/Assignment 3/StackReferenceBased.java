
/**
 * Write a description of class StackReferenceBased here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StackReferenceBased extends linkedListClass
{
    // instance variables - replace the example below with your own

    static char top; //char at the top of the stack
    int items;
    static char item;
    static linkedListClass linkedList;
   
    /**
     * Constructor for types of class StackReferenceBased
     */
    public StackReferenceBased()
    {
        // initialise instance variables
        createStack();
    }

    // method that removes creates a stack by creating a linked list
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void createStack()
    {
       linkedList = new linkedListClass();
    }
    
    // method that removes all the contents of the stack by pointing the 
    // head to null and javs's garbage collection takes care of the rest
    public void popAll()
    {
        linkedList.removeAll();
    }
    
    // method that checks to see if the stack is empty using the method from linkedListClass
    @Override
    public boolean isEmpty()
    {
        linkedList.isEmpty();
        return true;
    }
    
    // method that adds top to the top of the stack 
    // or adds top to the end of the linked list  using the method from linkedListClass
    public static void push(char top)
    {
        linkedList.add(top);
    }
    
    // method that removes the top char from the stack and returns it
    public static char pop()
    {
        item =  linkedList.get(linkedList.size()-1);
        linkedList.remove(linkedList.size()-1);
        return item;
    }
    
    // method that returns the value at the top of the stack
    public char peek()
    {
        return linkedList.get(linkedList.size()-1);
    }
    
   // method that prints the contents of the stack 
    public void printStack()
    {
       System.out.print(linkedList.size() + " Items in the stack: " );
        for ( int i = 0 ; i < linkedList.size(); i++ ){
            if(i == (linkedList.size() - 1) ){
                System.out.print(linkedList.get(i));
                break;
            }
            System.out.print(linkedList.get(i) + ", ");
        }
        System.out.println();
        
    }
}
