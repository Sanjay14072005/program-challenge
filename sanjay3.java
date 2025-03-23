import java.util.*; 

public class sanjay3 {
     public static int minswap(String s1, String s2) {
        int n = s1.length(); 
        if (!isposible(s1, s2))  
            return -1; 
        return countInversions(s1, s2);
    }
 
    private static boolean isposible(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    } 
    private static int countInversions(String s1, String s2) {
        int n = s1.length(); 
        Map<Character, Queue<Integer>> h = new HashMap<>();
        for (int i = 0; i < n; i++) {
            h.putIfAbsent(s2.charAt(i), new LinkedList<>());
            h.get(s2.charAt(i)).offer(i);
        } 
        int[] indexArray = new int[n];
        for (int i = 0; i < n; i++) {
            indexArray[i] = h.get(s1.charAt(i)).poll();
        }
 
        return countinversions(indexArray, 0, n - 1);
    } 
    private static int countinversions(int[] arr, int left, int right) {
        if (left >= right) return 0;
        
        int mid = (left + right) / 2;
        int inversions = 0;
        
        inversions += countinversions(arr, left, mid);
        inversions += countinversions(arr, mid + 1, right);
        inversions += merge(arr, left, mid, right);
        
        return inversions;
    } 
    private static int merge(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        
        int i = 0, j = 0, k = left, swaps = 0;
        
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (mid + 1) - (left + i);   
            }
        }
        
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
        
        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        sc.nextLine(); 
        String s1 = sc.nextLine();
        String s2 = sc.nextLine(); 
        System.out.println(minswap(s1, s2)); 
    }
}
