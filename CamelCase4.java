import java.io.*;
import java.util.*;

/*
Camel Case 4 Challenge

Camel Case is a naming style common in many programming languages. In Java, method and variable names typically start with a lowercase letter, with all subsequent words starting with a capital letter (example: startThread). Names of classes follow the same pattern, except that they start with a capital letter (example: BlueCar).

Your task is to write a program that creates or splits Camel Case variable, method, and class names.

Input Format

Each line of the input file will begin with an operation (S or C) followed by a semi-colon followed by M, C, or V followed by a semi-colon followed by the words you'll need to operate on.
The operation will either be S (split) or C (combine)
M indicates method, C indicates class, and V indicates variable
In the case of a split operation, the words will be a camel case method, class or variable name that you need to split into a space-delimited list of words starting with a lowercase letter.
In the case of a combine operation, the words will be a space-delimited list of words starting with lowercase letters that you need to combine into the appropriate camel case String. Methods should end with an empty set of parentheses to differentiate them from variable names.
Output Format

For each input line, your program should print either the space-delimited list of words (in the case of a split operation) or the appropriate camel case string (in the case of a combine operation).
Sample Input

S;M;plasticCup()

C;V;mobile phone

C;C;coffee machine

S;C;LargeSoftwareBook

C;M;white sheet of paper

S;V;pictureFrame

Sample Output

plastic cup

mobilePhone

CoffeeMachine

large software book

whiteSheetOfPaper()

picture frame

Explanation

Use Scanner to read in all information as if it were coming from the keyboard.

Print all information to the console using standard output (System.out.print() or System.out.println()).

Outputs must be exact (exact spaces and casing).

*/

public class Solution {

    static String splitMethod(String methodName){
        String result = "";
        methodName = methodName.substring(0, methodName.length()-2);
            for(int i=0; i<methodName.length(); i++){
                if(Character.isLowerCase(methodName.charAt(i))){
                    result+=Character.toString(methodName.charAt(i));
                }else{
                    result += " " + Character.toString(Character.toLowerCase(methodName.charAt(i)));
                }
            }    
        return result;
    }
    
    static String splitClass(String className){
        String result = "";
           for(int i=0; i<className.length(); i++){
                if(Character.isLowerCase(className.charAt(i))){
                    result+=Character.toString(className.charAt(i));
                }else{
                    if(i!=0){
                        result += " ";
                    }else{
                        //do nothing.
                    }
                    result += Character.toString(Character.toLowerCase(className.charAt(i)));
                }
            }  
            return result;
    }
    
    static String splitVariable(String variableName){
        String result = "";
        
        for(int i=0; i<variableName.length(); i++){
                if(Character.isLowerCase(variableName.charAt(i))){
                    result+=Character.toString(variableName.charAt(i));
                }else{
                    result += " " + Character.toString(Character.toLowerCase(variableName.charAt(i)));
                }
            }
        
        return result;
    }
    
    
    static String splitString(char second, String variable){
        String result = "";
        
        if(second == 'M'){
            result = splitMethod(variable);          
        }else if(second == 'C'){
            result = splitClass(variable); 
        }else{//second == 'V'
            result = splitVariable(variable); 
        }
        
        return result;
    }

    static String combineMethodOrVariable(String[] splittedStringList, boolean isMethod){
        String result = splittedStringList[0];
        for(int i=1; i<splittedStringList.length; i++){
                String splittedString = splittedStringList[i];
                result += Character.toString(Character.toUpperCase(splittedString.charAt(0)));
                result += splittedString.substring(1);          
        }
        if(isMethod){
            result += "()";
        }else{
            //do nothing.
        }        
        return result;
    }   

    static String combineClass(String[] splittedStringList){        
        String result = "";
        for(int i=0; i<splittedStringList.length; i++){
                String splittedString = splittedStringList[i];
                result += Character.toString(Character.toUpperCase(splittedString.charAt(0)));
                result += splittedString.substring(1);          
        }
        return result;
    }    
    
    static String combineString (char second, String variable){
        String result = "";
        String[] splittedStringList = variable.split(" ");
        if(second == 'M'){
            result = combineMethodOrVariable(splittedStringList, true);
        }else if(second == 'C'){
            result = combineClass(splittedStringList);
        }else{//second == 'V'            
            result = combineMethodOrVariable(splittedStringList, false);
        }
        return result;
        
    }
    static String camelCaseByOperations(char first, char second, String variable){
        String result = "" + variable;
        if(first == 'S'){
            result = splitString(second, variable);
        }else if (first == 'C'){
            result = combineString(second, variable);
        }else{
            //do nothing.
        }
        return result;
    }
    
    static String camelCase(String line){        
        char firstChar = line.charAt(0), secondChar = line.charAt(2);
        String result = camelCaseByOperations(firstChar, secondChar, line.substring(4));
        return result;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);  
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            System.out.println(camelCase(line));
        }
        
    }
}
