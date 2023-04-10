import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q2331 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int n=Integer.parseInt(s);
        for(int i=n-9*s.length(); i<=n; i++){
            int tmp=i;
            int sum=i;
            while(tmp!=0){
                sum+=tmp%10;
                tmp=tmp/10;
            }
            if(sum==n) {
                sb.append(String.valueOf(i));
                break;
            }
        }
        if(sb.length()==0)
            sb.append("0");
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}