    import java.util.Stack;

    public class SortStack {
        public static void main(String[] args) {
            Stack<Integer> stack1 = new Stack<>(); // declare stack
            stack1.push(-3);
            stack1.push(14);
            stack1.push(18);
            stack1.push(-5);
            stack1.push(30);
            sortStack(stack1);
            System.out.println("Sorted Stack 1:");
            while (!stack1.isEmpty()) {
                System.out.print(stack1.pop() + " ");
            }
            System.out.println();

            
        }

        public static void sortStack(Stack<Integer> stack) {
            if(!stack.isEmpty()) 
            {
                int top = stack.pop();
                sortStack(stack); // Recursively sort the remaining stack
                insertInSortedOrder(stack, top); // Insert the top element in sorted order
            }
        }

        public static void insertInSortedOrder(Stack<Integer> stack, int element) {
            if (stack.isEmpty() || stack.peek() <= element) {
                stack.push(element); // If stack is empty or top element is less than element, push it
            } else {
                int top = stack.pop();
                insertInSortedOrder(stack, element); // Recursively insert the element in the sorted stack
                stack.push(top); // Push back the top element
            }
        }
    }
