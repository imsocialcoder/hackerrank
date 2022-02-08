import java.util.*;
class JavaStackSolution{
	/*
    Java Stack challenge:
    
    A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format

There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

The part of the code that handles input operation is already provided in the editor.

Output Format

For each case, print 'true' if the string is balanced, 'false' otherwise.

Sample Input

{}()
({()})
{}(
[]
Sample Output

true
true
false
true
    
    */
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            isBalanced(input);
		}
		
	}
    
    private static void isBalanced(String input){
        Stack<String> stack = new Stack<String>();
        boolean isBalanced = true;
        for(int i=0; i<input.length() && isBalanced; i++){
            String letter = String.valueOf(input.charAt(i));
            if(isStarting(letter)){
                stack.push(letter); 
            }else{
                if(!stack.empty()){
                    if(isMatch(stack.peek(), letter)){
                        stack.pop();
                    }else{
                        isBalanced = false;
                    }
                }else{
                    isBalanced = false;    
                }                    
            }
        }
        
        if(isBalanced && stack.empty()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
    
    private static boolean isMatch(String a, String b){
        return (a.equals("(") && b.equals(")")) ||
            (a.equals("[") && b.equals("]")) ||
            (a.equals("{") && b.equals("}"));
    }
    
    private static boolean isStarting(String letter){
        return (letter.equals("(") || letter.equals("{")
        || letter.equals("["));
    }
}
