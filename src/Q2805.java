import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Q2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] treeHeight = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            treeHeight[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(treeHeight);
        int start=0;
        int end = treeHeight[treeHeight.length-1];
        while(start<end){
            int mid = (start+end)/2;
            long sum=0;
            for(int height:treeHeight){
                if(height-mid>0)
                    sum+=height-mid;
            }
            if(sum<m){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        bw.write(String.valueOf(start-1));
        bw.close();
        br.close();

    }
}