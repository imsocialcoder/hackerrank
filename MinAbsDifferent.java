import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/*
Minimum Absolute Difference in an Array

The absolute difference is the positive difference between two values  and , is written  or  and they are equal. If  and , . Given an array of integers, find the minimum absolute difference between any two elements in the array.

Example. 

There are  pairs of numbers:  and . The absolute differences for these pairs are ,  and . The minimum absolute difference is .

Function Description

Complete the minimumAbsoluteDifference function in the editor below. It should return an integer that represents the minimum absolute difference between any pair of elements.

minimumAbsoluteDifference has the following parameter(s):

int arr[n]: an array of integers
Returns

int: the minimum absolute difference found
Input Format

The first line contains a single integer , the size of .
The second line contains  space-separated integers, .

Constraints

Sample Input 0

3
3 -7 0
Sample Output 0

3
Explanation 0

The first line of input is the number of array elements. The array,  There are three pairs to test: , , and . The absolute differences are:

Remember that the order of values in the subtraction does not influence the result. The smallest of these absolute differences is .

Sample Input 1

10
-59 -36 -13 1 -53 -92 -2 -96 -54 75
Sample Output 1

1
Explanation 1

The smallest absolute difference is .

Sample Input 2

5
1 -3 71 68 17
Sample Output 2

3
Explanation 2

The minimum absolute difference is .

*/
class Result {

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
    // Write your code here
    int min = 2147483647, diff;
    Collections.sort(arr);
    
     for( i=0; i<arr.size()-1 && min!=0; i++){
        diff = arr.get(i+1) - arr.get(i);
        if(diff<min){
            min = diff;
        }else{
          //do nothing.
        }
    }
        
    return min;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
