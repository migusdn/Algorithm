import java.util.*;
import java.io.*;

public class Q2751_mergeSort {
    static int[] arr,temp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        for(int i=0; i<n;i++)
            arr[i] = Integer.parseInt(br.readLine());
        mergeSort(0,n-1);
        for(int num:arr){
            sb.append(num).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
    private static void mergeSort(int start, int end){
        if(end-start<1)
            return;
        int middle = start + (end-start)/2;
        mergeSort(start,middle);
        mergeSort(middle+1,end);
        for(int i=start; i<=end; i++){
            temp[i] = arr[i];
        }
        int p1 = start;
        int p2 = middle+1;
        int cur = start;
        while(p1<=middle&&p2<=end){
            if(temp[p1]<temp[p2]){
                arr[cur] = temp[p1];
                cur++;
                p1++;
            }else{
                arr[cur] = temp[p2];
                cur++;
                p2++;
            }
        }
        while(p1<=middle){
            arr[cur] = temp[p1];
            p1++;
            cur++;
        }
        while(p2<=end){
            arr[cur] = temp[p2];
            p2++;
            cur++;
        }
    }
}
