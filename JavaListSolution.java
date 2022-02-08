import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class JavaListSolution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            list.add(in.nextInt());
        }
        
        n=in.nextInt();
        
        for(int i=0; i<n; i++){
            in.nextLine();
            String operation = in.nextLine();
            if(operation.equals("Insert")){
                list.add(in.nextInt(), in.nextInt());
            }else{
                list.remove(in.nextInt());
            }
        }
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        
    }
}
