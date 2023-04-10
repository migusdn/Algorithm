import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q11021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st=new StringTokenizer(br.readLine());
            bw.write("Case #"+(i+1)+": "+(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()))+"\n");
        }
        bw.close();
        br.close();
    }
}