import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=N; i<=M; i++){
            if(isPrime(i))
                sb.append(i).append("\n");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }
    public static boolean isPrime(int num){
        if(num<2)
            return false;
        for(int i=2; i*i<=num; i++){
            if(num%i==0)
                return false;
        }
        return true;
    }

}