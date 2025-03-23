import java.util.*;

class sanjay2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();  
        int n = sc.nextInt();  
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Deque<Integer> dq = new LinkedList<>();
        List<Integer> maxvalues = new ArrayList<>();
 
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
 
        for (int i = k; i < n; i++) { 
            maxvalues.add(arr[dq.peekFirst()]);
 
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
 
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }
        int min=Integer.MAX_VALUE;
        maxvalues.add(arr[dq.peekFirst()]);
        for( int i = 0 ; i <maxvalues.size() ; i++ )
            min = Math.min(min , maxvalues.get(i));
        System.out.println("the answer is" +min);;
/*  the 2nd exmaple is worng
Input: 2 5 10 20 30 40 50
The contiguous subarrays of size k=2 are:

[10, 20] → Maximum = 20

[20, 30] → Maximum = 30

[30, 40] → Maximum = 40

[40, 50] → Maximum = 50


The minimum of these maximums is 30.
this shoud be 20 !

*/
    }    
}
