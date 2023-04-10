import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int i=1;
        int j=1;
        int result=1;
        int sum=1;
        while(j!=n){
            if(sum==n){
                result++;
                j++;
                sum+=j;
            }else if(sum<n){
                j++;
                sum+=j;
            }else{
                sum-=i;
                i++;
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}