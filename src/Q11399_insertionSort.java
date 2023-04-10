import java.util.*;
import java.io.*;

public class Q11399_insertionSort {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int[] sum = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];

        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<n; i++){
            int insert_idx = i;
            int insert_value = array[i];
            for(int j=i-1; j>=0; j--){
                if(array[j]<array[i]) {
                    insert_idx = j + 1;
                    break;
                }
                if(j==0){
                    insert_idx=0;
                }
            }
            for(int j=i; j> insert_idx; j--){
                array[j] = array[j-1];
            }
            array[insert_idx] = insert_value;
        }
        sum[0] = array[0];
        for(int i=1; i<n; i++){
            sum[i] = sum[i-1]+array[i];
        }
        for(int i=0; i<n; i++){
            result += sum[i];
        }
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}
