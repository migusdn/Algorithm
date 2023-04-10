import java.io.*;
import java.util.StringTokenizer;

public class Q3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] num = new int[42];
        int result=0;
        for(int i=0; i<10; i++){
            int tmp = Integer.parseInt(br.readLine())%42;
            if(num[tmp] == 0){
                result++;
                num[tmp]++;
            } else if(num[tmp] == -1){
                continue;
            } else{
                num[tmp] = -1;
            }
        }
        bw.write(result+"");
        bw.close();
        br.close();
    }
}
