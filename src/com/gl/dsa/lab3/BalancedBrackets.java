package com.gl.dsa.lab3;
import java.util.Deque;
import java.util.ArrayDeque;

public class BalancedBrackets {

	 // function to check if brackets are balanced
    public static boolean areBracketsBalanced(String expr)
    {
         Deque<Character> stack
            = new ArrayDeque<Character>();
 
         for (int i = 0; i < expr.length(); i++){
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{'){          
                stack.push(x);
                continue;
            }
 
            if (stack.isEmpty())
                return false;
            char stkTop;
            switch (x) {
            case ')':
            	stkTop = stack.pop();
                if (stkTop == '{' || stkTop == '[')
                    return false;
                break;
 
            case '}':
            	stkTop = stack.pop();
                if (stkTop == '(' || stkTop == '[')
                    return false;
                break;
 
            case ']':
            	stkTop = stack.pop();
                if (stkTop == '(' || stkTop == '{')
                    return false;
                break;
            }
        }
 
         return (stack.isEmpty());
    }
 
   
	public static void main(String[] args) {
		String expr = "( [ [ { } ] ] )";

		// Function call
		if (BalancedBrackets.areBracketsBalanced(expr))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
			
	}

}