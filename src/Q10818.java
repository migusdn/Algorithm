import java.io.*;
import java.util.StringTokenizer;

public class Q10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int min=100000;
        int max=-1000000;
        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<t; i++){
            int tmp=Integer.parseInt(st.nextToken());
            if(tmp<min)
                min=tmp;
            if(tmp>max)
                max=tmp;
        }
        bw.write(min+" "+max);
        bw.close();
        br.close();
    }
}
