// todo: Merging Overlapping Intervals Using Stacks... For eg:- (1, 3), (2, 5), (7, 9), (8, 14), (13, 19)  the Merged Intervals (1, 5), (7, 19)...

import java.util.Scanner;
import java.util.Stack;
public class Merge
{
    //! Function to Merge the Integer Intervals... O(1) time...
    public void MergeIntervals(Stack<Integer> sck, int start, int end)
    {
        if(sck.isEmpty())  //? Since the Stack is Empty for the First time... we push the given Interval...
        {
            sck.push(start);
            sck.push(end);
            return;           // Return statement to jump out of the Function body...
        }
        int p = sck.peek();   //? Peeking the End point of the previous Interval...
        if(p > start)   
        {               // If the given Interval lies in the range of the new Interval... the End point is updated...
            sck.pop();
            sck.push(end);
        }
        else     // Otherwise the Interval remains the same... and a new Interval is created...
        {
            sck.push(start);
            sck.push(end);
        }
        return;
    }
    //! Function to Reverse a Stack... O(n) time...
    public void Reverse(Stack<Integer> sck1, Stack<Integer> sck2)
    {
        if(sck1.isEmpty())     //? Reversing the Stack to print the Intervals in Ascending Order...
        {
            System.out.println("The Required Stack has been Reversed !!");
            return;
        }
        int pop = sck1.pop();
        sck2.push(pop);
        Reverse(sck1, sck2);    //! Recursive Call for the function...
        return;
    }
    //! Function to Display the Output... O(n) time...
    public void PrintStack(Stack<Integer> sck)
    {
        System.out.println("The Intervals are : ");
        while(!sck.isEmpty())     // Loop to run until the current stack is Empty... 
        {
            System.out.print("("+sck.peek()+" , ");
            sck.pop();
            System.out.println(sck.peek()+ ")");
            sck.pop();
        }
        return;
    }
    //! Main function begins...
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();    //! Stack creation using Java Collection Package...
        Stack<Integer> stack1 = new Stack<Integer>();
        Merge merge = new Merge();     // Object creation...
        int x, a, b;
        System.out.print("Enter the Number of Intervals to enter : ");
        x = scanner.nextInt();
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter the Start : ");
            a = scanner.nextInt();
            System.out.print("Enter the End : ");
            b = scanner.nextInt();
            merge.MergeIntervals(stack, a, b);      //? Function call... O(n) time...
        }
        merge.Reverse(stack, stack1);     //? Function Call... O(n) time...
        merge.PrintStack(stack1);       //? Function Call... O(n)time...
        scanner.close();
    }
}

//* The Time Complexity of the Algorithm is O(1)*n + O(n) + O(n)... Which gives O(n) time... */
//* The Space Complexity of the Algorithm is O(n) for first Stack and O(n) for Second Stack... Thus... O(n) + O(n) space... Which gives O(n) space... */
//! Time Complexity - O(n) time...
//! Space Complexity - O(n) space...