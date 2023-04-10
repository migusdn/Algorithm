import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q2444 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int i=1;
        for(;i<N; i++){
            for(int j=0;j<N-i;j++)
                sb.append(" ");
            for(int j=0;j<i*2-1;j++)
                sb.append("*");
            sb.append("\n");
        }
        for(;i>0; i--){
            for(int j=0;j<N-i;j++)
                sb.append(" ");
            for(int j=0;j<i*2-1;j++)
                sb.append("*");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}