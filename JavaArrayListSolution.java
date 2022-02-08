import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaArrayListSolution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        ArrayList<ArrayList<Integer>> numberList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> lineOfNumbers = new ArrayList<Integer>();
            int numberOfEntries=in.nextInt();
            for(int j=0; j<numberOfEntries; j++){
                lineOfNumbers.add(in.nextInt());
            }
            numberList.add(lineOfNumbers);
            in.nextLine();
        }
        
        int numberOfQueries = in.nextInt();
        
        in.nextLine();
        
        for(int i=0;i<numberOfQueries;i++)
        {
            int x = in.nextInt(), y = in.nextInt();
            if(numberList.size()>x){
                if(numberList.get(x-1).size()>=y){
                    System.out.println(numberList.get(x-1).get(y-1)); 
                }else{
                     System.out.println("ERROR!");
                }
            }else{
                System.out.println("ERROR!");
            }
            in.nextLine();
        }
        
    }
}
