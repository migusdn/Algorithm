import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Q11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            times[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times);
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=times[i]*(n-i);
        }
        bw.write(String.valueOf(sum));
        bw.close();
        br.close();
    }
}