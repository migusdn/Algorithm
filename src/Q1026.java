import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Q1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            a[j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            b[j] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i]*b[n-1-i];
        }
        bw.write(String.valueOf(sum));
        bw.close();
        br.close();
    }
}