import java.io.*;
import java.util.StringTokenizer;

public class Q10871 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp<x)
                bw.write(tmp+" ");
        }
        bw.close();
        br.close();
    }
}
