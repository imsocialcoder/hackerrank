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
Find Digits Challenge

An integer  is a divisor of an integer  if the remainder of .

Given an integer, for each digit that makes up the integer determine whether it is a divisor. Count the number of divisors occurring within the integer.

Example

Check whether ,  and  are divisors of . All 3 numbers divide evenly into  so return .


Check whether , , and  are divisors of . All 3 numbers divide evenly into  so return .


Check whether  and  are divisors of .  is, but  is not. Return .

Function Description

Complete the findDigits function in the editor below.

findDigits has the following parameter(s):

int n: the value to analyze
Returns

int: the number of digits in  that are divisors of 
Input Format

The first line is an integer, , the number of test cases.
The  subsequent lines each contain an integer, .

Constraints



Sample Input

2
12
1012
Sample Output

2
3
Explanation

The number  is broken into two digits,  and . When  is divided by either of those two digits, the remainder is  so they are both divisors.

The number  is broken into four digits, , , , and .  is evenly divisible by its digits , , and , but it is not divisible by  as division by zero is undefined.

Language
Java 8

More
2728292021222324252614151617181989101112132345671

    public static int findDigits(int n) {
    // Write your code here
    String nStr = String.valueOf(n);
    
    int count = 0;
    for(int i=0; i<nStr.length(); i++){
        Integer aDigit = Character.getNumericValue(nStr.charAt(i));
        if(aDigit != 0 && n%aDigit == 0){
            count++;

Line: 29 Col: 27

Submit Code

Run Code

Upload Code as File

Test against custom input
Problem Solving
You have earned 25.00 points!
You are now 244.2 points away from the 4th star for your problem solving badge.
11%230.8/475
Congratulations
You solved this challenge. Would you like to challenge your friends?Share on FacebookShare on TwitterShare on LinkedIn
Next Challenge

Test case 0

Test case 1
Compiler Message
Success
Input (stdin)

Download
2
12
1012
Expected Output

Download
2
3




*/
class Result {

    /*
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int findDigits(int n) {
    // Write your code here
    String nStr = String.valueOf(n);
    
    int count = 0;
    for(int i=0; i<nStr.length(); i++){
        Integer aDigit = Character.getNumericValue(nStr.charAt(i));
        if(aDigit != 0 && n%aDigit == 0){
            count++;
        }else{
            //do nothing.
        }
    }
    
    return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.findDigits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
