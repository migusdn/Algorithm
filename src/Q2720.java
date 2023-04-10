import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q2720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n;i++){
            int total=Integer.parseInt(br.readLine());
            sb.append(total/25).append(" ");
            total%=25;
            sb.append(total/10).append(" ");
            total%=10;
            sb.append(total/5).append(" ");
            total%=5;
            sb.append(total).append(" ").append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}