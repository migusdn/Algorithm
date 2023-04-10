import java.io.*;
import java.util.StringTokenizer;

public class Q2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int j=1+2*(n-i-1);
            for(int k=0;k<i;k++)
                sb.append(" ");
            while(j>0) {
                sb.append("*");
                j--;
            }
            sb.append("\n");
        }
        for(int i=1; i<n;i++){
            int j= 1+2*i;
            for(int k=0; k<(n-i-1); k++)
                sb.append(" ");
            while(j>0){
                sb.append("*");
                j--;
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
