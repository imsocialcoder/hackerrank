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

Jim and the Orders Challenge

Jim's Burgers has a line of hungry customers. Orders vary in the time it takes to prepare them. Determine the order the customers receive their orders. Start by numbering each of the customers from  to , front of the line to the back. You will then be given an order number and a preparation time for each customer.

The time of delivery is calculated as the sum of the order number and the preparation time. If two orders are delivered at the same time, assume they are delivered in ascending customer number order.

For example, there are  customers in line. They each receive an order number  and a preparation time .:

Customer    1    2    3    4    5
Order #        8    5    6    2    4
Prep time    3    6    2    3    3
Calculate:
Serve time    11    11    8    5    7
We see that the orders are delivered to customers in the following order:

Order by:
Serve time    5    7    8    11    11
Customer    4    5    3    1    2
Function Description

Complete the jimOrders function in the editor below. It should return an array of integers that represent the order that customers' orders are delivered.

jimOrders has the following parameter(s):

orders: a 2D integer array where each  is in the form .
Input Format

The first line contains an integer , the number of customers.
Each of the next  lines contains two space-separated integers, an order number and prep time for .

Constraints

Output Format

Print a single line of  space-separated customer numbers (recall that customers are numbered from  to ) that describes the sequence in which the customers receive their burgers. If two or more customers receive their burgers at the same time, print their numbers in ascending order.

Sample Input 0

3
1 3
2 3
3 3
Sample Output 0

1 2 3
Explanation 0

Jim has the following orders:

. This order is delivered at time .
. This order is delivered at time .
. This order is delivered at time .
The orders were delivered in the same order as the customers stood in line. The index in  is the customer number and is what is printed. In this case, the customer numbers match the order numbers.

Sample Input 1

5
8 1
4 2
5 6
3 1
4 3
Sample Output 1

4 2 5 1 3
Explanation 1

Jim has the following orders:

. This order is delivered at time .
. This order is delivered at time .
. This order is delivered at time .
. This order is delivered at time .
. This order is delivered at time .
When we order these by ascending fulfillment time, we get:

: customer .
: customer .
: customer .
: customer .
: customer .
We print the ordered numbers in the bulleted listed above as 4 2 5 1 3.

Note: While not demonstrated in these sample cases, recall that any orders fulfilled at the same time must be listed by ascending order number.

*/
class Result {

    /*
     * Complete the 'jimOrders' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY orders as parameter.
     */

    public static List<Integer> jimOrders(List<List<Integer>> orders) {
    // Write your code here
        List<Integer> times = new ArrayList<Integer>();
        
        for(int i=0;i<orders.size();i++){
            times.add(orders.get(i).get(0) + orders.get(i).get(1));
        } 
        
        List<Integer> timesCopied = new ArrayList<Integer>(times);
        
        Collections.sort(timesCopied);
        
        List<Integer> returnList = new ArrayList<Integer>();
        for(int i=0; i<timesCopied.size(); i++){
            int timesToSearch = timesCopied.get(i);
            boolean isFound = false;
            for(int j=0; j<times.size() &&!isFound; j++){
                if(times.get(j) == timesToSearch && !returnList.contains(j+1)){
                    isFound = true;
                    returnList.add(j+1);
                }else{
                    //do nothing.
                }
            }
        }
        return returnList;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> orders = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                orders.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.jimOrders(orders);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
