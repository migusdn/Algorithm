import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1032 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        char[][] names = new char[n][];
        for(int i=0; i<n;i++){
            names[i] = br.readLine().toCharArray();
        }
        for(int i=0; i<names[0].length; i++){
            boolean flag = true;
            char c = names[0][i];
            for(int j=0;j<n;j++){
                if(c!=names[j][i]) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                sb.append(c);
            else
                sb.append("?");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}