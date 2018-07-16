import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int highestSum = Integer.MIN_VALUE;
        
   for(int i=0; i<4 ; i++) {
			for(int j=0 ; j<4 ; j++) {
				int temp = calc(arr,i,j);
				if (temp > highestSum) {
					highestSum = temp;
				}
				System.out.print(temp + " ");
			}
			System.out.println();
		}
    
    return highestSum;
    }

    private static int calc(int[][] arr, int i, int j) {
		int sum = 0;
		
		for(int x=i; x<(i+3) ; x++) {
			for(int y=j ; y<(j+3) ; y++) {
				if( !(x==(i+1) && 
					(y==j || y==(j+2))) ){
					sum+=arr[x][y];
				}
			}
		}
		
		return sum;
	}
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
