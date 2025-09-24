/**
 * Uses a stack and implements methods to merge two stacks or reverse a stack.
 * @author Balaji Srinivasan
 */
public class TestStack {
    /**
     * Given two stacks containing Integer objects in increasing order
     * from the bottom up, create a third stack such that the Integer objects
     * are in increasing order from the bottom up. If an item appears n times in
     * the two given stacks, it will appear n times in the new stack.
     *
     * @param s1 the first stack
     * @param s2 the second stack
     * @return the new stack, with the items from the two given stacks merged.
     */
    public static <E extends Comparable<E>> Stack<E> merge(Stack<E> s1, Stack<E> s2) {
        // TODO: Implement this function.
        // Using the clone method from the Stack class
        
        Stack<E> input1 = s1.clone();
        Stack<E> input2 = s2.clone();
        Stack<E> temp = new Stack<>();

        while (!input1.isEmpty() && !input2.isEmpty() ){
            if (input1.peek().compareTo(input2.peek()) <= 0) {
                temp.push(input2.pop());
            } else {
                temp.push(input1.pop());
            }
        }
        //One of those two stacks is empty now, so we add from the other stack
        while(!input1.isEmpty()){
                temp.push(input1.pop());
            } 
        while(!input2.isEmpty()){
                temp.push(input2.pop());
            }
        // reverse to get incresing order
        return reverse(temp);
    }

    /**
     * Given a stack of Integer objects, create and return a stack with
     * the same objects in reverse order.
     *
     * @param1 s1 the input stack
     * @return the new stack, with the items in reverse order
     */
    public static <E extends Comparable<E>> Stack<E> reverse(Stack<E> s1) {
        // TODO: Implement this function.

        Stack<E> input1 = s1.clone();
        Stack<E> temp = new Stack<>();

        while(!input1.isEmpty()){
            temp.push(input1.pop());
        }

        return temp;
    }

    /**
 * makeStack: Given an array of Integer objects, create and return a stack with
 * the same objects. The first item in the array will be at the bottom of the
 * stack, the last item at the top.
 *
 * @param1 arr the Integer array
 * @return the new stack
 */
    public static <E extends Comparable<E>> Stack<E> makeStack(E[] arr) {
        Stack<E> newStack = new Stack<>();
        for (E element : arr){
            newStack.push(element);
        }
        return newStack;
    }

    /**
     * Main method. Testing for the following cases:
     *  
     * 1. Two stacks of equal length and no duplicate values.
     * 2. Two stacks of unequal length and no duplicate values.
     * 3. Two stacks of unequal length with duplicate values shared between stacks (for example 3 5 7 19 and 1 7 11 11 15)
     * 4. One stack with values and one empty stack.
     * 
     */
    public static void main(String[] args) {
       // Equal length, no duplicates
        Stack<Integer> stack1 = makeStack(new Integer[]{0, 2, 4, 6, 8, 10});
       Stack<Integer> stack2= makeStack(new Integer[]{1, 3, 5, 7, 9, 11});

       System.out.println("The first stack is: " + stack1.toString());
       System.out.println("The second stack is: " + stack2.toString());
       System.out.println("Merged stack: " + merge(stack1, stack2).toString());
       System.out.println(merge(stack1, stack2));


       // Unequal length, no duplicates
       Stack<Integer> stack3 = makeStack(new Integer[]{1, 2, 3});
       Stack<Integer> stack4 = makeStack(new Integer[]{4, 5, 6, 7, 8, 9, 10});

       System.out.println("The third stack is: " + stack3.toString());
       System.out.println("The fourth stack is: " + stack4.toString());
       System.out.println("Merged stack: " + merge(stack3, stack4).toString());

         // Unequal length, with duplicates
        Stack<Integer> stack5 = makeStack(new Integer[]{3, 5, 7, 19});
        Stack<Integer> stack6 = makeStack(new Integer[]{1, 7, 11, 11, 15});

        System.out.println("The fifth stack is: " + stack5.toString());
        System.out.println("The sixth stack is: " + stack6.toString());
        System.out.println("Merged stack: " + merge(stack5, stack6).toString());

        // One empty stack
        Stack<Integer> stack7 = makeStack(new Integer[]{});
        Stack<Integer> stack8 = makeStack(new Integer[]{1, 2, 3, 4, 5});
        System.out.println("The seventh stack is: " + stack7.toString());
        System.out.println("The eighth stack is: " + stack8.toString());
        System.out.println("Merged stack: " + merge(stack7, stack8).toString());
    }
}
