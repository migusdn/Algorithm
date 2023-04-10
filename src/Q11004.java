import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q11004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        quickSort(arr, 0, n-1, k-1);
        bw.write(String.valueOf(arr[k-1]));
        bw.close();
        br.close();
    }
    public static void quickSort (int[] arr, int s, int e, int k){
        if(s<e){
//            int pivot = partition(arr,s,e);
        }
    }
    public static void partition(int[] arr, int s, int e){

    }
    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}