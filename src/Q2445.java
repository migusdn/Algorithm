import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q2445 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=1;i<n; i++){
            for(int j=0;j<i;j++)
                sb.append("*");
            for(int j=0;j<2*n-2*i;j++)
                sb.append(" ");
            for(int j=0;j<i;j++)
                sb.append("*");
            sb.append("\n");
        }
        for(int i=n;i>0; i--){
            for(int j=0;j<i;j++)
                sb.append("*");
            for(int j=0;j<2*n-2*i;j++)
                sb.append(" ");
            for(int j=0;j<i;j++)
                sb.append("*");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}