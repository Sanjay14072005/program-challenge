import java.util.Scanner;

class Sanjay4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int arr[] = new int [5];
        for( int j= 0 ; j < 4 ; j++)
        {
            for( int i = 0 ; i < 5 ; i++)
            {
                int t = sc.nextInt();
                if(t < 10 || t > 200)
                {
                    System.out.println("invalid input");
                    return ;
                }   
                arr[i]+=t;
            } 
        }
       
        int max =0 ;
        int idx= -1 ;
        for (int i = 0; i < 5; i++) {
            arr[i] = (int) Math.round(arr[i] / 4.0); 

            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        } 

        if( max < 50)
            System.out.println("Energy consumption is optimal");
        else
            System.out.println("sensor number : "+ (idx+1));
    }    
}
