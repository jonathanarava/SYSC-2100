
/**
 * Write a description of class Infix2PostfixConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Infix2PostfixConverter extends StackReferenceBased
{
    // instance variables - replace the example below with your own
  
    static char c;
   
    static StackReferenceBased operatorStack = new StackReferenceBased();
    static int result;
     
    public static void main(String [ ] args)
    {
      String infix;
      
      // Test 1
      System.out.println("infix: (10 + 3 * 4 / 6) ");       // prints the prefix expression
      result = 10 + 3 * 4 / 6;                              // result of the equation
      infix = "(10 + 3 * 4 / 6)";                           // String infix 
      convertPostfix(infix);                                // convert infix prefix expression to postfix 
      getPostfix(result);                                   // prints postfix expression
      
   
      // Test 2
      System.out.println("infix: 12*3 - 4 + (18 / 6) ");
      result = 12*3 - 4 + (18 / 6) ;
      infix = "12*3 - 4 + (18 / 6) ";
      convertPostfix(infix);
      getPostfix(result);
      
      // Test 3
      System.out.println("infix: 35 - 42* 17 /2 + 10 ");
      result = 35 - 42* 17 /2 + 10;
      infix = " 35 - 42* 17 /2 + 10";
      convertPostfix(infix);
      getPostfix(result);
      
      // Test 4
      System.out.println("infix: 3 * (4 + 5) ");
      result =  3 * (4 + 5) ;
      infix = " 3 * (4 + 5) ";
      convertPostfix(infix);
      getPostfix(result);
      
      // Test 5
      System.out.println("infix: 3 * ( 17 - (5+2))/(2+3) ");
      result = 3 * ( 17 - (5+2))/(2+3);
      infix = " 3 * ( 17 - (5+2))/(2+3)";
      convertPostfix(infix);
      getPostfix(result);
      
    }
    
    /**
     * Constructor for objects of class Infix2PostfixConverter
     */
    public  Infix2PostfixConverter()
    {
        // initialise instance variables
        
    }
    
    // method to check if the given character is an operator
    private static boolean isOperator(char c)
    {
        return c == '*' || c == '+' || c == '-' || c == '/' || c == '(' || c == ')';
    }
    
    // method to check if the given character is operand
    private static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    // method that compares two operators to see which one has a lower precedence to the other
    private static boolean isLowerPrecedence(char op1, char op2)
    {
            switch (op1)
            {
                case '+':
                case '-':
                    return !(op2 == '+' || op2 == '-');
        
                case '*':
                case '/':
                    return op2 == '(';
                    
                case '(':
                    return true;
        
                default:
                    return false;
            }
    }

    // method that gets the priority of the precidence operator
    private static int getPrecedence(char ch) {
        switch (ch) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
        }
        return -1;
    }
    
    // method that converts infix to postfix
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static String convertPostfix(String infix)
    {
         String postfixString = " ";

        for (int i = 0; i < infix.length(); ++i) {
            char c = infix.charAt(i);
            if (c == '(') {
                push('(');
            } 
            
            else if (c == ')') {
                Character top = operatorStack.peek();
                while (!(top.equals('(')) && !(operatorStack.isEmpty())) {
                    postfixString += top.charValue();
                    operatorStack.pop();
                    top = operatorStack.peek();
                }
                operatorStack.pop();
            } 
            
            else if (c == '+' || c == '-') {
                //Stack is empty
                if (operatorStack.isEmpty()) {
                    operatorStack.push(c);
                    //current Stack is not empty
                } else {
                    Character top = operatorStack.peek();
                    while (!(operatorStack.isEmpty() || top.equals(new Character('(')) || top.equals(new Character(')')))) {
                        operatorStack.pop();
                        postfixString += top.charValue();
                    }
                    operatorStack.push(c);
                }
            } 
            
            else if (c == '*' || c == '/') {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(c);
                } else {
                    Character top = operatorStack.peek();
                    while (!top.equals(new Character('+')) && !top.equals(new Character('-')) && !operatorStack.isEmpty()) {
                        operatorStack.pop();
                        postfixString += top.charValue();
                    }
                    operatorStack.push(c);
                }
            } 
            
            else {
                postfixString += c;
            }
        }
        
        while (!operatorStack.isEmpty()) {
            Character top = operatorStack.peek();
            if (!top.equals(new Character('('))) {
                operatorStack.pop();
                postfixString += top.charValue();
            }
        }
        operatorStack.printStack();                          //prints what is in the stack
        operatorStack.popAll();                              // clears the stack for next method call
        System.out.println("postfix: " + postfixString);    //prints postfix expression
        return postfixString;
    
       }
 
    // method that prints postfix expression
   public static void getPostfix(int result)
   {
        System.out.println("result: " + result);
        System.out.println();
   }
}
