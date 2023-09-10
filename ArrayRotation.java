package Arrays2;
import java.util.*;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(value -> Integer.parseInt(value)).toArray();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++){
            int last = arr[0];
            for (int j = 0; j < arr.length - 1; j++){
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = last;
        }

        for (int k = 0; k < arr.length; k++){
            System.out.print(arr[k] + " ");
        }

    }
}
