import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int i=0;
        int count=0;
        while(i<n){
            count++;
            i+=count;
        }
        int a=count-(i-n);
        int b=i-n+1;
        if(count%2==1){
            sb.append(b).append("/").append(a);
        }else{
            sb.append(a).append("/").append(b);
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}