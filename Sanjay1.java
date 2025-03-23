import java.util.Scanner;

class Sanjay1
{
    public static void main (String s[])
    {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine(); 
        int n = sc.nextInt();   
        int len = path.length();
        int[] pre = new int[len + 1]; 
        for (int i = 1; i <= len; i++) {
            pre[i] = pre[i - 1] + (path.charAt(i - 1) == 'T' ? 1 : 0);
        } 
 
        for (int i = 0; i < n; i++) {
            System.out.println("enter the start point : ");
            int start = sc.nextInt();
            System.out.println("enter the end point : ");
            int end = sc.nextInt();
            System.out.println("the number of tresure is :" + (pre[end] - pre[start - 1]));  
        }
    }
}