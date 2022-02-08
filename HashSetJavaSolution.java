import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HashSetJavaSolution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        //Write your code here
        HashSet<String> fullNames = new HashSet<String>();
        int count = 0;
        for(int i=0; i<t; i++){
            String fullPair = pair_left[i] + " " + pair_right[i];
            if(!fullNames.contains(fullPair)){
                count++;
                fullNames.add(fullPair);               
            }else{
                //do nothing.
            }
            System.out.println(count);
        }
        
    }
}
